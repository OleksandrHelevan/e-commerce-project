package org.example.ecommerceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.model.Phone;
import org.example.ecommerceproject.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/phones")
@RequiredArgsConstructor()
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("all")
    public ResponseEntity<List<Phone>> getAllPhones() {
        return new ResponseEntity<>(phoneService.getAllPhones(), HttpStatus.OK);
    }
}
