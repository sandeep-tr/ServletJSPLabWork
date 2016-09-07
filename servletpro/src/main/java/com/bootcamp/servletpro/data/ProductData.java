package com.bootcamp.servletpro.data;

import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.bootcamp.servletpro.objects.Product;
import com.bootcamp.servletpro.utilities.HibernateUtilities;

public class ProductData {

	private static final String HQL_FETCH_USER_PRODUCTS = "select product from Product product, User user where product.userId = user.userId and product.userId = :userId";
	private static final String HQL_FETCH_ALL_PRODUCTS = "from Product";

	public List<Product> fetchUserProducts(int userId) {

		Session session = null;
		try {
			session = HibernateUtilities.getSessionFactory().openSession();
			Query query = session.createQuery(HQL_FETCH_USER_PRODUCTS).setInteger("userId", userId);
			List<Product> products = query.list();

			return products;
		} catch (HibernateException hbe) {
			System.out.println("HibernateException in fetchUserProducts - " + hbe);
		} catch (Exception exe) {
			System.out.println("Exception in fetchUserProducts - " + exe);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return Collections.emptyList();
	}

	public List<Product> fetchAllProducts() {

		Session session = null;
		try {
			session = HibernateUtilities.getSessionFactory().openSession();
			Query query = session.createQuery(HQL_FETCH_ALL_PRODUCTS);
			List<Product> products = query.list();

			return products;
		} catch (HibernateException hbe) {
			System.out.println("HibernateException in fetchAllProducts - " + hbe);
		} catch (Exception exe) {
			System.out.println("Exception in fetchAllProducts - " + exe);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return Collections.emptyList();
	}
}
