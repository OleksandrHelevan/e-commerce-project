package org.example.ecommerceproject.service;

import org.example.ecommerceproject.dto.UserDTO;
import org.example.ecommerceproject.exception.NoAuthenticatedTokenException;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.request.AuthenticationRequest;
import org.example.ecommerceproject.request.RegistrationRequest;

import java.util.List;

public interface UserService {
    String verify(AuthenticationRequest request) throws NoAuthenticatedTokenException;
    List<User> getAllUsers();//TEMP
    RegistrationRequest register(RegistrationRequest request);
    UserDTO getUserByUsername(String username);
}

