package com.example.demo.annotation.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.annotation.TestAnnotation;

/**
 * 处理RedisLock注解的逻辑</br>
 * 
 * @author Robert 2020-8-17 11:34:10
 */
@Aspect
@Component
public class TestAnnotationAspect {


	/**
	 * 环绕加redis锁
	 * 
	 * @param pjp
	 * @param redisLock 切点
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "@annotation(testAnnotation)")
	public Object around(ProceedingJoinPoint pjp, TestAnnotation testAnnotation) throws Throwable {
		System.err.println("执行TestAnnotation注解");
		return pjp.proceed();
	}

}
