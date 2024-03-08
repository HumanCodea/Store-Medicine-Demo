package com.example.MedicineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.MedicineStore.model.Custormer;
import com.example.MedicineStore.service.CustormerService;

@Controller
public class CustormerController {

    @Autowired
    private CustormerService custormerService;
    
    @GetMapping("/login")
    public String PageSign(){
        return "loginUser";
    }

    @PostMapping("/saveUser")
    public String SaveNewUser(@ModelAttribute Custormer custormer){
        custormerService.SaveUser(custormer);
        return "redirect:/register?successfully";
    }

    @GetMapping("/register")
    public String PageRegister(){
        return "registerUser";
    }
    
    @GetMapping("/logout")
    public String LogoutUser(){
        return "redirect:/login";
    }
}
