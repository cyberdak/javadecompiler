package com.cyberdak.javadecompiler;

import java.util.ArrayList;
import java.util.List;

public class App extends Foo implements Boo {
	private static final String NAME = "private static final";
	public static final String PUBLIC_NAME = "public static final";
	
	private String contcat(){
		int a = 10;
		return a+"";
	}
	
	private synchronized String StringPlus(){
		String a = "xzca";
		String b = "asdjkhzxc";
		return a + b;
	}
	
	private void foreach(){
		List<String> stringList = new ArrayList<>();
		stringList.add("x");
		stringList.add("y");
		stringList.add("z");
		for(String str : stringList){
			System.out.println(str);
		}
	}
	
	public static void throwException() throws NullPointerException{
		
	}

	public static void catchException(){
		try {
			System.out.println("catch");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void qqq(String q) {
		// TODO Auto-generated method stub
		
	}
}
