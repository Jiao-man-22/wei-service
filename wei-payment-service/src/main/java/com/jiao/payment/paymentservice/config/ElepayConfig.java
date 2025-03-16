package com.jiao.payment.paymentservice.config;

/**
 * @author 29359
 */

import com.jiao.payment.paymentservice.utils.ElepayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "elepay")
public class ElepayConfig {

    @Value("${elepay.api-key}")
    private String apiKey;
    @Value("${elepay.api-url}")
    private String apiUrl;
    private String webhookSecret;

    @Bean
    public ElepayService elepayService() {
        // 从配置文件中获取 apiKey 和 apiUrl
        return new ElepayService(apiKey, apiUrl);
    }

    // Getters and Setters
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getWebhookSecret() {
        return webhookSecret;
    }

    public void setWebhookSecret(String webhookSecret) {
        this.webhookSecret = webhookSecret;
    }
}
