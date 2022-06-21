package cn.itcast.n8;

import java.util.*;

public class testBian {
    public static void main(String[] args) {
        /*
        第一行三个以空格隔开的正整数n、m和q，代表图的节点数，边数，以及询问次数。
        接下来m行，每行三个以空格隔开的整数ui, vi , ai，分别代表该边相连的两个节点，这条边的不舒适度。保证没有重边和自环。
        接下来q行，每行两个以空格隔开的整数xi , yi ，分别表示起点和终点。
        * */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] numsM = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                numsM[i][j] = sc.nextInt();
            }
        }
        int[][] startAndEnd = new int[q][2];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 2; j++) {
                startAndEnd[i][j] = sc.nextInt();
            }
        }

        for (int[] startEnd : startAndEnd) {
            int start = startEnd[0];
            int end = startEnd[1];
            List<Integer> temp = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            if (start == end) {
                System.out.println(0);
                continue;
            }
            list = new ArrayList<>();
            dfs(numsM,start,end,new HashMap<>(),new int[numsM.length],n, 0);
            if (list.size() == 0) {
                System.out.println(0);
            }
            for (Map<Integer, Integer> integerIntegerMap : list) {
                Set<Integer> integers = integerIntegerMap.keySet();
                for (Integer integer : integers) {
                    max = Math.max(integerIntegerMap.get(integer),max);
                }
            }
            System.out.println(max);
        }

    }
    private static List<Map<Integer,Integer>> list = new ArrayList<>();
    public static void dfs(int[][] numsM, int start, int end, Map<Integer,Integer> path, int[] used, int node, int t) {
        t = start;
        if (start == end) {
            list.add(new HashMap<>(path));
            return;
        }
        if (start > node) {
            return;
        }
        int n = numsM.length;
        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                if(start == numsM[i][1] || start == numsM[i][0]) {
                    used[i] = 1;
                    if (start == numsM[i][0]) {
                        start = numsM[i][1];
                    }else {
                        start = numsM[i][0];
                    }

                    path.put(start,numsM[i][2]);
                    dfs(numsM,start,end,path,used,node,t);
                    path.remove(start);
                    start = t;
                    used[i] = 0;
                }
            }
        }
    }
}
