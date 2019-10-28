package com.joole.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TokenInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("in Interceptor");

		// pre flight request check
		if (request.getHeader("Access-Control-Request-Headers") != null) {
			System.out.println("in if");
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Credentials", "false");
			response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
			response.addHeader("Access-Control-Max-Age", "3600");

			return true;

		}
		String authorization = request.getHeader("Authorization");

		System.out.println(authorization);

//
		if (authorization == null || !authorization.startsWith("Bearer ")) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
			return false;
		}
		// if token has, validate token
		String token = authorization.substring(7);
		try {
			request.setAttribute("user", Jwt.parseJwt(token));
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
			return false;
		}
		System.out.println("after filter");
		return true;
	}

}
