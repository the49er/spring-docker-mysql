package com.docker.xmpl.springdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {

    @GetMapping("/docker")
    public String hello() {
        return "Hello from Docker 17";
    }
}
