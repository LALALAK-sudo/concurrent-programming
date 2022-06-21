package cn.itcast.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int x = Integer.parseInt(input1[2]);
        int y = Integer.parseInt(input1[3]);
        int z = Integer.parseInt(input1[4]);
        Map<Character,Integer[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map.put(s.charAt(j),new Integer[]{i,j});
            }
        }
        String target = sc.nextLine();
        int R = 0,C=0;
        int res = 0;
        for (int i = 0; i < target.length(); i++) {
            Integer[] dp = map.get(target.charAt(i));
            int rR = Math.abs(R-dp[0]);
            int rC = Math.abs(C-dp[1]);
            res += ((rR+rC) * x); //
            res += z;
            if (rC != 0 && rR != 0) {
                res += y;
            }
            R = dp[0];
            C = dp[1];
        }
        System.out.println(res);
    }
}
