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
	
	@RequestMapping("/delete") //�ѹ������ؾ��ϴµ� ������������ �ɼ��ִ�. �����̷�Ʈ��
	public String delete(int num) {
		int result=service.delete(num);
		if(result>0) {
			return "redirect:/list";//�����̷�Ʈ������� �̵��ϱ�
		}else {
			return "error";
		}
	}
}
