package com.pessoas.pessoaservice.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = HealthController.BASE_URL)
public class HealthController {
    public static final String BASE_URL = "/health";

    @GetMapping("")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("Pessoa API is up and running");
    }

}
