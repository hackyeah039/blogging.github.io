package com.jhta.spring08.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.dao.MyUsersDao;

@Controller
public class LogOutController {
	@Autowired
	private MyUsersDao dao;
	
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
