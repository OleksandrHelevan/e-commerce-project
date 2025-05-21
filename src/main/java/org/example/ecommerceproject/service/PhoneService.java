package org.example.ecommerceproject.service;

import org.example.ecommerceproject.exception.NoSuchObjectException;
import org.example.ecommerceproject.model.Phone;


import java.util.List;

public interface PhoneService {

    List<Phone> getAllPhones();

    List<Phone> getPhonesByModelName(String modelName) throws NoSuchObjectException;
}
