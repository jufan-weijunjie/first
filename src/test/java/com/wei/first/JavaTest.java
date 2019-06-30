package com.wei.first;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * FileName：javaTest
 *
 * @author 魏俊杰
 * @date 14:38 2019/4/25
 */
public class JavaTest {

    public static void main(String[] args){
        /*int number[] = new int[]{25,10,4,7};
        Arrays.sort(number);
        Arrays.stream(number).forEach(i -> System.out.println(i));
        int i = Arrays.binarySearch(number, 0, 4, 11);
        System.out.println(i);*/
        sortInt();
//        JavaTest javaTest = new JavaTest();
//        MathOperation addition = (int a, int b) -> a + b;
//        System.out.println(javaTest.operate(1,2,addition));
    }
    interface MathOperation {
        int operation(int a, int b);
    }
    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }

    public static void sortInt(){
        int[] ints = {4, 5, 7, 2, 1, 6, 3};
        for(int i = 0;i<ints.length-1;i++){
            for(int j = 0;j<ints.length-i-1;j++){
                if(ints[j]>ints[j+1]){
                    int t;
                    t = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = t;
                }
            }
        }
        System.out.println(JSONObject.toJSONString(ints));
    }



}
