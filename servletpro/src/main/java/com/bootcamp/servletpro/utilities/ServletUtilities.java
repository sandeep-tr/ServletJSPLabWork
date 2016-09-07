package com.bootcamp.servletpro.utilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ServletUtilities {

	public static String findCookie(HttpServletRequest req, String cookieName) {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookieName.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;
	}
}
