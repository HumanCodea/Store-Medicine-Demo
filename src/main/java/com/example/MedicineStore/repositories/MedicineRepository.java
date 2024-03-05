package com.example.MedicineStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MedicineStore.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

    @Query("Select m From Medicine m Where m.nameMedicine like %?1%")
    public List<Medicine> findMedicineByName(String nameMedicine);

}
