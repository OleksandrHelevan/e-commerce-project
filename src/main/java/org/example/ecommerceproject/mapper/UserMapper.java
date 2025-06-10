package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.dto.UserDTO;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.request.AuthenticationRequest;
import org.example.ecommerceproject.request.RegistrationRequest;

public class UserMapper {

    public static User fromRegistrationRequestToUser(RegistrationRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setBirthDate(request.birthDate());
        user.setSex(request.sex());
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setSex(user.getSex());
        return userDTO;
    }

    public static AuthenticationRequest fromRegistrationToAuthenticationRequest(RegistrationRequest request) {
        return new AuthenticationRequest(request.username(), request.password());
    }
}
