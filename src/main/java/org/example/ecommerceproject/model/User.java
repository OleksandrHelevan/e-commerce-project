package org.example.ecommerceproject.model;


import jakarta.persistence.*;
import lombok.Data;
import org.example.ecommerceproject.enums.Sex;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

}
