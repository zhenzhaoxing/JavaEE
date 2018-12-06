package com.star.advice;

import org.springframework.aop.ThrowsAdvice;
/*必须实现ThrowsAdvice接口
 * 
 * 方法名必须是afterThrowing 然后抛出个异常
 * */
public class Mythrow implements ThrowsAdvice {
  public void afterThrowing(Exception ex) throws Throwable {
	  System.out.println("执行异常通知");
  }
}
