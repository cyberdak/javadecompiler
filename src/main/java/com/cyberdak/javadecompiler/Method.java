package com.cyberdak.javadecompiler;

import java.util.List;

/**
 * Created by 58 on 2017/1/4.
 */
public class Method {
    private String flag;
    private String name;
    private String returnParam;
    private List<String> enterParam;
    private String code;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnParam() {
        return returnParam;
    }

    public void setReturnParam(String returnParam) {
        this.returnParam = returnParam;
    }

    public List<String> getEnterParam() {
        return enterParam;
    }

    public void setEnterParam(List<String> enterParam) {
        this.enterParam = enterParam;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return flag  + " " + returnParam + " " + name + "(" + enterParam + "){\r\n"
                + code + "}";
    }

    public static String translateParam(String desc){
        String input =desc.substring(1,desc.indexOf(")") + 1);
        String returnP = desc.substring(desc.indexOf(")"),desc.indexOf(")") + 1 ) ;
        return input;
    }

}
