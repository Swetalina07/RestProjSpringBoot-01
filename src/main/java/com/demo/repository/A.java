package com.demo.repository;

public class A {
	public static A a;
	private A()
	{
		
	}
	public static A aaa()
	{
		if(a==null)
		{
		  a=new A();
		  return a;
		}
		return a;
		
	}
	

}
