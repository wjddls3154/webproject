package kr.ac.dit.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

@Override

public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,

Object handler) throws Exception {

HttpSession httpSession = httpServletRequest.getSession();

if(httpSession.getAttribute("login")==null) {

httpServletResponse.sendRedirect("/member/login");

return false;

}

return true;

}

}