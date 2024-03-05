package com.example.MedicineStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.MedicineStore.model.Medicine;
import com.example.MedicineStore.repositories.MedicineRepository;

@Service
public class MedicineService {
    
    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    public void DeleteMedicineById(int id){
        medicineRepository.deleteById(id);
    }

    public Medicine findMedicineById(int id){
        return medicineRepository.findById(id).get();
    }

    public void SaveMedicine(Medicine medicine){
        medicineRepository.save(medicine);
    }

    public List<Medicine> findMedicineByName(String nameMedicine){
        return medicineRepository.findMedicineByName(nameMedicine);
    }
}
