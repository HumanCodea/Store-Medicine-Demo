package com.example.MedicineStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.MedicineStore.model.MyMedicine;
import com.example.MedicineStore.service.MyMedicineService;

@Controller
public class MyMedicineController {
    
    @Autowired
    private MyMedicineService myMedicineService;

    @GetMapping("/my_medicine")
    public String ListMyMedicine(Model model){
        List<MyMedicine> list = myMedicineService.getAllMyMedicine();
        model.addAttribute("medicine", list);
        return "myMedicine";
    }

    @GetMapping("/deleteMyList/{id}")
    public String DeleteMyMedicine(@PathVariable("id") int id){
        myMedicineService.DeleteMyMedicineById(id);
        return "redirect:/my_medicine";
    }

}
