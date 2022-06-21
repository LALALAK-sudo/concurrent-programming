package cn.itcast.proxy;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        /*
        第一行一个正整数T，表示数据组数；
        对于每一组数据，每行输入一个正整数k。
        1≤T≤200,1≤k≤1012*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextLong();
        }

        //  求方程x3+y4+z5=k的一组正整数解(x,y,z)。
        for (int i = 0; i < n; i++) {
            long k = nums[i];
            if (k < 3) {
                System.out.println("NO");
                break;
            }

            long x = 1, y = 1, z = 1;
            boolean flag = false;
            long sum = x + y + z;
            if (sum == k) {
                System.out.println("YES");
                continue;
            }
            while (sum < k) {
                long t0 = z*z*z*z*z + y*y*y*y + x*x*x;
                long t1 = z*z*z*z*z + y*y*y*y + (x+1)*(x+1)*(x+1);
                long t2 = z*z*z*z*z + (y+1)*(y+1)*(y+1)*(y+1) + x*x*x;
                long t3 = z*z*z*z*z + (y+1)*(y+1)*(y+1)*(y+1) + (x+1)*(x+1)*(x+1);
                long t4 = (z+1)*(z+1)*(z+1)*(z+1)*(z+1) + y*y*y*y + x*x*x;
                long t5 = (z+1)*(z+1)*(z+1)*(z+1)*(z+1) + y*y*y*y + (x+1)*(x+1)*(x+1);
                long t6 = (z+1)*(z+1)*(z+1)*(z+1)*(z+1) + (y+1)*(y+1)*(y+1)*(y+1) + x*x*x;
                long t7 = (z+1)*(z+1)*(z+1)*(z+1)*(z+1) + (y+1)*(y+1)*(y+1)*(y+1) + (x+1)*(x+1)*(x+1);
                if (t0== k || t1 == k || t2 == k ||t3 == k ||t4 == k ||t5 == k ||t6 == k||t7 == k) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
                x++;
                y++;
                z++;
                sum = t7;
            }
            if (!flag) {
                System.out.println("NO");
            }

        }


    }
}
