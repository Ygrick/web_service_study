package com.study.webstudy.models;

import javax.persistence.*;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String lesson_name;
    private String lecture_name;
    private Integer lesson;
    private Integer lecture;
    private String visit_lesson;
    private String visit_lecture;
    private String id_user;

    public Progress(){}


    public Progress(String lesson_name, String lecture_name, Integer lesson, Integer lecture, String visit_lesson, String visit_lecture, String id_user) {
        this.lesson_name = lesson_name;
        this.lecture_name = lecture_name;
        this.lesson = lesson;
        this.lecture = lecture;
        this.visit_lesson = visit_lesson;
        this.visit_lecture = visit_lecture;
        this.id_user = id_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public String getLecture_name() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name = lecture_name;
    }

    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    public Integer getLecture() {
        return lecture;
    }

    public void setLecture(Integer lecture) {
        this.lecture = lecture;
    }

    public String getVisit_lesson() {
        return visit_lesson;
    }

    public void setVisit_lesson(String visit_lesson) {
        this.visit_lesson = visit_lesson;
    }

    public String getVisit_lecture() {
        return visit_lecture;
    }

    public void setVisit_lecture(String visit_lecture) {
        this.visit_lecture = visit_lecture;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
