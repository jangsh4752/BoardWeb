package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
//	@Pointcut("execution (* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 비즈니스 메소드 호출
		// returnObj - 비즈니스 메소드 실행 후 결과를 담는 변수
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		System.out.printf("메소드 %s() 수행에 걸린 시간:%d(ms)\n",
				method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
	}
}
