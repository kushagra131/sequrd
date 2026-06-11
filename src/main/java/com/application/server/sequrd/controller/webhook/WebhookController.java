package com.application.server.sequrd.controller.webhook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/webhook")
public class WebhookController {

    @GetMapping("")
    public ResponseEntity<?> get() {
        return ResponseEntity
                .ok("WebHook Controller Works!!");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody String body) {
        return ResponseEntity
                .created(URI.create(body))
                .body("Register Works with Body: " + body);
    }
}
