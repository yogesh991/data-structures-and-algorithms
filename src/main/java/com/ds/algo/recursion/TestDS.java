package com.ds.algo.recursion;/*
@Author : Yogesh Deshmukh
*/

import java.util.*;
import java.util.stream.Collectors;

public class TestDS {
    public static void main(String[] args) {

    }
}


class TestClass {
    //    public static void main(String args[] ) throws Exception {
//        Scanner s = new Scanner(System.in);
//        String input = s.nextLine();
//        int len = Integer.parseInt(input);
//
//        List<String> temp = Arrays.asList(s.nextLine().split(" "));
//        List<Integer> arr = temp.stream().map(x->Integer.parseInt(x)).collect(Collectors.toList());
//        System.out.println(findLength(arr));
//
//
//    }
//
//    static int findLength(List<Integer> list)  {
//        int maxLen = 1,n = list.size();
//        for (int i = 0; i < n - 1; i++) {
//            int min = list.get(i), max = list.get(i);
//            for (int j = i + 1; j < n; j++) {
//
//                min = min<list.get(j) ? min:list.get(j);
//                max = max>list.get(j) ? max: list.get(j);
//
//                if ((max - min) == j - i)
//                    maxLen = maxLen> (max - min + 1)?maxLen : (max - min + 1);
//            }
//        }
//        return maxLen;
//    }
    private static Set<String> set = new HashSet<String>();

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int len = Integer.parseInt(input);

        List<String> temp = Arrays.asList(s.nextLine().split(" "));
        List<Integer> arr = temp.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        int ones = arr.get(1);
        int zeroes = arr.get(0);

        if (zeroes > ones) System.out.println("0");

        getStrings("", ones, zeroes);
        System.out.println(set.size());


    }

    static void getStrings(String s, int ones, int zeroes) {
        if (ones == 0 && zeroes == 0)
            set.add(s);
        else {
            if (zeroes > 0)
                getStrings(s + "0", ones, zeroes - 1);
            if (ones > 0)
                getStrings(s + "1", ones - 1, zeroes);
        }
    }
}