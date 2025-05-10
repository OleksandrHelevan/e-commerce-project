package org.example.ecommerceproject.service;

import org.example.ecommerceproject.model.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhones();
    Phone getPhoneByModelName(String modelName);
}
