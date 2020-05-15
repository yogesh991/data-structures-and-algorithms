package com.ds.algo.recursion;/* 
@Author : Yogesh Deshmukh
*/

import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial_8(5));
        System.out.println(factorial_recursion(5));
        System.out.println(factorial_loop(5));
    }

    //using Java 8..
public static long factorial_8(int num){
        return IntStream.iterate(1,x->x+1)
                .limit(num)
                .reduce((x,y)->x*y).getAsInt();
}

public static long factorial_recursion(int num){
        if(num==1 || num ==0)
            return 1;
        return num * factorial_recursion(num-1);
}

public static long factorial_loop(int num){
    long result =1;
    if(num ==0 || num ==1) return result;

    for(int i=num;i>0;i--){
        result=result*i;
    }
    return result;
}


}
