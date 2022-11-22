package com.example.consultadeventas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping
    public String Login(){
        return "Hola Mundo";
    }
}
