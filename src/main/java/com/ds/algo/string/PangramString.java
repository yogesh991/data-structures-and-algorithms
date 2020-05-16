package com.ds.algo.string;
/*
@Author : Yogesh Deshmukh
*/

import java.util.HashSet;
import java.util.Set;

/*
* A pangram is a sentence containing every letter in the English Alphabet.
* Pangram: A pangram or holoalphabetic sentence is a sentence using every letter of a given alphabet at least once.
* The best-known English pangram is “The quick brown fox jumps over the lazy dog.”
* Lipogram: A lipogram is a kind of constrained writing or word game consisting of writing paragraphs
* or longer works in which a particular letter or group of letters is avoided—usually a common vowel, and frequently E, the most common letter in the English language.
*
* */

public class PangramString {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(checkPangramString(str));
        System.out.println(checkPangramWithoutSet(str));
        str = "The quick brown fox jumps over the dog";
        System.out.println(checkPangramString(str));
        System.out.println(checkPangramWithoutSet(str));
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



    public static boolean checkPangramWithoutSet(String input){

        boolean[] arr = new boolean[26];

        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);
            int index=0;
            if(temp >= 'A' && temp <='Z'){
                index = temp -'A';
            }

            if(temp >= 'a' && temp <= 'z'){
                index = temp - 'a';
            }

            arr[index] = true;

        }

        for(boolean val : arr)
            if(val == false)
                return false;

        return true;

    }
}
