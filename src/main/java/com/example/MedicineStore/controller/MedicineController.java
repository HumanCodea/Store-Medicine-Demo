package com.example.MedicineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MedicineStore.model.Medicine;
import com.example.MedicineStore.model.MyMedicine;
import com.example.MedicineStore.service.MedicineService;
import com.example.MedicineStore.service.MyMedicineService;

import java.util.List;

@Controller
@RequestMapping(path = "")
public class MedicineController {
    
    @Autowired
    private MedicineService medicineService;

    @Autowired
    private MyMedicineService myMedicineService;

    @GetMapping("/home")
    public String HomeUser(){
        return "homeUser";
    }

    @GetMapping("/homeAdmin")
    public String HomeAdmin(){
        return "homeAdmin";
    }

    @PostMapping("/save")
    public String AddMedicine(@ModelAttribute Medicine medicine){
        medicineService.SaveMedicine(medicine);
        return "redirect:/available_medicine";
    }

    @GetMapping("/available_medicine")
    public String ListMedicine(Model model, @Param("nameMedicine") String nameMedicine){
        List<Medicine> list = medicineService.getAllMedicine();
        if(nameMedicine != null){
            list = medicineService.findMedicineByName(nameMedicine);
            model.addAttribute("nameMedicine", nameMedicine);
        }
        model.addAttribute("medicine", list);
        return "listMedicine";
    }

    @GetMapping("/deleteList/{id}")
    public String DeleteMedicine(@PathVariable("id") int id){
        medicineService.DeleteMedicineById(id);
        return "redirect:/available_medicine";
    }

    @GetMapping("/medicine_register")
    public String RegisterMedicine(){
        return "registerMedicine";
    }

    @GetMapping("/editList/{id}")
    public String EditMedicine(@PathVariable("id") int id, Model model){
        Medicine medicine = medicineService.findMedicineById(id);
        model.addAttribute("medicine", medicine);
        return "editMedicine";
    }

    @GetMapping("/mylist/{id}")
    public String AddToMyMedicine(@PathVariable("id") int id){
        Medicine newMedicine = medicineService.findMedicineById(id);
        MyMedicine myMedicine = new MyMedicine(newMedicine.getId(), newMedicine.getNameMedicine(), newMedicine.getTypeMedicine(), newMedicine.getIngredient(), newMedicine.getManufactureDate(), newMedicine.getExpiryDate(), newMedicine.getPrices());
        myMedicineService.SaveMyMedicine(myMedicine);
        return "redirect:/my_medicine";
    }

}
