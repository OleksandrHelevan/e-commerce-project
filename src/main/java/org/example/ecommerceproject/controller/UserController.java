package org.example.ecommerceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.dto.UserDTO;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/users"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        try {
            UserDTO user = userService.getUserByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping
//    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
//
//    }

    @GetMapping("") //TEMP
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
