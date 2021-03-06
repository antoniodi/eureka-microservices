package com.luis.clientegreeting.application.controller;

import com.luis.clientegreeting.application.service.ClientGreetingService;
import com.luis.clientegreeting.domain.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientGreetingController {

    protected ClientGreetingService helloWorldService;

    public ClientGreetingController(ClientGreetingService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping("/greeting")
    public String goHome() {
        return "index";
    }


    @RequestMapping("/greeting/{name}")
    public String greeting(Model model, @PathVariable("name") String name) {
        Greeting greeting = helloWorldService.greeting(name);
        model.addAttribute("greeting", greeting.getContent());
        return "greeting";
    }
}
