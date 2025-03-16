package com.jiao.payment.paymentservice.controller;

/**
 * @author 29359
 */

import com.jiao.payment.paymentservice.config.ElepayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

    private final ElepayConfig elepayConfig;

    @Autowired
    public WebhookController(ElepayConfig elepayConfig) {
        this.elepayConfig = elepayConfig;
    }

    @PostMapping
    public void handleWebhook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String payload = request.getReader().lines().reduce("", String::concat);
        String signature = request.getHeader("X-Elepay-Signature");

        // 验证签名
        if (!verifySignature(payload, signature)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // 处理通知内容
        System.out.println("Webhook payload: " + payload);

        response.setStatus(HttpServletResponse.SC_OK);
    }

    private boolean verifySignature(String payload, String signature) {
        try {
            String expectedSignature = Base64.getEncoder().encodeToString((elepayConfig.getWebhookSecret() + payload).getBytes());
            return signature.equals(expectedSignature);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
