package org.example.ecommerceproject.service.impl;

import org.example.ecommerceproject.exception.NoSuchObjectException;
import org.example.ecommerceproject.model.Phone;
import org.example.ecommerceproject.repository.PhoneRepository;
import org.example.ecommerceproject.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;


    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneByModelName(String modelName) throws NoSuchObjectException{
        return phoneRepository
                .getPhoneByModelName(modelName)
                .orElseThrow(() -> new NoSuchObjectException("Phone not found with model: " + modelName));
    }
}

