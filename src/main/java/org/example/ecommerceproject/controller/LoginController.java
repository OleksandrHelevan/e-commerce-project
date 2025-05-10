package org.example.ecommerceproject.controller;

import org.example.ecommerceproject.exception.NoAuthenticatedTokenException;
import org.example.ecommerceproject.mapper.UserMapper;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.request.AuthenticationRequest;
import org.example.ecommerceproject.request.RegistrationRequest;
import org.example.ecommerceproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class LoginController {

    @Autowired
    private UserService userService;


    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public ResponseEntity<RegistrationRequest> register(@RequestBody RegistrationRequest request) {
        User user = UserMapper.fromRequestToClient(request);
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.register(new RegistrationRequest(user)), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest request) {
        try {
            return new ResponseEntity<>(userService.verify(request), HttpStatus.OK);
        } catch (NoAuthenticatedTokenException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
