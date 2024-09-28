package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        return "index"; // Render index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Render login.html
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Render index.html
    }
}
