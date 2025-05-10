package org.example.ecommerceproject.request;

import org.example.ecommerceproject.enums.Sex;
import org.example.ecommerceproject.model.User;

public record RegistrationRequest(String username,
                                  String password,
                                  String phone,
                                  String email,
                                  String birthDate,
                                  Sex sex) {

    public RegistrationRequest(String username, String password, String phone, String email, String birthDate, Sex sex) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public RegistrationRequest(User user) {
        this(user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail(), user.getBirthDate(), user.getSex());
    }


    @Override
    public String username() {
        return username;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String phone() {
        return phone;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String birthDate() {
        return birthDate;
    }

    @Override
    public Sex sex() {
        return sex;
    }
}
