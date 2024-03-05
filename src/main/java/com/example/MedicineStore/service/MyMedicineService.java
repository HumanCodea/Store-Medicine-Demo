package com.example.MedicineStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MedicineStore.model.MyMedicine;
import com.example.MedicineStore.repositories.MyMedicineRepository;

@Service
public class MyMedicineService {
    
    @Autowired
    private MyMedicineRepository myMedicineRepository;

    public List<MyMedicine> getAllMyMedicine(){
        return myMedicineRepository.findAll();
    }

    public void DeleteMyMedicineById(int id){
        myMedicineRepository.deleteById(id);
    }

    public void SaveMyMedicine(MyMedicine myMedicine){
        myMedicineRepository.save(myMedicine);
    }
}
