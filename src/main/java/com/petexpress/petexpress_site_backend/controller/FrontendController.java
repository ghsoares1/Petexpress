package com.petexpress.petexpress_site_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping({"/login"})
    public String login() {
        return "forward:/login.html";
    }

    @GetMapping({"/cadastrar", "/cadastro"})
    public String cadastrar() {
        return "forward:/cadastro.html";
    }

    @GetMapping({"/error"})
    public String error() {
        // Forward to index so users see the site instead of the Whitelabel error page
        return "forward:/index.html";
    }
}
