package cn.itcast.n6;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        /*
        第一行五个整数a, b, c, d, e分别表示分数系数(1≤a,b,c,d,e≤10)。
        第二行一个整数n表示参加活动的人数(1≤n≤1e5)。
        接下来n行，每行五个整数x分别表示对五个boss造成的伤害(0≤x≤1e5)。
        * */
        Scanner sc = new Scanner(System.in);
        String scores = sc.nextLine();
        String[] score = scores.split(" ");
        int n = sc.nextInt();
        int[][] sh = new int[n][score.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < score.length; j++) {
                sh[i][j] = sc.nextInt();
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < score.length; j++) {
                sum += sh[i][j] * Integer.parseInt(score[j]);
            }
            map.put(i,sum);
        }

        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,map.get(i));
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i) == max) {
                res.add(i);
            }
        }
        System.out.println(max);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i)+1);
        }

    }
}
