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
	
	@RequestMapping(method= RequestMethod.GET, value="/login") //���� doGet���� Get�����
	public String loginForm() {
		return "login";
	}
	@RequestMapping(method=RequestMethod.POST, value="/reallogin") //������ ��� ����,�̰� doPost
	public String login(String id,String pwd,HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd",pwd);
		boolean result=service.isMember(map);
		if(result) {//����ȸ���� �´°��- ���ǿ� �����ؾ��� - 
			session.setAttribute("id", id);
			return "redirect:/";//������������ �̵�
		}else {
			return "login";//�α��� �������� �̵�
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
