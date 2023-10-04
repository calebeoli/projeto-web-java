package com.senai.primeiraaplicacaoweb.controller;

import com.senai.primeiraaplicacaoweb.model.UserModel;
import com.senai.primeiraaplicacaoweb.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/usuarios")
public class UserController {

    @Autowired
    private UserSevice userSevice;

    @GetMapping(value = "/formulario")
    public String RegisterUsers(){
        return "users/register";
    }

    @PostMapping(value = "/cadastrar")
    public String saveUser(UserModel userModel) {
        userSevice.save(userModel);
        return "redirect:/usuarios/listar";
    }




    @GetMapping(value = "/listar")
    public String ListALLUsers(Model model){
        List<UserModel> listUser = userSevice.findall();
        model.addAttribute("users",listUser);
        return "users/list";
    }

    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable Long id, Model model){
        Optional<UserModel> user = userSevice.findbyid(id);

        if(user.isPresent()){
            model.addAttribute("user",user.get());
            return "users/update";
        }else {
            return "redirect:/usuarios/listar";
        }

    }

    @PostMapping(value = "/alterar/{id}")
    public String updateUser(@PathVariable Long id, UserModel userModel){
        Optional <UserModel> user = userSevice.findbyid(id);
        if (user.isPresent()){
            userSevice.save(userModel);
            return "redirect:/usuarios/listar";
        }else {
            return "redirect:/usuarios/listar";
        }
    }

    @GetMapping (value = "/delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        userSevice.deletebyId(id);
        return "redirect:/usuarios/listar";
    }

}
