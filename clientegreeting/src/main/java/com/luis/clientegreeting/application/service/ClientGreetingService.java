package com.luis.clientegreeting.application.service;

import com.luis.clientegreeting.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientGreetingService {

    @Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public ClientGreetingService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
    }

    //invoke to greeting-service and return a Greeting object
    public Greeting greeting (String name) {
        return restTemplate.getForObject(serviceUrl + "/greeting/{name}", Greeting.class, name);
    }
}
