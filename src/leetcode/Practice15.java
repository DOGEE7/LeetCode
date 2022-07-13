package leetcode;

import java.util.*;

public class Practice15 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }

    //暴力破解，下场：超出时间限制（做人太难了T_T
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        Set<List<Integer>> reset = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int sum = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; ++k) {
                    List<Integer> list = new LinkedList<>();
                    if (sum + nums[k] == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        reset.add(list);
                        break;
                    }
                }
            }
        }
        for (List<Integer> list : reset) {
            resList.add(list);
        }
        return resList;
    }

    //使用i，L，R思路，先对nums进行排序（注意：去重）
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            int L = i + 1;
            int R = nums.length - 1;
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum > 0) R--;
                else if (sum < 0) L++;
                else if (sum == 0) {
//                    List<Integer>list=new LinkedList<>();
//                    list.add(nums[i]);
//                    list.add(nums[L]);
//                    list.add(nums[R]);
                    resList.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L + 1 < nums.length && nums[L] == nums[L + 1]) {L++;}
                    while (R - 1 >= 0 && nums[R] == nums[R - 1]) {R--;}
                    R--;
                    L++;
                }
            }
        }
        return resList;
    }
}
