package com.wei.first;

/**
 * FileName：javaTest
 *
 * @author 魏俊杰
 * @date 14:38 2019/4/25
 */
public class JavaTest {

    public static void main(String[] args){
        JavaTest javaTest = new JavaTest();
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println(javaTest.operate(1,2,addition));
    }
    interface MathOperation {
        int operation(int a, int b);
    }
    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }



}
