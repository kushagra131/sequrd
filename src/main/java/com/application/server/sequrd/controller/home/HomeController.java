package com.application.server.sequrd.controller.home;

import com.application.server.sequrd.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


/**
 * REST API's Security Best Practices following OWASP secure coding standards.
 * 1. REQUEST's Input Validations / Sanitization:
 *      - Whitelisting prioritizing safe inputs by using an allowlist of trusted inputs.
 *      - Boundary Checks preventing Buffer Overflow attacks.
 *      - Character Escaping mitigating Cross-Site Scripting (XSS) attacks.
 *      - Numeric Range Checks & Data Type Validation ensuring data integrity and accuracy.
 *      - Null Byte / Newline checks preventing exploits.
 *      - Path / Character Encoding checks preventing Path Traversal attacks by using URL encoding.
 * 2. REQUEST's Encoding:
 *      - XSS Encoding prevents Cross-Site Scripting (XSS) attacks by using HTML entity encoding, JavaScript and CSS encoding.
 *      - SQL Injection Encoding prevents SQL Injection attacks by using parameterized queries.
 * 3. Authentication, Authorization (Session Tokens / JWT's, 2FA, SSO, OAuth 2.0) & Password Management (BCrypt, SCrypt & PBKDF2):
 *      - Password Hashing prevents brute force attacks by using a one-way hash function.
 *      - Salt & Iteration Counts preventing dictionary attacks by using a random salt and a high iteration count.
 *      - Storing Passwords in a Secure Storage.
 * 4. Session Management:
 *      - Session Tokens preventing session fixation attacks by using a random token.
 *      - Session Expiration & Invalidation.
 *      - JWT Token Expiration & Invalidation.
 *      - Managing Concurrent Sessions / Logins.
 *      - Concurrent Session Management with Redis & JWT Token Expiration & Invalidation.
 *      - Rate Limiting to prevent DDoS attacks.
 * 5. Logging & Error Handling:
 *      
 */
@RestController
@RequestMapping("/api/v1")
public class HomeController {

    private final HomeService homeService;
    
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
