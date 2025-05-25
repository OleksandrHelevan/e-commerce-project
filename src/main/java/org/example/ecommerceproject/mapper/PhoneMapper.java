package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.dto.PhoneDTO;
import org.example.ecommerceproject.model.Phone;

public class PhoneMapper {

    public static PhoneDTO toDTO(Phone phone) {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setModelName(phone.getModelName());
        phoneDTO.setMemoryCapacity(phone.getMemoryCapacity());
        phoneDTO.setPrice(phone.getPrice());
        phoneDTO.setUsed(phone.isUsed());
        phoneDTO.setScreenHertz(phone.getScreenHertz());
        phoneDTO.setBatteryCapacity(phone.getBatteryCapacity());
        phoneDTO.setScreenSize(phone.getScreenSize());
        phoneDTO.setTechCondition(phone.getTechCondition());
        return phoneDTO;
    }

}
