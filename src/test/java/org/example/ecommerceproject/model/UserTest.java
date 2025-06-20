package org.example.ecommerceproject.model;

import org.example.ecommerceproject.enums.Sex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testAllArgsConstructorAndAllGetters() {
        User user = new User(
                1L,
                "Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        assertEquals(1L, user.getId());
        assertEquals("Oleksandr", user.getUsername());
        assertEquals("1234qwer", user.getPassword());
        assertEquals("oleksandr@example.com", user.getEmail());
        assertEquals("+380981093088", user.getPhone());
        assertEquals("03-03-2000", user.getBirthDate());
        assertEquals(Sex.MALE, user.getSex());
    }

    @Test
    void testNoArgsConstructorAndAllSetters() {
        User user = new User();

        user.setId(1L);
        user.setUsername("Oleksandr");
        user.setPassword("1234qwer");
        user.setEmail("oleksandr@example.com");
        user.setPhone("+380981093088");
        user.setBirthDate("03-03-2000");
        user.setSex(Sex.MALE);

        assertEquals(1L, user.getId());
        assertEquals("Oleksandr", user.getUsername());
        assertEquals("1234qwer", user.getPassword());
        assertEquals("oleksandr@example.com", user.getEmail());
        assertEquals("+380981093088", user.getPhone());
        assertEquals("03-03-2000", user.getBirthDate());
        assertEquals(Sex.MALE, user.getSex());
    }

    @Test
    void testEqualsAndHashCode() {
        User user1 = new User(
                1L,
                "Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        User user2 = new User(
                1L,
                "Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testToString() {
        User user = new User(
                1L,
                "Oleksandr",
                "1234qwer",
                "+380981093088",
                "oleksandr@example.com",
                "03-03-2000",
                Sex.MALE);

        String expected = "User(id=1, username=Oleksandr, password=1234qwer," +
                " phone=+380981093088, email=oleksandr@example.com, birthDate=03-03-2000, sex=MALE)";
        assertEquals(expected, user.toString());
    }
}

