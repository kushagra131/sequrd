package com.application.server.sequrd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://www.google.com")
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.addAll(headers());
                })
                .build();
    }

    @Bean
    public MultiValueMap<String, String> headers() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("username", "user");
        headers.add("password", "admin");
        return headers;
    }
}
