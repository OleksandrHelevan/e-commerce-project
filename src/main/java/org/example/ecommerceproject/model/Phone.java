package org.example.ecommerceproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerceproject.enums.TechCondition;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelName;
    private int memoryCapacity;
    private int screenHertz;
    private float screenSize;
    private boolean isUsed;
    private int batteryCapacity;
    private float price;

    @Enumerated(EnumType.STRING)
    private TechCondition techCondition;
}
