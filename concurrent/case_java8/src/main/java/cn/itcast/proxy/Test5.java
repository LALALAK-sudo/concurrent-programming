package cn.itcast.proxy;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        /*
    第一行四个整数 n, m, x, y，（0 < n, m <= 100，1 <= x, y <= 100000）
    后面 n 行，每行 m 个数，形成一个方阵，表示各个格子位置的阻力数值，如果为 -1，表示该位置无法通过。各个位置的数值范围为 [-1, 100000]。
    最后一行一个字符串，由 hjkl 四种字母组成，表示指令序列。
    h 表示向左移动一格，
    j 表示向下移动一格，
    k 表示向上移动一格，
    l 表示向右移动一格。
        2 2 2 2
        1 2
        -1 3
        kjljk
        * */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        String str = sc.next();

        char[] chars = str.toCharArray();
        if (n == m && n == 1) {
            int len = chars.length;
            int ans = 0;
            ans += y;
            for (int i = 1; i < len; i++) {
                if (chars[i-1] != chars[i]) {
                    ans += x;
                }
                ans += len * y;
            }

            System.out.println(ans);
        }
        char c0 = chars[0];
        int res = 0;
        int i = 0 ;
        int j = 0 ;
        if (c0 == 'h') {
            int t = nums[0][1];
            if (t == -1) {
                res += y;
            }else {
                res += Math.max(nums[0][0], nums[0][1]);
            }
            j++;
        }else if (c0 == 'j') {
            int t = nums[1][0];
            if (t == -1) {
                res += y;
            }else {
                res += Math.max(nums[0][0], nums[1][0]);
            }
            i++;
        }else if (c0 == 'k') {
            res += y;
        }else if (c0 == 'l') {
            res += y;
        }

        for (int l = 1; l < chars.length; l++) {
            char c = chars[l];
            /*
            h 表示向左移动一格，
            j 表示向下移动一格，
            k 表示向上移动一格，
            l 表示向右移动一格。
            * */

            if (c != chars[l-1]) {
                res += x;
            }
            if (c == 'h') {
                if (j-1 < 0) {
                    res += y;
                }else if (nums[i][j-1] == -1) {
                    res += y;
                }else {

                    res += Math.max(nums[i][j-1], nums[i][j]);
                    j--;
                }
            }else if (c == 'j') {
                if (i+1 >= n) {
                    res += y;
                }else if (nums[i+1][j] == -1) {
                    res += y;
                }else {

                    res += Math.max(nums[i+1][j], nums[i][j]);
                    i++;
                }
            }else if (c == 'k') {
                if (i-1 < 0) {
                    res += y;
                }else if (nums[i-1][j] == -1) {
                    res += y;
                }else {

                    res += Math.max(nums[i-1][j], nums[i][j]);
                    i--;
                }
            }else if (c == 'l') {
                if (j+1 >= m) {
                    res += y;
                }else if (nums[i][j+1] == -1) {
                    res += y;
                }else {

                    res += Math.max(nums[i][j+1], nums[i][j]);
                    j++;
                }
            }
        }
        System.out.println(res);
    }
}
