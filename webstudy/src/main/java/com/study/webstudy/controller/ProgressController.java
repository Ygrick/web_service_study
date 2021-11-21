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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProgressController {

    @Autowired
    private progressRepo progressRepo;
    @Autowired
    private usersRepo usersRepo;


    @GetMapping("/progress_lessons/edit")
    public String progress_lessons(Model model){
        Iterable<Progress> progress = progressRepo.findAll();
        Iterable<Users> users = usersRepo.findAll();
        model.addAttribute("progress", progress);
        model.addAttribute( "users", users);
        return "progress_lessons_edit";
    }

    @GetMapping("/progress_lectures/edit")
    public String progress_lectures(Model model){
        Iterable<Progress> progress = progressRepo.findAll();
        Iterable<Users> users = usersRepo.findAll();
        model.addAttribute("progress", progress);
        model.addAttribute( "users", users);
        return "progress_lectures_edit";
    }

    @PostMapping("/progress_lessons/edit")
    public String updateLesson(@RequestParam Integer id,
                               @RequestParam Integer lesson,
                               @RequestParam String visit_lesson,
                               Model model){
        Progress lesson_update = progressRepo.findById(id).orElseThrow(null);
        lesson_update.setLesson(lesson);
        lesson_update.setVisit_lesson(visit_lesson);
        progressRepo.save(lesson_update);
        return "redirect:/progress_lessons/edit";
    }
    @PostMapping("/progress_lectures/edit")
    public String updateLecture(@RequestParam Integer id,
                                @RequestParam Integer lecture,
                                @RequestParam String visit_lecture,
                                Model model){
        Progress lecture_update = progressRepo.findById(id).orElseThrow(null);
        lecture_update.setLecture(lecture);
        lecture_update.setVisit_lecture(visit_lecture);
        progressRepo.save(lecture_update);
        return "redirect:/progress_lectures/edit";
    }

}
