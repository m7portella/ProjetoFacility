package br.com.facility.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class EntityManagerFactorySingleton {

	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getInstance(){
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("ORACLE");
		}
		return emf;
	}
	
}
