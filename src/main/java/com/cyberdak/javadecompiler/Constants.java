package com.cyberdak.javadecompiler;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 58 on 2016/12/27.
 */
public class Constants {

    public static final String CODE = "Code";
    public static final String CONSTANT_VALUE = "ConstantValue";
    public static final String STACK_MAP_TABLE = "StackMapTable";
    public static final String EXCEPTIONS = "Exceptions";
    public static final String INNER_CLASSES = "InnerClasses";
    public static final String ENCLOSING_METHOD = "EnclosingMethod";
    public static final String SYNTHETIC = "Synthetic";
    public static final String SIGNATURE = "Signature";
    public static final String SOURCE_FILE = "SourceFile";
    public static final String SOURCE_DEBUG_EXTENSION = "SourceDebugExtension";
    public static final String LINE_NUMBER_TABLE = "LineNumberTable";
    public static final String LOCAL_VARIABLE_TABLE = "LocalVariableTable";
    public static final String LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";
    public static final String DEPRECATED = "Deprecated";
    public static final String RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";
    public static final String RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
    public static final String RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    public static final String RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    public static final String ANNOTATION_DEFAULT = "AnnotationDefault";
    public static final String BOOTSTRAP_METHODS = "BootstrapMethods";

    public static final Map<String,String> typeMaaping = Maps.newHashMap();

    static{
        typeMaaping.put("J","long");
        typeMaaping.put("B","byte");
        typeMaaping.put("C","char");
        typeMaaping.put("I","int");
        typeMaaping.put("D","double");
        typeMaaping.put("[","array");
    }
}
