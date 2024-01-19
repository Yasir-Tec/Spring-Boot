package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface StudentService {

	List<Student> getAllStudents();

	void addnewstudent(Student s);

	void deletestudent(int sid);

	Student getById(int pid);

	void updateById(Student student);

	List<Student> getByPrice(int p1, int p2);

}
