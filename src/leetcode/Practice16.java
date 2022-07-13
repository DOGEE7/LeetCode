package leetcode;

import java.util.Arrays;

public class Practice16 {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }

    //参考Practice15的解题思路，时间复杂度O(n^2)
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 3) return 0;
        int minDist = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int resSum = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        int sum;
        int dist;
        for (int i = 0; i < len - 1; ++i) {
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                sum = nums[i] + nums[L] + nums[R];
                dist = Math.abs(sum - target);
                if (sum == target) return sum;
                else if (sum > target) R--;
                else if (sum < target) L++;
                if (dist < minDist) {
                    minDist = dist;
                    resSum = sum;
                }
            }
        }
        return resSum;
    }
}
