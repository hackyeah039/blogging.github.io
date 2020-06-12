package com.jhta.spring08.controller;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.service.MyUsersService;

@Controller
public class LoginController {
	@Autowired
	private MyUsersService service;
	
	@RequestMapping(method= RequestMethod.GET, value="/login") //예전 doGet같이 Get방식임
	public String loginForm() {
		return "login";
	}
	@RequestMapping(method=RequestMethod.POST, value="/reallogin") //순서는 상관 없음,이건 doPost
	public String login(String id,String pwd,HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd",pwd);
		boolean result=service.isMember(map);
		if(result) {//가입회원이 맞는경우- 세션에 저장해야함 - 
			session.setAttribute("id", id);
			return "redirect:/";//메인페이지로 이동
		}else {
			return "login";//로그인 페이지로 이동
		}
	}
	
	@RequestMapping(value="logout",method= RequestMethod.GET)
	public String logout(HttpSession session) {
		Enumeration se = session.getAttributeNames();

		if(se.hasMoreElements()) {
			session.invalidate();
			return "redirect:/";
		}else {
			return "error";
		}
	}
	
}
