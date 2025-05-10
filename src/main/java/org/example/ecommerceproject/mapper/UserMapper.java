package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.request.RegistrationRequest;

public class UserMapper {

    public static User fromRequestToClient(RegistrationRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setBirthDate(request.birthDate());
        user.setSex(request.sex());
        return user;
    }
}
