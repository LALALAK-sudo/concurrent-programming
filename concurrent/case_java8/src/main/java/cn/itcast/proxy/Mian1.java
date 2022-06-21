package cn.itcast.proxy;

import java.util.HashSet;
import java.util.Scanner;

public class Mian1 {

    private static HashSet<Integer> set = new HashSet<>(); // 存放当前启动的序号（编号+1）

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        boolean[][] req = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int serNum = sc.nextInt();
            for (int j = 0; j < serNum; j++) {
                int serIdx = sc.nextInt() - 1;
                req[i][serIdx] = true; // 第i个服务依赖于第serIdx个服务
            }
        }

        for (int i = 0; i < q; i++) {
            int opt = sc.nextInt(), seq = sc.nextInt() - 1;
            if(opt == 1) {
                dfsStartProc(req, seq, n);
            } else {
                dfsStopProc(req, seq, n);
            }
            System.out.println(set.size());
        }
    }

    // 递归启动
    private static void dfsStartProc(boolean[][] req, int ps, int n) {
        if(set.contains(ps)) return;
        set.add(ps);
        for (int i = 0; i < n; i++) {
            if(req[ps][i]) {
                dfsStartProc(req, i, n);
                set.add(i);
            }
        }
    }

    // 递归停止
    private static void dfsStopProc(boolean[][] req, int ps, int n) {
        if(!set.contains(ps)) return;
        set.remove(ps);
        for (int i = 0; i < n; i++) {
            if(req[i][ps]) {
                dfsStopProc(req, i, n);
                set.remove(i);
            }
        }
    }
}
