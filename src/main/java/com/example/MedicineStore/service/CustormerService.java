package com.example.MedicineStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MedicineStore.model.Custormer;
import com.example.MedicineStore.repositories.CustormerRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class CustormerService implements UserDetailsService{
    
    @Autowired
    private CustormerRepository custormerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Custormer> custormers = custormerRepository.findByUsername(username);
        String password = null;
        List<GrantedAuthority> authorities = null;

        if(custormers.isEmpty()){
            throw new UsernameNotFoundException("UserDetails not found username = " + username);
        }

            username = custormers.get(0).getUsername();
            password = custormers.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(custormers.get(0).getRoles()));


        return new User(username, password, authorities);
    }

    public void SaveUser(Custormer custormer){
        String password = passwordEncoder.encode(custormer.getPassword());
        custormer.setPassword(password);
        custormerRepository.save(custormer);
    }

}
