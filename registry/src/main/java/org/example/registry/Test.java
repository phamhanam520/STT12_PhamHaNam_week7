package org.example.registry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Value("${eureka.client.fetch-registry:default-value}")
    private String message;

    @GetMapping("/test")
    public String test() {
        return message;
    }
}
