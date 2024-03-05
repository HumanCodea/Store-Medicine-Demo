package com.example.MedicineStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyMedicine {
    
    @Id
    private int id;
    @Column(name = "name_medicine")
    private String nameMedicine;
    private String typeMedicine;
    private String ingredient;
    private String manufactureDate;
    private String expiryDate;
    private String prices;
    
    public MyMedicine() {
    }

    public MyMedicine(int id, String nameMedicine, String typeMedicine, String ingredient, String manufactureDate,
            String expiryDate, String prices) {
        this.id = id;
        this.nameMedicine = nameMedicine;
        this.typeMedicine = typeMedicine;
        this.ingredient = ingredient;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.prices = prices;
    }

}
