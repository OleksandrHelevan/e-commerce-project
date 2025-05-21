package org.example.ecommerceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.dto.UserDTO;
import org.example.ecommerceproject.exception.NoSuchObjectException;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/user"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        try {
            UserDTO user = userService.getUserByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchObjectException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all") //TEMP
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
