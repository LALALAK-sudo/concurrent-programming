package cn.itcast.n8.concurrentqueue;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int index = a;
        int b = sc.nextInt();
        int res = 0;
        while (index <= b) {
            Calendar cal = Calendar.getInstance();
            for (int i = 0; i < 12; i++) {
                cal.set(index,i,1);
                int t = cal.get(Calendar.DAY_OF_WEEK);
                if (t == 2) {
                    res++;
                }
            }
            index++;
        }
        System.out.println(res);
    }
}
