package com.codingbox.jpaproject.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.codingbox.jpaproject.domain.web.session.SessionConst;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		System.out.println("[인증체크 인터셉터 실행] : " + requestURI);
		
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER)==null) {
			//로그인 페이지 redirect
			response.sendRedirect("/login?redirectURL =" + requestURI);
			return false;
		}
		
		return true;
	}
}
