package cn.itcast.proxy;

import java.util.*;

public class Test11 {
    public static void main(String[] args) {
        System.out.println(happyTriangle(new int[]{1,2,3,4,5,6}));
    }

    public static int happyTriangle (int[] length) {
        // write code here
        //recur(length,new int[length.length], new ArrayList<Integer>());
        Set<Set<Integer>> all = new HashSet<>();
        int res = 0;
        // int count = 0;
        for (int i = 0; i < length.length; i++) {
            for (int j = 1; j < length.length ; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 2; k < length.length; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    if (i < j && j < k) {
                        // count++;
                        Integer a = length[i] ;
                        Integer b = length[j];
                        Integer c = length[k];
                        if (a + b > c && b + c > a && a + c > b) {
                            if (a != b || b != c) {
                                if (a*a + b*b != c*c && a*a + c*c != b*b && b*b+c*c!= a*a) {
                                    System.out.print(a+" "+b+" "+c);
                                    System.out.println();
                                    res++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
