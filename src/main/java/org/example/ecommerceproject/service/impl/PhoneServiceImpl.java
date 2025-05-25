package org.example.ecommerceproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.dto.PhoneDTO;
import org.example.ecommerceproject.exception.NoSuchObjectException;
import org.example.ecommerceproject.mapper.PhoneMapper;
import org.example.ecommerceproject.model.Phone;
import org.example.ecommerceproject.repository.PhoneRepository;
import org.example.ecommerceproject.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public List<PhoneDTO> getAllPhones() {
         return phoneRepository.findAll().stream().map(PhoneMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PhoneDTO> getPhonesByModelName(String modelName) throws NoSuchObjectException{
        String convertedModelName = modelName.replaceAll("%20", " ");
        return phoneRepository
                .getPhonesByModelName(convertedModelName)
                .map(list -> list.stream().map(PhoneMapper::toDTO).toList())
                .orElseThrow(() -> new NoSuchObjectException("Phone not found with model: " + modelName));
    }
}

