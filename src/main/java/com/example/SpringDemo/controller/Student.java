package com.example.SpringDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Student {

    @GetMapping("/getform")
    public String getForm(Model model) {
        return "form"; // returns form.html
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String gender,
                             Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("gender", gender);
        return "formSuccess"; // returns formSuccess.html
    }
}
