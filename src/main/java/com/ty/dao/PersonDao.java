package com.ty.dao;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Person;

public class PersonDao {
  public EntityManager getEntityManger() {
	  EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	  EntityManager entityManager=entityManagerFactory.createEntityManager();
	  return entityManager;

  }
  public void savePerson(Person person) {
	  EntityManager entityManager=getEntityManger();
	  EntityTransaction entityTransaction=entityManager.getTransaction();
	  entityTransaction.begin();
	  entityManager.persist(person);
	  entityTransaction.commit();
  }
  public void updatePerson(String email,Person person) {
	  EntityManager entityManager=getEntityManger();
	  EntityTransaction entityTransaction=entityManager.getTransaction();
	  Person person2=entityManager.find(Person.class, email);
	  
	  if(person2!=null) {
		  person.setEmail(email);
		  entityTransaction.begin();
		  entityManager.merge(person);
		  entityTransaction.commit();
	  }else {
		  System.out.println("id is not present");
	  }
	 
  }
  public String loginPerson(String email) {
	  EntityManager entityManager=getEntityManger();
	  String jpql=("select p from Person p where p.email=?1");
	  Query query= entityManager.createQuery(jpql);
	  query.setParameter(1, email);
	  Person person=(Person) query.getSingleResult();
	  
	  return person.getPassword();
	  
	  
  }
}
