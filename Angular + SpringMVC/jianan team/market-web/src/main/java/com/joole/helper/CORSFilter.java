package com.joole.helper;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (request.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS) != null) {
			System.out.println("in if");
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
			response.addHeader("Access-Control-Allow-Credentials", "false");
			response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
			response.addHeader("Access-Control-Max-Age", "3600");

		}

		filterChain.doFilter(request, response);
	}
}
