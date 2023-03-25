package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String , Student> studentdb = new HashMap<>();
    HashMap<String , Teacher> teacherdb = new HashMap<>();
    HashMap<String , List<String>> student_teacherdb = new HashMap<>();

    public void addStudent(Student student){
        studentdb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherdb.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student , String teacher){
        if(student_teacherdb.containsKey(teacher)){
            List<String> teacher_list = student_teacherdb.get(teacher);
            teacher_list.add(student);
            student_teacherdb.put(teacher,teacher_list);
        }else{
            List<String> teacher_list = new ArrayList<>();
            teacher_list.add(student);
            student_teacherdb.put(teacher,teacher_list);
        }
    }
    public Student getStudentByName(String name){
        return studentdb.get(name);
    }
    public Teacher getTeacherByName(String name){
        return  teacherdb.get(name);
    }
    public List<String> getStudentByTeacherName(String teacher){
        return student_teacherdb.get(teacher);
    }
    public List<String> getAllStudent(){
        List<String> list = new ArrayList<>();
        for(String s : studentdb.keySet()){
            list.add(s);
        }
        return list;
    }
    public void deleteTeacherByName(String teacher){
        List<String> student_list = student_teacherdb.get(teacher);
        for(String s : student_list){
            studentdb.remove(s);
        }
        teacherdb.remove(teacher);
        student_teacherdb.remove(teacher);
    }
    public void deleteAllTeachers() {
        for (List<String> student_list : student_teacherdb.values()) {
            for (String s : student_list) {
                studentdb.remove(s);
            }
            teacherdb.clear();
            student_teacherdb.clear();
        }
    }
}