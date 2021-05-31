package cn.itcast.pattern;

public class Test {
    public static void main(String[] args) {
        int m = 11, n = 6, k = 1;
        int res = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                int temp = 0;
                int temp_i = i;
                while(temp_i%10 != 0) {
                    temp += temp_i%10;
                    temp_i /= 10;
                }
                int temp_j = j;
                while(temp_j%10 != 0) {
                    temp += temp_j%10;
                    temp_j /= 10;
                }
                if(temp<=k) res++;
            }
        }
        System.out.println(res);
    }
}
