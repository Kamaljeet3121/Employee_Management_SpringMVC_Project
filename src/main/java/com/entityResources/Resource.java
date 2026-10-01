package com.entityResources;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Resource {
	private static final EntityManagerFactory entityManagerFactory = 
					Persistence.createEntityManagerFactory("SpringMVCproject");
				
	
	public static EntityManagerFactory getEntityManager() {
		return entityManagerFactory;
	}
	
}
