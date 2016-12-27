package com.cyberdak.javadecompiler;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

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


    private static final Map<Integer, String> accessFlagMap = Maps.newHashMap();

    static {
        accessFlagMap.put(0x0001, "ACC_PUBLIC");
        accessFlagMap.put(0x0010, "ACC_FINAL");
        accessFlagMap.put(0x0020, "ACC_SUPER");
        accessFlagMap.put(0x0200, "ACC_INTERFACE");
        accessFlagMap.put(0x0400, "ACC_ABSTRACT");
        accessFlagMap.put(0x1000, "ACC_SYNTHETIC");
        accessFlagMap.put(0x2000, "ACC_ANNOTATION");
        accessFlagMap.put(0x4000, "ACC_ENUM");
    }

    public static void main(String[] args) throws Exception {
        String path = Thread.currentThread().getContextClassLoader().getResource("com/cyberdak/javadecompiler/App.class").getPath().toString();
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        DataInputStream input = new DataInputStream(fis);
        int magic = u4(input);
        if (magic == 0xcafebabe) {
            System.out.println("valid class file.");
        } else {
            System.out.println("invalid class file.");
            return;
        }

        int minorVersion = u2(input);
        System.out.println("minorVersion:" + minorVersion);
        int majorVersion = u2(input);
        System.out.println("majorVersion：" + majorVersion);
        int constantPoolCount = u2(input);
        String[] constantPool = new String[constantPoolCount+1];
        Map<Integer,String> UTF8Map = Maps.newHashMap();
        ArrayListMultimap<Integer,Integer> map = ArrayListMultimap.create();
        System.out.println("constantPoolCount:" + constantPoolCount);
        // 常量池处理
        byte tag;
        for (int index = 1; index < constantPoolCount; index++) {
            tag = u1(input);
            short classIndex;
            short nameAndTypeIndex;
            short string_index;
            int bytes;
            switch (tag) {
                case CONSTANT_CLASS:
                    short nameIndex = u2(input);
                    System.out.println("nameIndex:" + nameIndex);
                    map.put(index,(int)nameIndex);
                    break;
                case CONSTANT_FIELDREF:
                    classIndex = u2(input);
                    nameAndTypeIndex = u2(input);
                    map.put(index,(int)classIndex);
                    map.put(index,(int)nameAndTypeIndex);
                    break;
                case CONSTANT_METHODREF:
                    classIndex = u2(input);
                    nameAndTypeIndex = u2(input);
                    map.put(index,(int)classIndex);
                    map.put(index,(int)nameAndTypeIndex);
                    System.out.println("class Index :" + classIndex + ",nameAndTypeIndex:" + nameAndTypeIndex);
                    break;
                case CONSTANT_INTERFACE:
                    classIndex = u2(input);
                    nameAndTypeIndex = u2(input);
                    map.put(index,(int)classIndex);
                    map.put(index,(int)nameAndTypeIndex);
                    System.out.println(" inteface Index :" + classIndex + ",nameAndTypeIndex:" + nameAndTypeIndex);
                    break;
                case CONSTANT_STRING:
                    string_index = u2(input);
                    map.put(index,(int)string_index);
                    System.out.println("string_index :" + string_index);
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
                    byte[] longBytes = new byte[8];
                    byte[] lowLongBytes = Ints.toByteArray(u4(input));
                    byte[] highLongBytes =  Ints.toByteArray(u4(input));
                    System.arraycopy(lowLongBytes,0,longBytes,0,4);
                    System.arraycopy(highLongBytes,0,longBytes,4,4);
                    Long l = byteArrayToLong(longBytes);
                    System.err.println(l);
                    break;
                case CONSTANT_DOUBLE:
                    byte[] doubleBytes = new byte[8];
                    byte[] lowBytes = Ints.toByteArray(u4(input));
                    byte[] highBytes =  Ints.toByteArray(u4(input));
                    System.arraycopy(lowBytes,0,doubleBytes,0,4);
                    System.arraycopy(highBytes,0,doubleBytes,4,4);
                    Double d = byteArrayToDouble(doubleBytes);
                    System.err.println(d);
                    break;
                case CONSTANT_NAME_AND_TYPE:
                    int constantNameIndex = u2(input);
                    int descriptorIndex = u2(input);
                    map.put(index,(int)constantNameIndex);
                    map.put(index,(int)descriptorIndex);
                    break;
                case CONSTANT_UTF_8:
                    int length = u2(input);
                    byte[] datas = new byte[length];
                    for (int i = 0; i < length; i++) {
                        datas[i] = u1(input);
                    }
                    System.out.println(new String(datas));
                    UTF8Map.put(index,new String(datas));
                    break;
                case CONSTANT_METHOD_HANDLE:
                    int kind = u1(input);
                    int referenceIndex = u2(input);
                    map.put(index,referenceIndex);
                    break;
                case CONSTANT_METHOD_TYPE:
                    descriptorIndex = u2(input);
                    map.put(index,descriptorIndex);
                    break;
                case CONSTANT_INVOKE_DYNAMIC:
                    u2(input);
                    u2(input);
                    break;
                default:
                    throw new IllegalArgumentException("constant_pool_tag is error.tag value is " + tag);
            }
        }

        while(!map.isEmpty()){
            for(Integer index:  map.keySet()){
                List<Integer> list = map.get(index);
                List<String> resultList = Lists.newArrayList();
                boolean flag = true;
                for(Integer indexIndex : list){
                    String value = UTF8Map.get(indexIndex);
                    if(value != null){
                        resultList.add(value);
                    }else{
                        flag = false;
                    }
            }
            if(flag){
                UTF8Map.put(index, Joiner.on(":").join(resultList));
//                    System.out.println(index +":"+ Joiner.on(":").join(resultList));
            }
        }
            System.out.println(map.size());
            for(Integer i : UTF8Map.keySet()){
                map.asMap().remove(i);
            }

            System.out.println(map.size());
        }

        for(Integer key : UTF8Map.keySet()){
            System.out.println(key + ":" + UTF8Map.get(key));
        }

        // 字段 field
        int accessFlag = u2(input);
        System.out.println("accessFlag:" + accessFlag);
        int thisClassIndex = u2(input);
        int superClassIndex = u2(input);
        int interfaceCount = u2(input);
        // interface
        for (int i = 1; i <= interfaceCount; i++) {
            int interfaceIndex = u2(input);
        }
        int fieldCount = u2(input);
        for (int i = 1; i <= fieldCount; i++) {
            int fieldAccessFlags = u2(input);
            int nameIndex = u2(input);
            int descriptorIndex = u2(input);
            int attributesCount = u2(input);
            for (int j = 1 ; j <= attributesCount;j++) {
                int attributeNameIndex = u2(input);
                int attributeLength = u4(input);
                for(int k = 1 ; k <= attributeLength; k ++){
                    u1(input);
                }
            }
        }
        // parse method info
        int methodCount =u2(input);
        for(int i = 1; i <= methodCount;i++){
            int methodAccessFlags = u2(input);
            int methodNameIndex = u2(input);
            int descriptorIndex = u2(input);
            int attributesCount = u2(input);

            for (int j = 1 ; j <= attributesCount;j++) {
                int attributeNameIndex = u2(input);
                int attributeLength = u4(input);
                for(int k = 1 ; k <= attributeLength; k ++){
                    u1(input);
                }
            }
        }
    }

    private static final void parseField(DataInputStream input) throws Exception {
        int accessFlag = u2(input);
        int nameIndex = u2(input);

    }

    public static byte u1(DataInputStream input) throws Exception {
        return input.readByte();
    }

    public static short u2(DataInputStream input) throws Exception {
        return input.readShort();
    }

    private static int u4(DataInputStream input) throws IOException {
        return input.readInt();
    }

    public static long u8(DataInputStream input) throws Exception {
        return input.readLong();
    }

    public static final short byteArrayToShort(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getShort();
    }

    public static final int byteArrayToInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    public static final float byteArrayToFloat(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getFloat();
    }

    public static double byteArrayToDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }

    public static final long byteArrayToLong(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getLong();
    }

}
