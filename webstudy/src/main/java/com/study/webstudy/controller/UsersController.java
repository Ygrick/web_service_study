package com.study.webstudy.controller;

import com.study.webstudy.models.Progress;
import com.study.webstudy.models.Users;
import com.study.webstudy.repo.progressRepo;
import com.study.webstudy.repo.usersRepo;
import com.sun.javaws.IconUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UsersController {

    @Autowired
    private usersRepo usersRepo;
    @Autowired
    private com.study.webstudy.repo.progressRepo progressRepo;

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
        user = usersRepo.save(user);
        for (int i = 0; i < 8; i++) {
            String les = "Занятие №" +  String.valueOf(i+1);
            String lec = "Лекция №" + String.valueOf(i+1);
            Progress new_progress = new Progress(les, lec, null, null, null, null, Integer.toString(user.getId()));
            progressRepo.save(new_progress);
        }
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String progress(@PathVariable(value = "id") Integer id,
                           Model model) {
        if (!usersRepo.existsById(id)) {
            return "redirect:/";
        }
        Iterable<Progress> progress = progressRepo.findAll();
        model.addAttribute("progress", progress);

        Optional<Users> user = usersRepo.findById(id);
        ArrayList<Users> users = new ArrayList<>();
        user.ifPresent(users::add);
        model.addAttribute("user", users);

        return "user_info";
    }

}
