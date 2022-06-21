package cn.itcast.n6;


import sun.misc.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Testli {
    private static int res = 0;
    public static void main(String[] args) throws Exception  {
        Integer i1 = 59;
        int i2 =59;
        Integer i3 = Integer.valueOf(59);
        Integer i4 = new Integer(59);
        System.out.println(i3==i4);
//        Lock lock = new Lock();
//
//        lock.lock();
//        ReentrantLock reentrantLock = new ReentrantLock();
//        int[] a = new int[]{};
//        int[] b = new int[]{};
//        res = solution(a,b);
    }

    public static int solution(int[] a, int[] b) {
        int indexA = 0;
        int indexB = 0;
        int lenA = a.length;
        int lenB = b.length;
        res = 0;
        while (indexA < lenA && indexB < lenB) {
            if (a[indexA] == b[indexB]) {
                if (a[indexA + 1] == b[indexB+1]) {
                    indexA++;
                    indexB++;
                } else if (a[indexA + 1] < b[indexB+1]){
                    ++indexA;
                }else {
                    indexB++;
                }
            }else if (a[indexA] > b[indexB]) {
                res += Math.abs(a[indexA]-b[indexB]);
                indexB++;

            }else {
                indexB++;
            }
        }
        return 1;
    }
}
