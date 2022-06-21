package cn.itcast.n8;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        String s = sc.nextLine();
        int n = Integer.parseInt(s);
        int index = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            String str = sc.nextLine();
            String[] split = str.split("-");
            int time1 = transfor(split[0]);
            int time2 = transfor(split[1]);
            list.add(time1);
            list.add(time2);
            list.add(time2-time1);
            map.put(index,list);
            index++;
        }

        Map<Integer, List<Integer>> sortedMap = new HashMap<>();
        int i = 0;

        while (!map.isEmpty()) {
            int t = 0;
            int min = Integer.MAX_VALUE;
            List<Integer> temp = null;
            for (Integer integer : map.keySet()) {
                List<Integer> list = map.get(integer);
                if (list.get(0) < min) {
                    min = list.get(0);
                    t = integer;
                    temp = map.get(t);
                }

            }
           sortedMap.put(i,temp);
            i++;
            map.remove(t);
        }
        int sum = 0;
        int[] dp = new int[n];
        List<Integer> list = sortedMap.get(0);
        for (int j = 1; j < n; j++) {
            Integer lastEnd = list.get(1);
            Integer lasting = list.get(2);
            ArrayList<Integer> lastList = new ArrayList<>(list);
            list = sortedMap.get(j);
            Integer nextStart = list.get(0);
            Integer nexting = list.get(2);
            if (nextStart >= lastEnd) {
                sum += lasting;
            }else {
                sum += Math.max(lasting,nexting);
                list = lastList;
                j++;
            }
        }
        sum += list.get(2);
        System.out.println(sum);
    }

    public static int transfor(String str) {
        String[] split = str.split(":");
        int res = 0;
        res += Integer.parseInt(split[1]);
        res += Integer.parseInt(split[0])*60;
        return res;
    }
}
