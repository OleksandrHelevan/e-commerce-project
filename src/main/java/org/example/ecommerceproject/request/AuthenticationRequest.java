package org.example.ecommerceproject.request;

import org.example.ecommerceproject.model.User;


public record AuthenticationRequest(String username, String password) {

    public AuthenticationRequest(User user) {
        this(user.getUsername(), user.getPassword());
    }

}
