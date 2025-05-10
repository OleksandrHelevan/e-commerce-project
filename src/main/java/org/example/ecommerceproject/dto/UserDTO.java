package org.example.ecommerceproject.dto;

import lombok.Data;
import org.example.ecommerceproject.enums.Sex;

@Data
public class UserDTO {
    private String username;
    private String phone;
    private String email;
    private String birthDate;
    private Sex sex;
}
