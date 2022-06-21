package cn.itcast.n6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        m=2,n=2
        1,3
        2,4
        * */
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] split = strs.split(",");
        String[] split1 = split[0].split("=");
        int m = Integer.parseInt(split1[1]);
        String[] split2 = split[1].split("=");
        int n = Integer.parseInt(split2[1]);

        int[] a = new int[m];
        int[] b = new int[n];

        String aNums = sc.nextLine();
        String[] split3 = aNums.split(",");
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(split3[i]);
        }

        String bNums = sc.next();
        String[] split4 = bNums.split(",");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(split4[i]);
        }
        int[] result = new int[m+n];
        for (int i = 0; i < m; i++) {
            result[i] = a[i];
        }
        for (int i = m; i < m+n; i++) {
            result[i] = b[i-m];
        }
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }
}
