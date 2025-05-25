package org.example.ecommerceproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerceproject.enums.TechCondition;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private String modelName;
    private int memoryCapacity;
    private int screenHertz;
    private float screenSize;
    private boolean isUsed;
    private int batteryCapacity;
    private float price;
    private TechCondition techCondition;
}
