package net.amir.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class TemplatesController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
