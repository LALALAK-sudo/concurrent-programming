package cn.itcast.n8;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            list.add(s);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        // 1 白 2 黑
        int black = 0;
        int white = 0;
        for (String str : list) {
            if (str.startsWith("1")) {
                // 白
                white++;
            }else if(str.startsWith("2")) {
                // 黑
                black++;
            }else {
                String[] s = str.split(" ");
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(Integer.parseInt(s[1]));
                integers.add(Integer.parseInt(s[2]));
                integers.add(Integer.parseInt(s[1])-Integer.parseInt(s[2]));
                map.put(index,integers);
                index++;
            }
        }
        int res = 0;
        while (white < n/2) {
            int min = Integer.MAX_VALUE;
            int t = 0;
            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                Integer num = map.get(integer).get(2);
                if (num < min) {
                    min = num;
                    t = integer;
                }else {
                    continue;
                }
            }
            res += map.get(t).get(0);
            map.remove(t);
            white++;
        }

        for (Integer integer : map.keySet()) {
            res += map.get(integer).get(1);
        }

        System.out.println(res);

//        while (white <= n/2) {
//            int min = Integer.MAX_VALUE;
//            int t = 0;
//            Set<Integer> integers = map.keySet();
//            for (Integer integer : integers) {
//                Integer num1 = map.get(integer).get(1);
//                if (min == num1) {
//                    min = num1;
//                    if (map.get(t).get(0) < map.get(integer).get(0)) {
//                        t = integer;
//                    }
//                }else if (min < num1){
//                    continue;
//                }else {
//                    min = num1;
//                    t = integer;
//                }
//        }
//
//        while (black!=white && (black+white == n)) {
//            if(black < white) {
//                int min = Integer.MAX_VALUE;
//                int t = 0;
//                Set<Integer> integers = map.keySet();
//                for (Integer integer : integers) {
//                    Integer num1 = map.get(integer).get(1);
//                    if (min == num1) {
//                        min = num1;
//                        if (map.get(t).get(0) < map.get(integer).get(0)) {
//                            t = integer;
//                        }
//                    }else if (min < num1){
//                        continue;
//                    }else {
//                        min = num1;
//                        t = integer;
//                    }
//                }
//            }
//        }
    }
}
