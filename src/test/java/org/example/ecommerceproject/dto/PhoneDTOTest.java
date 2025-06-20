package org.example.ecommerceproject.dto;

import org.example.ecommerceproject.enums.TechCondition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneDTOTest {

    @Test
    void testAllArgsConstructorAndGetters(){
        PhoneDTO phoneDTO = new PhoneDTO("iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );

        assertEquals("iPhone 13", phoneDTO.getModelName());
        assertEquals(256, phoneDTO.getMemoryCapacity());
        assertEquals(60, phoneDTO.getScreenHertz());
        assertEquals(4.8f, phoneDTO.getScreenSize());
        assertTrue(phoneDTO.isUsed());
        assertEquals(11000, phoneDTO.getBatteryCapacity());
        assertEquals(470, phoneDTO.getPrice());
        assertEquals(TechCondition.LIKE_NEW, phoneDTO.getTechCondition());
    }

    @Test
    void testNoArgsConstructorAndSetters(){
        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setModelName("iPhone 13");
        phoneDTO.setMemoryCapacity(256);
        phoneDTO.setScreenHertz(60);
        phoneDTO.setScreenSize(4.8f);
        phoneDTO.setUsed(true);
        phoneDTO.setBatteryCapacity(11000);
        phoneDTO.setPrice(470);
        phoneDTO.setTechCondition(TechCondition.LIKE_NEW);

        assertEquals("iPhone 13", phoneDTO.getModelName());
        assertEquals(256, phoneDTO.getMemoryCapacity());
        assertEquals(60, phoneDTO.getScreenHertz());
        assertEquals(4.8f, phoneDTO.getScreenSize());
        assertTrue(phoneDTO.isUsed());
        assertEquals(11000, phoneDTO.getBatteryCapacity());
        assertEquals(470, phoneDTO.getPrice());
        assertEquals(TechCondition.LIKE_NEW, phoneDTO.getTechCondition());
    }

    @Test
    void testEquals(){
        PhoneDTO phoneDTO1 = new PhoneDTO("iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );
        PhoneDTO phoneDTO2 = new PhoneDTO("iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );

        assertEquals(phoneDTO1, phoneDTO2);
    }

    @Test
    void testHashCode(){
        PhoneDTO phoneDTO1 = new PhoneDTO("iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );
        PhoneDTO phoneDTO2 = new PhoneDTO("iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );

        assertEquals(phoneDTO1.hashCode(), phoneDTO2.hashCode());
    }
    @Test
    void testToString(){
        PhoneDTO phoneDTO = new PhoneDTO("iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );

        String expected = "PhoneDTO(modelName=iPhone 13, memoryCapacity=256, " +
                "screenHertz=60, screenSize=4.8, isUsed=true, batteryCapacity=11000, price=470.0, techCondition=LIKE_NEW)";

        assertEquals(expected, phoneDTO.toString());
    }

}
