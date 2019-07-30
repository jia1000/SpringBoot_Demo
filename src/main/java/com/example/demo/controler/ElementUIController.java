package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/element_ui")
public class ElementUIController {

    @RequestMapping("/button")
    public String showElementButton() {
        return "element_ui/ele_button";
    }

    @RequestMapping("/link")
    public String showElementLink() {
        return "element_ui/ele_link";
    }
}
