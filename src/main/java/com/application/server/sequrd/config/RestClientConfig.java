package com.application.server.sequrd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://www.google.com")
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add("username", "user");
                    httpHeaders.add("password", "admin");
                })
                .messageConverters(configurer -> configurer.add(new MappingJackson2HttpMessageConverter()))
                .build();
    }

}
