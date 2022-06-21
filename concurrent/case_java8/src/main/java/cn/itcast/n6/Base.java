package cn.itcast.n6;

public class Base {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int n = removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int num = 1;
        int temp = nums[0];
        int res = 0;
        for(int i = 1 ; i < len ; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                break;
            }
            if(num > 2) {
                i--;
                res--;
                swapAll(nums, i);
                num = 2;
                i--;
                continue;
            }

            if (temp == nums[i]) {
                num++;
                res++;
            }else {
                temp = nums[i];
                num = 1;
                res++;
            }
        }
        if(num > 2) {
            swapAll(nums, res-1);
            res--;
        }
        return res;
    }

    public static void swapAll(int[] nums, int index) {
        for(int i = index ; i < nums.length-1 ; i++) {
            if (i == nums.length - 1) {
                nums[i] = Integer.MIN_VALUE;
            }else {
                nums[i] = nums[i+1];
            }
        }
    }
}
