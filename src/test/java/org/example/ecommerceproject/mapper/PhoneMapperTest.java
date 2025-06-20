package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.dto.PhoneDTO;
import org.example.ecommerceproject.enums.TechCondition;
import org.example.ecommerceproject.model.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneMapperTest {
    @Test
    void testToDto(){
        Phone phone = new Phone(
                1L,
                "iPhone 13",256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );

        PhoneDTO expected = new PhoneDTO("iPhone 13",
                256,
                60,
                4.8f,
                true,
                11000,
                470,
                TechCondition.LIKE_NEW
        );

        PhoneDTO actual = PhoneMapper.toDTO(phone);

        assertEquals(actual, expected);
    }
}
