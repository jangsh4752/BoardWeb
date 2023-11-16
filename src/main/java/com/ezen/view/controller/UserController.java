package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;
import com.ezen.biz.user.UserService;

@Controller
@SessionAttributes("loginUser")
public class UserController {

	@Autowired
	private UserService userService;
	
	// �α��� ȭ�� ǥ��
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		
		vo.setId("user1");
		vo.setPassword("user1");
		
		return "login.jsp";
	}
	
	// ����� ����
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session, Model model) {

	    if (vo.getId() == null || vo.getId().equals("")) {
	    	throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
	    }
	    
	    UserVO user = userService.getUser(vo);	// ����� ������ �˻��Ѵ�.

	    // 3.ȭ�� �׺���̼�
	    if(user != null) {
//	    	session.setAttribute("userName", user.getName());
	    	model.addAttribute("loginUser", user);
	    	
	        return "getBoardList.do";
	    } else {
	        return "login.jsp";
	    }
	}
	
	// �α׾ƿ�
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();
		
		return "login.jsp";	
	}
}







