package com.ds.algo.recursion;/* 
@Author : Yogesh Deshmukh
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'findSimilar' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static Set<String> set = new HashSet<String>();
    public static long findSimilar(String a, String b) {
        if(a.charAt(0) == '0' && b.charAt(0)!='0'){
            allPossibleStrings(b, 0, b.length());
            return set.size();
        }else if(a.charAt(0) != '0' && b.charAt(0)=='0'){
            allPossibleStrings(b, 0, b.length());
            return set.size();
        }
        Map<String,Integer> a1 = countChars(a);
        Map<String,Integer> b1 = countChars(b);

        if(a1.keySet().size() !=b1.keySet().size()){
            allPossibleStrings(b, 0, b.length());
            return set.size();
        }else{
            boolean flag=true;
            for(String temp : a1.keySet()){
                if(a1.get(temp) != b1.get(temp))
                    flag=false;
            }
            if(flag){
                allPossibleStrings(a, 0, a.length());
                return set.size();
            }else{
                allPossibleStrings(b, 0, b.length());
                return set.size();
            }

        }


    }

    public static Map<String, Integer> countChars(String input){
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<input.length();i++){
            String charTemp = input.charAt(i)+"";
            if(map.containsKey(charTemp)){
                int val = map.get(charTemp);
                map.put(charTemp,++val);
            }else{
                map.put(charTemp,1);
            }
        }
        return map;
    }

    private static void allPossibleStrings(String input, int left, int right){
        if (left == right){
            if(input.charAt(0) != '0')
                set.add(input);
        }else{
            for (int i = left; i < right; i++) {
                input = swap(input,left,i);
                allPossibleStrings(input, left+1, right);
                input = swap(input,left,i);
            }
        }
    }

    public static String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        long result = Result.findSimilar(a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



