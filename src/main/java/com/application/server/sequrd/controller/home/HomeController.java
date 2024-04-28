package com.application.server.sequrd.controller.home;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<?> home() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("title", "SEQURD.io");

        return ResponseEntity
                .ofNullable(model);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String body) {
        return ResponseEntity
                .created(URI.create(body))
                .body("Login Works with Body: " + body);
    }
}
