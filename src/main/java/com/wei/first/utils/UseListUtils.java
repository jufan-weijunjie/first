package com.wei.first.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName：UseListUtils
 *
 * @author 魏俊杰
 * @date 10:40 2019/4/25
 */
public class UseListUtils {

    public static <T> List<List<T>> divisionList(List<T> lists,int size){
        if(null == lists){
            System.out.println("当前要执行修改的数据条数为0");
            return null;
        }
        ArrayList<List<T>> arrayLists = new ArrayList<>();
        int a = lists.size()%size == 0?0:1;
        int count = (lists.size() - lists.size()%size)/size +a;
        int listLen = null == lists?0:lists.size();
        if(listLen<=size){
            arrayLists.add(lists);
            return arrayLists;
        }else{
            for(int i= 0;i<count;i++){
                List<T> strings1 = lists.subList(i * size, i * size + size >= lists.size()?lists.size():i * size + size);
                arrayLists.add(strings1);
            }
            return arrayLists;
        }
    }
}
