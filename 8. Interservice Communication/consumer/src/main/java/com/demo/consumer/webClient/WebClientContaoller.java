package com.demo.consumer.webClient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/web-client")
public class WebClientContaoller {

    private final ProviderWebClient providerWebClient;

    @GetMapping("/instance")
    public Mono<String> getInstance(){
//        WebClient webClient=WebClient.create();
//        Mono<String> response=webClient.get()
//                .uri("http://localhost:8081/instance-info")
//                .retrieve()
//                .bodyToMono(String.class);
//        return response;
        return providerWebClient.getInstanceInfo();
    }
}
