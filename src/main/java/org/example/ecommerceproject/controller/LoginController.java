package org.example.ecommerceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.exception.NoAuthenticatedTokenException;
import org.example.ecommerceproject.request.AuthenticationRequest;
import org.example.ecommerceproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest request) {
        try {
            return new ResponseEntity<>(userService.verify(request), HttpStatus.OK);
        } catch (NoAuthenticatedTokenException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
