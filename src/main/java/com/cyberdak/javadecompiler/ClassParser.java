package com.cyberdak.javadecompiler;

import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

public class ClassParser {
    private final static byte CONSTANT_CLASS = 7;
    private final static byte CONSTANT_FIELDREF = 9;
    private final static byte CONSTANT_METHODREF = 10;
    private final static byte CONSTANT_INTERFACE = 11;
    private final static byte CONSTANT_STRING = 8;
    private final static byte CONSTANT_INTEGER = 3;
    private final static byte CONSTANR_FLOAT = 4;
    private final static byte CONSTANT_LONG = 5;
    private final static byte CONSTANT_DOUBLE = 6;
    private final static byte CONSTANT_NAME_AND_TYPE = 12;
    private final static byte CONSTANT_UTF_8 = 1;
    private final static byte CONSTANT_METHOD_HANDLE = 15;
    private final static byte CONSTANT_METHOD_TYPE = 16;
    private final static byte CONSTANT_INVOKE_DYNAMIC = 18;
    
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
        byte tag;
        for(int index = 1;index < constantPoolCount;index++){
            tag = u1(input);
            System.out.println("tag value is " + tag + ",type is ");
            short classIndex;
            short nameAndTypeIndex;
            short string_index;
            int bytes;
            switch (tag) {
            case CONSTANT_CLASS:
                short nameIndex = u2(input);
                System.out.println("nameIndex:"+nameIndex);
                break;
            case CONSTANT_FIELDREF: 
                classIndex = u2(input);
                nameAndTypeIndex= u2(input);
                System.out.println("class Index :"+ classIndex + ",nameAndTypeIndex:"+nameAndTypeIndex);
                break;
            case CONSTANT_METHODREF:
                classIndex = u2(input);
                nameAndTypeIndex = u2(input);
                System.out.println("class Index :"+ classIndex + ",nameAndTypeIndex:"+nameAndTypeIndex);
                break;
            case CONSTANT_INTERFACE:
                classIndex = u2(input);
                nameAndTypeIndex = u2(input);
                System.out.println(" inteface Index :"+ classIndex + ",nameAndTypeIndex:"+nameAndTypeIndex);
                break;
            case CONSTANT_STRING:
                string_index = u2(input);
                System.out.println("string_index :"+string_index);;
                break;
            case CONSTANT_INTEGER:
                bytes = u4(input);
                System.out.println("integer value : " + bytes);
                break;
            case CONSTANR_FLOAT:
                bytes = u4(input);
                System.out.println("float value : " + bytes);
                break;
            case CONSTANT_LONG:
                
                break;
            case CONSTANT_DOUBLE:
                
                break;
            case CONSTANT_NAME_AND_TYPE:
                
                break;
            case CONSTANT_UTF_8:
                break;
            case CONSTANT_METHOD_HANDLE:
                
                break;
            case CONSTANT_METHOD_TYPE:
                
                break;
            case CONSTANT_INVOKE_DYNAMIC:
                break;
            default:
                throw new IllegalArgumentException("constant_pool_tag is error.tag value is " + tag);
            }
        }
        
        byte tag1 = u1(input);
        System.out.println("tag1=" + tag1);
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
