package org.example.ecommerceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.dto.PhoneDTO;
import org.example.ecommerceproject.exception.NoSuchObjectException;
import org.example.ecommerceproject.model.Phone;
import org.example.ecommerceproject.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/phones")
@RequiredArgsConstructor()
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("")
    public ResponseEntity<List<PhoneDTO>> getAllPhones() {
        return new ResponseEntity<>(phoneService.getAllPhones(), HttpStatus.OK);
    }

    @GetMapping("{modelName}")
    public ResponseEntity<List<Phone>> getPhonesByModelName(@PathVariable String modelName) {
        try {
            return new ResponseEntity<>(phoneService.getPhonesByModelName(modelName), HttpStatus.OK);
        } catch (NoSuchObjectException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
