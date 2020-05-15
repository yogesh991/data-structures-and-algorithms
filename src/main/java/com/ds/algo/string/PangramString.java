package com.ds.algo.string;
/*
@Author : Yogesh Deshmukh
*/

import java.util.HashSet;
import java.util.Set;

/*A pangram is a sentence containing every letter in the English Alphabet.*/

public class PangramString {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(checkPangramString(str));
    }

    /*Using Hashing technique - used HashSet Time -> O(n) and Space -> O(1) bcoz always this will be 26 in size*/
    public static boolean checkPangramString(String input){
        input = input.toLowerCase();

        Set<String> check = new HashSet<String>();
        for(char temp : input.toCharArray()){
            if(temp <= 'z' && temp >= 'a'){
                check.add(temp+"");
            }
        }
        if(check.size() == 26)
            return true;
        else
            return false;
    }
}
