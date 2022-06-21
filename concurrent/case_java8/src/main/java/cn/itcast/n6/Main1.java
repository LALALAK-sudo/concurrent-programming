package cn.itcast.n6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        /*
        输入:n = 5
        过程：第一步： 1, 2, (3), 4, 5
        第二步： (1), 2, 4, (5)
        第三步：(2), 4
        * */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;

        while (list.size() != 1) {
//            System.out.println("    ");
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                index++;
                if (index % 3 == 0) {
                    temp.add(i);
                }
            }
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (!temp.contains(i)) {
                    list2.add(list.get(i));
                }
            }
            list = list2;
//            System.out.println(list.toString());
        }
        System.out.println(list.get(0));
    }
}
