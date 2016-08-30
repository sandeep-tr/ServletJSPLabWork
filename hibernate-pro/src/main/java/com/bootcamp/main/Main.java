package com.bootcamp.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.bootcamp.utilities.HibernateUtilities;

public class Main {
	public static void main(String[] args) {
		System.out.println("Checking Hibernate Session Factory");
		try {
			SessionFactory session = HibernateUtilities.getSessionFactory();
			session.openSession();
			session.close();
		} catch (HibernateException hbe) {
			System.out.println(hbe);
		}
	}
}
