package com.study.webstudy.controller;

import com.study.webstudy.models.Users;
import com.study.webstudy.repo.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UsersController {

    @Autowired
    private usersRepo usersRepo;

    @GetMapping("/users")
    public String usersPage(Model model){
        Iterable<Users> users = usersRepo.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }

    @GetMapping("/users/add")
    public String usersAdd(Model model){
        return "users_add";
    }

    @PostMapping("/users/add")
    public String usersPost(@RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String groupp,
                            Model model){
        Users user = new Users(name, surname, groupp);
        usersRepo.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String progress(@PathVariable(value = "id") Integer id,
                           Model model) {
        if (!usersRepo.existsById(id)) {
            return "redirect:/";
        }
        Optional<Users> user = usersRepo.findById(id);
        ArrayList<Users> users = new ArrayList<>();
        user.ifPresent(users::add);
        model.addAttribute("user", users);
        return "user_info";
    }

}
