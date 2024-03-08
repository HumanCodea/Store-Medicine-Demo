package com.example.MedicineStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MedicineStore.model.Custormer;

import java.util.List;

@Repository
public interface CustormerRepository extends JpaRepository<Custormer, Integer>{
    public List<Custormer> findByUsername(String username);
}
