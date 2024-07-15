package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DialogBoxController {

    @GetMapping("/home")
    public String showDialogBox() {
        return "form";
    }
}
