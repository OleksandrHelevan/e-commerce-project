package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.dto.UserDTO;
import org.example.ecommerceproject.enums.Sex;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.request.AuthenticationRequest;
import org.example.ecommerceproject.request.RegistrationRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    @Test
    void testFromRegistrationRequestToUser() {
        RegistrationRequest testRegistrationRequest = new RegistrationRequest(
                "Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        User expectedUser = new User(
                null,
                "Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        User actualUser = UserMapper.fromRegistrationRequestToUser(testRegistrationRequest);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testToDto() {
        User testUser = new User(
                1L,
                "Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        UserDTO expectedUserDto = new UserDTO(
                "Oleksandr",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        UserDTO actualUserDto = UserMapper.toDTO(testUser);

        assertEquals(expectedUserDto, actualUserDto);
    }

    @Test
    void testFromRegistrationToAuthenticationRequest(){
        RegistrationRequest request = new RegistrationRequest("Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        AuthenticationRequest expectedRequest = new AuthenticationRequest("Oleksandr",
                "1234qwer");

        AuthenticationRequest actualRequest = UserMapper.fromRegistrationToAuthenticationRequest(request);

        assertEquals(expectedRequest, actualRequest);
    }

}
