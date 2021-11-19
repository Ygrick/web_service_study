package com.study.webstudy.models;

import javax.persistence.*;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String lesson_name;
    private String lecture_name;
    private String lesson;
    private String lecture;
    private String id_user;

    public Progress(){}

    public Progress(Integer id, String lesson_name, String lecture_name, String lesson, String lecture, String id_user) {
        this.id = id;
        this.lesson_name = lesson_name;
        this.lecture_name = lecture_name;
        this.lesson = lesson;
        this.lecture = lecture;
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

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
