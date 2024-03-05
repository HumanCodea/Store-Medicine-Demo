package com.example.MedicineStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Medicine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_medicine")
    private String nameMedicine;
    private String typeMedicine;
    private String ingredient;
    private String manufactureDate;
    private String expiryDate;
    private String prices;
    
    public Medicine() {
    }

    public Medicine(String nameMedicine, String typeMedicine, String ingredient, String manufactureDate,
            String expiryDate, String prices) {
        this.nameMedicine = nameMedicine;
        this.typeMedicine = typeMedicine;
        this.ingredient = ingredient;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.prices = prices;
    }

}
