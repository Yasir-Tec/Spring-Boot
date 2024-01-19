package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.demo.model.Student;
import com.demo.service.StudentService;

@Controller
@RequestMapping("/student")
public class studentController 
{

	@Autowired
	private StudentService sservice;
	
	@GetMapping("/students")
	public ModelAndView getStudents(HttpSession session)
	{
		List<Student> sslist = sservice.getAllStudents();
		System.out.println(sslist.toString());
		return new ModelAndView("displayStudent","sslist",sslist);
	}
	
	@GetMapping("/addStudent")
	public String addStudent(HttpSession session)
	{
		return "studentform";
	}
	
	
	@PostMapping("/insertStudent")
	public ModelAndView insertStudent(@RequestParam int sid,@RequestParam String sname,@RequestParam String email )
	{
		Student s = new Student(sid,sname,email);
		sservice.addnewstudent(s);
		return new ModelAndView("redirect:/student/students");
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView deleteStudent(@PathVariable int id)
	{
		sservice.deletestudent(id);
		return new ModelAndView("redirect:/student/students");
		
	}
	
	
	@GetMapping("edit/{id}")
	public ModelAndView editStudent(@PathVariable("id") int pid)
	{
		Student s=sservice.getById(pid);
		return new ModelAndView("editStudent","s",s);
	}
	
	@PostMapping("/updateStudent")
	public ModelAndView updateProdut(@RequestParam int sid, @RequestParam String sname,@RequestParam String email) {
		sservice.updateById(new Student(sid,sname,email));
		return new ModelAndView("redirect:/student/students");
	}
	
	@GetMapping("/students/price/{p1}/{p2}")
	public ModelAndView sortByPrice(@PathVariable int p1,@PathVariable int p2)
	{
		List<Student> slist = sservice.getByPrice(p1,p2);
		return new ModelAndView("displayStudent","sslist",slist);
	}
	
	
}
