package org.example.ecommerceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.exception.NoAuthenticatedTokenException;
import org.example.ecommerceproject.mapper.UserMapper;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.request.RegistrationRequest;
import org.example.ecommerceproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        User user = UserMapper.fromRegistrationRequestToUser(request);
        user.setPassword(encoder.encode(user.getPassword()));
        userService.register(new RegistrationRequest(user));
        try {
            return new ResponseEntity<>(userService.verify(UserMapper.fromRegistrationToAuthenticationRequest(request)),
                    HttpStatus.CREATED);
        } catch (NoAuthenticatedTokenException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
