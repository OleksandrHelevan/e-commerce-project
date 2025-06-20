package org.example.ecommerceproject.dto;

import org.example.ecommerceproject.enums.Sex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        UserDTO userDTO = new UserDTO("Oleksandr",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        assertEquals("Oleksandr", userDTO.getUsername());
        assertEquals("oleksandr@example.com", userDTO.getEmail());
        assertEquals("+380981093088", userDTO.getPhone());
        assertEquals("03-03-2000", userDTO.getBirthDate());
        assertEquals(Sex.MALE, userDTO.getSex());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername("Oleksandr");
        userDTO.setEmail("oleksandr@example.com");
        userDTO.setPhone("+380981093088");
        userDTO.setBirthDate("03-03-2000");
        userDTO.setSex(Sex.MALE);

        assertEquals("Oleksandr", userDTO.getUsername());
        assertEquals("oleksandr@example.com", userDTO.getEmail());
        assertEquals("+380981093088", userDTO.getPhone());
        assertEquals("03-03-2000", userDTO.getBirthDate());
        assertEquals(Sex.MALE, userDTO.getSex());
    }

    @Test
    void testEquals() {
        UserDTO userDTO1 = new UserDTO("Oleksandr",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        UserDTO userDTO2 = new UserDTO("Oleksandr",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        assertEquals(userDTO1, userDTO2);
    }

    @Test
    void testHashCode() {
        UserDTO userDTO1 = new UserDTO("Oleksandr",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        UserDTO userDTO2 = new UserDTO("Oleksandr",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    void testToString() {
        UserDTO userDTO = new UserDTO("Oleksandr",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);
        String expected = "UserDTO(username=Oleksandr, phone=+380981093088, " +
                "email=oleksandr@example.com, birthDate=03-03-2000, sex=MALE)";
        assertEquals(expected, userDTO.toString());
    }

}
