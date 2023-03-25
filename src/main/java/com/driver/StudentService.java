package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public void addStudent(Student student){
        repository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        repository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student , String teacher){
        repository.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String name){
        return repository.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return repository.getTeacherByName(name);
    }
    public List<String> getStudentByTeacherName(String teacher){
        return repository.getStudentByTeacherName(teacher);
    }
    public List<String> getAllStudents(){
        return repository.getAllStudent();
    }
    public void deleteTeacherByName(String teacher){
        repository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        repository.deleteAllTeachers();
    }
}