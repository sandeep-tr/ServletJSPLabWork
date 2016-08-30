package com.bootcamp.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bootcamp.objects.User;
import com.bootcamp.utilities.HibernateUtilities;

public class Main {
	public static void main(String[] args) {
		System.out.println("Checking Hibernate Session Factory");
		try {
			Session session = HibernateUtilities.getSessionFactory().openSession();
			// -- INSERT
			session.beginTransaction();

			User user = new User();
			user.setName("Sandeep");
			user.setGoal(250);
			session.save(user);

			session.getTransaction().commit();

			// -- SELECT
			session.beginTransaction();

			User savedUser = (User) session.get(User.class, 1);
			savedUser.setTotal(savedUser.getTotal() + 50);
			System.out.println(savedUser);

			session.getTransaction().commit();

			session.close();
			HibernateUtilities.getSessionFactory().close();
		} catch (HibernateException hbe) {
			System.out.println(hbe);
		}
	}
}
