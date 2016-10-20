package com.cyberdak.javadecompiler;

import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class ClassParser {
		public static void main(String[] args) throws Exception {
			String path = Thread.currentThread().getContextClassLoader().getResource("com/cyberdak/javadecompiler/App.class").getPath().toString();
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream input = new DataInputStream(fis);
			int magic = u4(input);
			if(magic == 0xcafebabe){
				System.out.println("valid class file.");
			}else{
				System.out.println("invalid class file.");
				return;
			}
			
			int minorVersion = u2(input);
			System.out.println("minorVersion:"+minorVersion);
			int majorVersion = u2(input);
			System.out.println("majorVersion："+majorVersion);
			int constantPoolCount = u2(input);
			System.out.println("constantPoolCount:"+constantPoolCount);
			
		}
		
		public static byte u1(DataInputStream input) throws Exception{
			return input.readByte();
		}
		
		public static short u2(DataInputStream input) throws Exception{
			return input.readShort();
		}
		
		private static int u4(DataInputStream input) throws IOException{
			return input.readInt();
		}
		
		public static long u8(DataInputStream input) throws Exception{
			return input.readLong();
		}
}
