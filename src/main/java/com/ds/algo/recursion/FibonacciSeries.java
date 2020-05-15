package com.ds.algo.recursion;/* 
@Author : Yogesh Deshmukh
*/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(getFibonacciSeries(6));
/*
        System.out.println(getFibonacciSeries_8(6));*/

        System.out.println(getFibonacciSeries_loop(6));
    }

    public static int getFibonacciSeries(int num){
        if(num <=0) return -1;

        else if(num ==1 || num ==2)
            return num-1;
        else
            return getFibonacciSeries(num-1) + getFibonacciSeries(num-2);
    }

    public static void getFibonacciSeries_8(int num){
        if(num <=0)
            System.out.println("-1");
        if(num ==1 || num ==2) System.out.println(num-1+"");

        Function<Integer,Integer> fibonacci = (num1)->{
            /*int temp = num2;
            num2 = num1+num2;
            num1 = temp;*/
            System.out.println(num1+" : "+num1);
            return num1;
        };

        //Need 2 variables to perorm the task
         IntStream.iterate(2,x->x+1)
                .limit(num)
                .forEach(x->System.out.println(fibonacci.apply(x)));
    }

    public static int getFibonacciSeries_loop(int num){
        if(num <=0) return -1;
        if(num==1 || num ==2) return num-1;
        int num1=1, num2=1;
        for(int i=2;i<num;i++){
            int temp = num2;
            num2 = num1+num2;
            num1 = temp;
        }
        return num1;
    }
}
