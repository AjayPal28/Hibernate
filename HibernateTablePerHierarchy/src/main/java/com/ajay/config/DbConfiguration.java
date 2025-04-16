package com.ajay.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ajay.entity.Contract_Employee;
import com.ajay.entity.Employee;
import com.ajay.entity.Regular_Employee;

public class DbConfiguration {
	private static volatile SessionFactory sessionFactory = null;

	private DbConfiguration() {

	}

	private static Properties getProperties() {

		Properties prop = new Properties();
		prop.setProperty("hibernate.connection.url",
				"jdbc:mysql://localhost:3306/hibernate?useSSL=false&allowPublicKeyRetrieval=true");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.connection.password", "root");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "create");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");

		return prop;

	}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			synchronized (SessionFactory.class) {
				if (sessionFactory == null) {
					sessionFactory = new Configuration().addProperties(getProperties())
							.addAnnotatedClass(Employee.class).addAnnotatedClass(Regular_Employee.class)
							.addAnnotatedClass(Contract_Employee.class).buildSessionFactory();
				}
			}
		}
		return sessionFactory;

	}
}
