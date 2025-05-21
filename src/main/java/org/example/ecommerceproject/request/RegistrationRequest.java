package org.example.ecommerceproject.request;

import org.example.ecommerceproject.enums.Sex;
import org.example.ecommerceproject.model.User;

public record RegistrationRequest(String username,
                                  String password,
                                  String phone,
                                  String email,
                                  String birthDate,
                                  Sex sex) {

    public RegistrationRequest(User user) {
        this(user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail(), user.getBirthDate(), user.getSex());
    }

}
