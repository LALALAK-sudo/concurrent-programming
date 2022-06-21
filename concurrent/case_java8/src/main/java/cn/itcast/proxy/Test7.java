package cn.itcast.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        /*
    第一行两个空格隔开的整数 n, q，表示服务的数量和询问的数量，1 <= n, q <= 500。
    下面 n 行，其中的第 i 行第一个整数 c 表示第 i 个服务所依赖的服务数量，
后面 c 个整数表示它所依赖的各个服务，保证这 c 个整数在 1~n 范围内，互不相等且都不等于 i。
    下面 q 行，每行两个空格隔开的整数 x, y。x 为 1 或 0，1 表示启动服务，0 表示停止服务。
y 表示启动或停止的服务的序号。
            3 2
            1 2  //0 1
            1 3  //1 2
            0    //2 3
            1 1
            0 2
        * */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int[] nums = new int[c];
            for (int j = 0; j < c; j++) {
                nums[j] = sc.nextInt();
            }
            list.add(nums);
        }

        int[] nums = new int[n]; // 表示n个机器，默认位0，均没有启动
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(); // x 为 1 或 0，1 表示启动服务，0 表示停止服务
            int y = sc.nextInt(); // y 表示启动或停止的服务的序号
            int[] used = new int[n];
            recur(nums,x,y,list,used);
            int count = 0 ;
            for (int num : nums) {
                if (num==1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void recur(int[] nums, int x, int y, List<int[]> list,int[] used) {
        int[] ints = list.get(y-1);
        if (used[y-1] == 1) {
            return;
        }
        nums[y-1] = x;
        used[y-1] = 1;
        for (int i = 0; i < ints.length; i++) {
            int num = ints[i]; // 该y机器依赖的第i个机器
            nums[num-1] = x;
            for (int j = 0; j < list.get(num-1).length; j++) {
                recur(nums,x,list.get(num-1)[j],list,used);
            }
        }
    }
}
