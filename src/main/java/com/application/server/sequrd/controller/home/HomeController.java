package com.application.server.sequrd.controller.home;

import com.application.server.sequrd.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    private HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public ResponseEntity<?> home() {
        return ResponseEntity
                .ofNullable(homeService.getHomeDetails());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String body) {
        return ResponseEntity
                .created(URI.create(body))
                .body("Login Works with Body: " + body);
    }
}
