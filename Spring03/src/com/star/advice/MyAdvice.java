package com.star.advice;

public class MyAdvice {
//	String name,int id
     public void mybefore() {
    	 System.out.println("前置方法");
     }
     public void myafter() {
    	 System.out.println("后置方法");
     }
     public void mythrow() {
    	 System.out.println("异常");
     }
     public void myaftering() {
    	 System.out.println("后置方法2");
     }
}
