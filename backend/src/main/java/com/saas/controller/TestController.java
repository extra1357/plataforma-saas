// src/main/java/com/saas/backend/controller/TestController.java
package com.saas.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/protected")
    public String getProtectedData() {
        return "Olá! Você acessou uma rota protegida com sucesso.";
    }

}