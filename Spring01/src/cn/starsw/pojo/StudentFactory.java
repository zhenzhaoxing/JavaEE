package cn.starsw.pojo;

public class StudentFactory {
  public static Student newInstance(){
	  return new Student(11000, "甄兆星");
  }
}
