package com.clrvynt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.clrvynt.domain.User;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	// Look up user information from session/cache using token or whatever
	// methodology you use.

	// This example uses a session.
	User user = (User) request.getSession().getAttribute("loggedInUser");
	if (user == null) {
	    response.sendRedirect("/home.html");
	    return false;
	}

	return true;

    }

}
