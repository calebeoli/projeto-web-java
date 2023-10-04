package com.senai.primeiraaplicacaoweb.service;

import com.senai.primeiraaplicacaoweb.model.UserModel;
import com.senai.primeiraaplicacaoweb.repository.UserRepository;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSevice {
    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> findall(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findbyid(Long id){
        return userRepository.findById(id);
    }
    public void deletebyId(Long id){
        userRepository.deleteById(id);
    }

}

