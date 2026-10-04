package com.util;

import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.Query;

@Controller
@RequestMapping("/Employee")
public class EmpLogic {
	
	@GetMapping("/Login")
	@ResponseBody
	public ModelAndView employeeLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		EntityManager em =Resource.getEntityManager().createEntityManager();
		
		Query q = em.createQuery("select e from Employee e where e.email= :email and e.pwd= :pwd");
		q.setParameter("email", email);
		q.setParameter("pwd", pwd);
		
		List<Employee> emp = q.getResultList();
		
		if(!emp.isEmpty()) {
			
			Employee e = emp.get(0);
			ModelAndView m = new ModelAndView("Dashboard.jsp");
			m.addObject("emp",e);
			return m ;
		}
		else {
			ModelAndView m = new ModelAndView("EmployeeSignin.jsp");
			m.addObject("status", "->Incorrect Credentials<-  (Please Try Again)");
			return m;
		}
	}
	
	@PostMapping("/SignUp")
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
	
	@PostMapping("/Update")
	public ModelAndView update(@RequestParam("name") String name, @RequestParam("age") Integer age ,
			 @RequestParam("email") String email, @RequestParam("pwd") String pwd,
			 @RequestParam("sal") Double sal,@RequestParam("designation") String designation,
			 @RequestParam("doj") String joiningdate, @RequestParam("id") Integer id) {
		
		LocalDate doj=LocalDate.parse(joiningdate);
		
		EntityManager em = Resource.getEntityManager().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setAge(age);
		e.setDesignation(designation);
		e.setEmail(email);
		e.setPwd(pwd);
		e.setSal(sal);
		e.setDoj(doj);
		
		et.begin();
		em.merge(e);
		et.commit();
		
		String response = name+"- Your Profile Updated successfuly";
		
		ModelAndView m = new ModelAndView("Employee.jsp");
		m.addObject("status", response);
		return m;
	}
	
}
