package com.util;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Employee;
import com.entityResources.Resource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@Controller
@RequestMapping("/Employee")
public class EmpLogic {
	
	@GetMapping("/Login")
	@ResponseBody
	public String employeeLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		EntityManager em =Resource.getEntityManager().createEntityManager();
		System.out.println(email+" "+pwd);
		return "Login Called";
	}
	
	@PostMapping("/SignUp")
	@ResponseBody
	public ModelAndView employeeSignup(@RequestParam("name") String name, @RequestParam("age") Integer age ,
			 @RequestParam("email") String email, @RequestParam("pwd") String pwd,
			 @RequestParam("sal") int sal,@RequestParam("designation") String designation,
			 @RequestParam("doj") String joiningdate) {
		
		LocalDate doj=LocalDate.parse(joiningdate);
		
//		System.out.println(name+" "+age+" "+doj+" "+sal+" "+designation+" "+email+" "+pwd);
		
		EntityManager em = Resource.getEntityManager().createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Employee e = new Employee();
		e.setName(name);
		e.setAge(age);
		e.setDesignation(designation);
		e.setDoj(doj);
		e.setSal(sal);
		e.setEmail(email);
		e.setPwd(pwd);
		
		et.begin();
		em.persist(e);
		et.commit();
		
		ModelAndView m = new ModelAndView("Employee.jsp");
		m.addObject("status", "SignUp Completed Succesfully. You can now Login");
		
		
		return m;
	}
	
}
