package com.demo.consumer.resttemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class RestTemplateClient {

    private final RestTemplate restTemplate;

    private static final String PROVIDED_URL="http://localhost:8081";

    public String getInstanceInfo(){
        return restTemplate.getForObject(PROVIDED_URL+"/instance-info",String.class);
    }
}
