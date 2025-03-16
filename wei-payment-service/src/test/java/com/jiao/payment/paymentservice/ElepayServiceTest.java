package com.jiao.payment.paymentservice;


import com.jiao.payment.paymentservice.utils.ElepayService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ElepayServiceTest {

    private String apiKey = "11111111111";

    private String apiUrl = "https://api.elepay.io/v1/";

    @Test
    public void testCreatePayment() throws IOException {
        ElepayService elepayService = new ElepayService(apiKey, apiUrl);
        String response = elepayService.createPayment("100", "JPY", "Test Payment");
//        assertNotNull(response);
        System.out.println("Payment response: " + response);
    }
}