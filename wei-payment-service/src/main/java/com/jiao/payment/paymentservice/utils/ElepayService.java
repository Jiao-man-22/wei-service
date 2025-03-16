package com.jiao.payment.paymentservice.utils;

import com.alibaba.fastjson2.JSON;
import okhttp3.*;
import okio.BufferedSink;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ElepayService {

    private final OkHttpClient client = new OkHttpClient();
    private final String apiKey;
    private final String apiUrl;

    public ElepayService(String apiKey, String apiUrl) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    // 创建支付请求
    public String createPayment(String amount, String currency, String description) throws IOException {
        String url = apiUrl + "charges";
        MediaType mediaType = MediaType.parse("application/json");
        Map<String, String> payload = new HashMap<>();
        payload.put("amount", amount);
        payload.put("currency", currency);
        payload.put("description", description);

        // 定义请求体内容
        String json = JSON.toJSONString(payload);

        // 创建 RequestBody
        RequestBody body = new RequestBody() {
            @Override
            public MediaType contentType() {
                return mediaType;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8(json);
            }
        };
        // 构建请求
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
