package com.example.MedicineStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MedicineStore.model.MyMedicine;

@Repository
public interface MyMedicineRepository extends JpaRepository<MyMedicine, Integer> {
    
    @Query("Select m From MyMedicine m Where m.nameMedicine like %?1%")
    public List<MyMedicine> findMyMedicineByName(String nameMedicine);
    
}
