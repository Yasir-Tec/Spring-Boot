package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDao;
import com.demo.model.Student;
@Service
public class StudentServiceImpl implements StudentService
{
	
	@Autowired
	private StudentDao sdao;

	@Override
	public List<Student> getAllStudents() {
	
		
		return sdao.findAll();
	}

	@Override
	public void addnewstudent(Student s) {
		
		sdao.save(s);
		
	}

	@Override
	public void deletestudent(int sid) {
		
		sdao.deleteById(sid);
		
	}

	@Override
	public Student getById(int pid) {
		
		return sdao.getById(pid);
	}

	@Override
	public void updateById(Student student) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.setSid(student.getSid());
		s.setSname(student.getSname());
		s.setEmail(student.getEmail());
		sdao.save(s);
	}

	@Override
	public List<Student> getByPrice(int p1, int p2) {
		List<Student> slist = sdao.findByPrice(p1,p2);
		return slist;
	}
}
