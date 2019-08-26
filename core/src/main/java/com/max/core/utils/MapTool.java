package com.max.core.utils;

import org.springframework.util.ObjectUtils;

import java.util.*;

public class MapTool {

    /**
     * 通过value获取key  一对一
     *
     * @param map
     * @param value
     * @return
     */
    public static <T> T getKey(Map map, Object value) {
        List<Object> list = getKeys(map, value);
        if (ObjectUtils.isEmpty(list) || ObjectUtils.isEmpty(value)) {
            return null;
        }
        return (T) list.get(0);
    }

    /**
     * 通过value获取key  一对多
     *
     * @param map
     * @param value
     * @return
     */
    public static ArrayList<Object> getKeys(Map map, Object value) {
        Set set = map.entrySet(); // 通过entrySet()方法把map中的每个键值对变成对应成Set集合中的一个对象
        Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
        ArrayList<Object> arrayList = new ArrayList();
        while (iterator.hasNext()) {
            // Map.Entry是一种类型，指向map中的一个键值对组成的对象
            Map.Entry<Object, Object> entry = iterator.next();
            if (entry.getValue().equals(value)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }
}
