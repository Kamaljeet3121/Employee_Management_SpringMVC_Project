package com.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entityResources.Resource;

import jakarta.persistence.EntityManager;

@Controller
@RequestMapping("/Employee")
public class EmpLogic {
	
	@GetMapping("/Login")
	@ResponseBody
	public String employeeLogin() {
		EntityManager em =Resource.getEntityManager().createEntityManager();
		System.out.println("Hi");
		return "Login Called";
	}
	
}
