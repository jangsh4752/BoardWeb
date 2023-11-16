package com.ezen.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
@ControllerAdvice("com.ezen.view")  // 예외처리 클래스 등록
public class CommonExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e) {
		ModelAndView modelView = new ModelAndView();
		
		modelView.addObject("exception", e);
		modelView.setViewName("/common/arithmeticError.jsp");
		
		return modelView;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e) {
		ModelAndView modelView = new ModelAndView();
		
		modelView.addObject("exception", e);
		modelView.setViewName("/common/nullPointerError.jsp");
		
		return modelView;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView handleIllegalArgumentException(Exception e) {
		ModelAndView modelView = new ModelAndView();
		
		modelView.addObject("exception", e);
		modelView.setViewName("/common/argumentError.jsp");
		
		return modelView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView modelView = new ModelAndView();
		
		modelView.addObject("exception", e);
		modelView.setViewName("/common/error.jsp");
		
		return modelView;
	}
}
*/
