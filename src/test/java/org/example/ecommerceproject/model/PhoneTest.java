package org.example.ecommerceproject.model;

import org.example.ecommerceproject.enums.TechCondition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneTest {

    @Test
    void testAllArgsConstructorAndAllGetters() {
        Phone phone = new Phone(1L,
                "iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW);

        assertEquals(1L, phone.getId());
        assertEquals("iPhone 13", phone.getModelName());
        assertEquals(256, phone.getMemoryCapacity());
        assertEquals(60, phone.getScreenHertz());
        assertEquals(4.8f, phone.getScreenSize());
        assertTrue(phone.isUsed());
        assertEquals(11000, phone.getBatteryCapacity());
        assertEquals(470, phone.getPrice());
        assertEquals(TechCondition.LIKE_NEW, phone.getTechCondition());
    }

    @Test
    void testNoArgsConstructorAndAllSetters() {
        Phone phone = new Phone();

        phone.setId(1L);
        phone.setModelName("iPhone 13");
        phone.setMemoryCapacity(256);
        phone.setScreenHertz(60);
        phone.setScreenSize(4.8f);
        phone.setUsed(true);
        phone.setBatteryCapacity(11000);
        phone.setPrice(470);
        phone.setTechCondition(TechCondition.LIKE_NEW);

        assertEquals(1L, phone.getId());
        assertEquals("iPhone 13", phone.getModelName());
        assertEquals(256, phone.getMemoryCapacity());
        assertEquals(60, phone.getScreenHertz());
        assertEquals(4.8f, phone.getScreenSize());
        assertTrue(phone.isUsed());
        assertEquals(11000, phone.getBatteryCapacity());
        assertEquals(470, phone.getPrice());
        assertEquals(TechCondition.LIKE_NEW, phone.getTechCondition());
    }

    @Test
    void testEquals() {
        Phone phone1 = new Phone(1L,
                "iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW);

        Phone phone2 = new Phone(1L,
                "iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW);

        assertEquals(phone1, phone2);
    }

    @Test
    void testHashCode() {
        Phone phone1 = new Phone(1L,
                "iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW);

        Phone phone2 = new Phone(1L,
                "iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW);

        assertEquals(phone1.hashCode(), phone2.hashCode());
    }

    @Test
    void testToString() {
        Phone phone = new Phone(1L,
                "iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW);

        String expected = "Phone(id=1, modelName=iPhone 13, memoryCapacity=256, " +
                "screenHertz=60, screenSize=4.8, isUsed=true, batteryCapacity=11000, " +
                "price=470.0, techCondition=LIKE_NEW)";

        assertEquals(expected, phone.toString());
    }
}
