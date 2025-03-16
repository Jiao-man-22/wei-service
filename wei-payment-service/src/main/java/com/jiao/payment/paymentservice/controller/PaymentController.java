package com.jiao.payment.paymentservice.controller;

/**
 * @author 29359
 */

import com.jiao.payment.paymentservice.utils.ElepayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {



    private final ElepayService elepayService;

    public PaymentController(@Value("${elepay.api-key}") String apiKey,
                             @Value("${elepay.api-url}") String apiUrl) {
        this.elepayService = new ElepayService(apiKey, apiUrl);
    }

    @PostMapping("/create")
    public String createPayment(@RequestParam String amount,
                                @RequestParam String currency,
                                @RequestParam String description) throws IOException, IOException {
        return elepayService.createPayment(amount, currency, description);
    }
}

