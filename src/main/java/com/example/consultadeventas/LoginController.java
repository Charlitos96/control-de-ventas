package com.example.consultadeventas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String sayHello(@RequestParam(value = "user", defaultValue = "Usuario") String name) {
        return String.format("Validando: %s, espere por favor...", name);
    }

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }
}
