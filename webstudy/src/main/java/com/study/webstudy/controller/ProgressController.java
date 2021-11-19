package com.study.webstudy.controller;

import com.study.webstudy.models.Progress;
import com.study.webstudy.models.Users;
import com.study.webstudy.repo.progressRepo;
import com.study.webstudy.repo.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProgressController {

    @Autowired
    private progressRepo progressRepo;
    @Autowired
    private usersRepo usersRepo;


    @GetMapping("/progress/edit")
    public String progress(Model model){
        Iterable<Progress> progress = progressRepo.findAll();
        Iterable<Users> users = usersRepo.findAll();
        model.addAttribute("progress", progress);
        model.addAttribute( "users", users);
        return "progress_edit";
    }

//    @GetMapping("/progress/{id}/edit")
//    public String progressEdit(@PathVariable(value = "id") Integer id,
//                               Model model){
//        if(!usersRepo.existsById(id)){
//            return "redirect:/";
//        }
//        Optional<Users> user = usersRepo.findById(id);
//        ArrayList<Users> users = new ArrayList<>();
//        user.ifPresent(users::add);
//        model.addAttribute("user", users);
//        return "progress_edit";
//    }
}
