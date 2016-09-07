package com.bootcamp.servletpro.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.bootcamp.servletpro.objects.User;
import com.bootcamp.servletpro.utilities.HibernateUtilities;

public class UserData {

	private static final String HQL_VALIDATE_USER = "from User user where user.userName = :userName and user.password = :password";

	public User validateUser(String userName, String password) {

		Session session = null;
		try {
			session = HibernateUtilities.getSessionFactory().openSession();
			Query query = session.createQuery(HQL_VALIDATE_USER).setString("userName", userName).setString("password",
					password);

			List<User> users = query.list();
			if (users.size() > 0) {
				return users.get(0);
			}
		} catch (HibernateException hbe) {
			System.out.println("HibernateException in validateUser - " + hbe);
		} catch (Exception exe) {
			System.out.println("Exception in validateUser - " + exe);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
}
