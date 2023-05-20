package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    Set<Student> studentSet = new HashSet<>();
    Set<Teacher> teacherSet = new HashSet<>();
    Map<String,List<String>> map = new HashMap<>();
    public void addStudent(Student student) {
        studentSet.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teacherSet.add(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        map.computeIfAbsent(teacher,t -> new ArrayList<String>());
        map.get(teacher).add(student);
    }

    public Student getStudentByName(String name) {
        for(Student student : studentSet)if(student.getName().equals(name))return student;
        return null;
    }

    public Teacher getTeacherByName(String name) {
        for(Teacher teacher : teacherSet)if(teacher.getName().equals(name))return teacher;
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return map.get(teacher);
    }

    public List<String> getAllStudents() {
        List<String> list = new ArrayList<>();
        for(Student student : studentSet)list.add(student.getName());
        return list;
    }

    public void deleteTeacherByName(String teacher) {
        teacherSet.remove(teacher);
        map.remove(teacher);
    }

    public void deleteAllTeachers() {
        map.clear();
        teacherSet.clear();
    }
}
