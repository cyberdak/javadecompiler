package com.cyberdak.javadecompiler;

import java.util.ArrayList;
import java.util.List;

public class App extends Foo implements Boo {
	private static final String NAME = "private static final";
	public static final String PUBLIC_NAME = "public static final";

	public static final String CONSTANT = "qps";

	private int count;
	private Integer size;
	private double x = 1D;

	public static String getNAME() {
		return NAME;
	}

	public static String getPublicName() {
		return PUBLIC_NAME;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

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
		System.out.println(CONSTANT);
		try {
			System.out.println("catch");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void qqq(final String q) {
		long l = 1l;
		System.out.println(l);
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(q);
			}
		});
	}

	public void qq1q(final String q) {
		String s = "abc";
		System.out.println(s);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(q);

			}
		});
	}
}
