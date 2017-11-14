package com.ruida.eurekardc;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/test/")
    public String testi() {
        return "response from eureka-controller-王绪楠";
    }

    @RequestMapping("/test/{{fallback}}")
    @HystrixCommand(fallbackMethod = "helloFallbackMethod")
    public String test(
            @PathVariable("fallback") String fallback
    ) {
        System.out.println("test");
        if ("1".equals(fallback)) {
            throw new RuntimeException(",,;;=ij12e");
        }
        return "test test hello world";
    }

    public String helloFallbackMethod(String fallback) {
        return "fallback 参数值为 " + fallback;
    }
}
