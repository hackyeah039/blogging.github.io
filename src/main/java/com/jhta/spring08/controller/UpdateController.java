package com.jhta.spring08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.service.MembersService;
import test.vo.MembersVo;
@Controller
public class UpdateController {
	@Autowired
	private MembersService service;
	
	@RequestMapping("/realUpdate")
	public String realUpdate(MembersVo vo) {
		if(vo==null) {
			return "error";
		}else {
			int n=service.update(vo);
			return "redirect:/list"; //컨트롤러로 이동
		}
	}
	@RequestMapping("/update")
	public ModelAndView update(int num) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("num",num);
		mv.setViewName("update");
		return mv;
	}
}
