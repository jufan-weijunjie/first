package com.wei.first;

import java.util.Arrays;

/**
 * FileName：javaTest
 *
 * @author 魏俊杰
 * @date 14:38 2019/4/25
 */
public class JavaTest {

    public static void main(String[] args){
        int number[] = new int[]{25,10,4,7};
        Arrays.sort(number);
        Arrays.stream(number).forEach(i -> System.out.println(i));
        int i = Arrays.binarySearch(number, 0, 4, 11);
        System.out.println(i);
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



}
