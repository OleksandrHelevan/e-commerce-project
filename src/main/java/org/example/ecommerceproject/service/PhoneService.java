package org.example.ecommerceproject.service;

import org.example.ecommerceproject.dto.PhoneDTO;
import org.example.ecommerceproject.exception.NoSuchObjectException;
import org.example.ecommerceproject.model.Phone;


import java.util.List;

public interface PhoneService {

    List<PhoneDTO> getAllPhones();

    List<PhoneDTO> getPhonesByModelName(String modelName) throws NoSuchObjectException;
}
