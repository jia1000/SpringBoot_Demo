package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping("/test_exception")
    public void testExceptionMethod() {
        int i = 1 / 0;
    }
}
