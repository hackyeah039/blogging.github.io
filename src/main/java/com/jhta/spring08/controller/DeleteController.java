package com.jhta.spring08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.service.MembersService;

@Controller
public class DeleteController {
	@Autowired
	private MembersService service;
	
	@RequestMapping("/delete") //한번삭제해야하는데 여러번삭제가 될수있다. 리다이렉트로
	public String delete(int num) {
		int result=service.delete(num);
		if(result>0) {
			return "redirect:/list";//리다이렉트방식으로 이동하기
		}else {
			return "error";
		}
	}
}
