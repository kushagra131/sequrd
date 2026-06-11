package com.application.server.sequrd.controller.home;

import com.application.server.sequrd.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


/**
 * <p> REST API's Security Best Practices following <b>OWASP Secure</b> Coding Standards. </p>
 * <p><b> 1. REQUEST's Input Validations / Sanitization: </b></p>
 * <p> - Whitelisting prioritizing safe inputs by using an allowlist of trusted inputs. </p>
 * <p> - Boundary Checks preventing Buffer Overflow attacks. </p>
 * <p> - Character Escaping mitigating Cross-Site Scripting (XSS) attacks. </p>
 * <p> - Numeric Range Checks & Data Type Validation ensuring data integrity and accuracy. </p>
 * <p> - Null Byte / Newline checks preventing exploits. </p>
 * <p> - Path / Character Encoding checks preventing Path Traversal attacks by using URL encoding. </p>
 * <p><b> 2. REQUEST's Encoding: </b></p>
 * <p> - XSS Encoding prevents Cross-Site Scripting (XSS) attacks by using HTML entity encoding, JavaScript and CSS encoding. </p>
 * <p> - SQL Injection Encoding prevents SQL Injection attacks by using parameterized queries. </p>
 * <p><b> 3. Authentication, Authorization (Session Tokens / JWT's, 2FA, SSO, OAuth 2.0) & Password Management (BCrypt, SCrypt & PBKDF2): </b></p>
 * <p> - Password Hashing prevents brute force attacks by using a one-way hash function. </p>
 * <p> - Salt & Iteration Counts preventing dictionary attacks by using a random salt and a high iteration count. </p>
 * <p> - Storing Passwords in a Secure Storage. </p>
 * <p><b> 4. Session Management: </b></p>
 * <p> - Session Tokens preventing session fixation attacks by using a random token. </p>
 * <p> - Session Expiration & Invalidation. </p>
 * <p> - JWT Token Expiration & Invalidation. </p>
 * <p> - Managing Concurrent Sessions / Logins. </p>
 * <p> - Concurrent Session Management with Redis & JWT Token Expiration & Invalidation. </p>
 * <p> - Rate Limiting to prevent DDoS attacks. </p>
 * <p><b> 5. Logging & Error Handling: </b></p>
 * <p> - Logging all requests and errors to a centralized log file. </p>
 */
@RestController
@RequestMapping("/api/v1/home")
public class HomeController {

    private final HomeService homeService;
    
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/details")
    public ResponseEntity<?> getDetails() {
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
