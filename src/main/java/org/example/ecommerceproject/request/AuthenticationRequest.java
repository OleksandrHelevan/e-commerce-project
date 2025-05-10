package org.example.ecommerceproject.request;

import org.example.ecommerceproject.model.User;


public record AuthenticationRequest(String username, String password) {

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthenticationRequest(User user){
        this(user.getUsername(), user.getPassword());
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String username() {
        return username;
    }
}
