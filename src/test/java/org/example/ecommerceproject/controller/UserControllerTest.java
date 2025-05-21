package org.example.ecommerceproject.controller;

import org.example.ecommerceproject.dto.UserDTO;
import org.example.ecommerceproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetUser_WhenUserExists() {
        String username = "john_doe";
        UserDTO mockUser = new UserDTO();
        mockUser.setUsername(username);
        mockUser.setEmail("john@example.com");

        when(userService.getUserByUsername(username)).thenReturn(mockUser);

        ResponseEntity<UserDTO> response = userController.getUser(username);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(username, response.getBody().getUsername());
        assertEquals("john@example.com", response.getBody().getEmail());
    }
}
