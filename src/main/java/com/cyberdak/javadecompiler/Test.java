package com.cyberdak.javadecompiler;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 58 on 2016/12/27.
 */
public class Test {
    public static void main(String[] args) {
        ArrayListMultimap<String,Integer> map = ArrayListMultimap.create();
        Map<String,Integer> map1 = Maps.newHashMap();
        map1.put("abc",1);

        map.put("abc",1);
        map.put("abc1",2);

        map.removeAll(map1.keySet());


        System.out.println(map.size());
    }
}
