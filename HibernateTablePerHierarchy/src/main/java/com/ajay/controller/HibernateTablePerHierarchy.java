package com.ajay.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ajay.config.DbConfiguration;
import com.ajay.entity.Contract_Employee;
import com.ajay.entity.Employee;
import com.ajay.entity.Regular_Employee;

public class HibernateTablePerHierarchy {
	public static void main(String[] args) {

		Employee e1 = new Employee();
		e1.setName("Gaurav Chawla");

		Regular_Employee e2 = new Regular_Employee();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);

		Contract_Employee e3 = new Contract_Employee();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		Transaction transaction = null;
		
		try (Session session = DbConfiguration.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.persist(e1);
			session.persist(e2);
			session.persist(e3);
			
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
