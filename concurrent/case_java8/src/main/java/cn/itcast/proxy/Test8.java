package cn.itcast.proxy;

public class Test8 {
    public static void main(String[] args) {
        int[] ints = minimumNumber(new int[]{10,6,16,66,99,963});

        System.out.println(111);
    }

    public static int[] minimumNumber (int[] target) {
        // write code here
        int[] res = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            int t = target[i];
            if (t<10) {
                res[i] = -1;
                continue;
            }
            int ans = 4;
            if (t == 10) {
                res[i] = ans;
                continue;
            }
            t -= 10;
            if (t >= 4) {
                ans += t / 4;
                t %= 4;
            }
            if (t >= 3) {
                ans += t / 3;
                t %= 3;
            }
            if (t >= 2) {
                ans += t / 2;
                t %= 2;
            }
            if (t >= 1) {
                ans += t / 1;
                t %= 1;
            }
            res[i] = ans;

//            while (t - 10 > 0) {
//                int temp = t - 10;
//                ans += temp / 4;
//            }
        }

        return res;
    }
}
