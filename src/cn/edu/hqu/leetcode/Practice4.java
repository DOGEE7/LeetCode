package cn.edu.hqu.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
* 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Practice4 {
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        List<Integer> list = new LinkedList<>();
//        if (len1 % 2 == 0 && len1 != 0) {
//            list.add(nums1[len1 / 2 - 1]);
//            list.add(nums1[len1 / 2]);
//        } else if (len1 % 2 == 1 && len1 != 0) {
//            list.add(nums1[len1 / 2]);
//        }
//        if (len2 % 2 == 0 && len2 != 0) {
//            list.add(nums2[len2 / 2 - 1]);
//            list.add(nums2[len2 / 2]);
//        } else if (len2 % 2 == 1 && len2 != 0) {
//            list.add(nums2[len2 / 2]);
//        }
//        //求中位数
//        if (list.size() == 1 || list.size() == 0) {
//            return ((LinkedList<Integer>) list).getFirst();
//        } else if (list.size() == 3) {
//            int max = ((LinkedList<Integer>) list).getFirst();
//            int index = 0;
//            for (int i = 1; i < list.size(); ++i) {
//                if (max < list.get(i)) {
//                    max = list.get(i);
//                    index = i;
//                }
//            }
//            list.remove(index);
//            return ((LinkedList<Integer>) list).getFirst() > ((LinkedList<Integer>) list).getLast() ? ((LinkedList<Integer>) list).getFirst() : ((LinkedList<Integer>) list).getLast();
//        } else if (list.size() == 2) {
//            return (double) (((LinkedList<Integer>) list).getFirst() + ((LinkedList<Integer>) list).getLast()) / 2;
//        } else if (list.size() == 4) {
//            for (int i = 0; i < list.size(); ++i) {
//                for (int j = i + 1; j < list.size(); ++j) {
//                    if (list.get(i) > list.get(j)) {
//                        int tmp = list.get(i);
//                        list.set(i, list.get(j));
//                        list.set(j, tmp);
//                    }
//                }
//            }
//            return (double) (list.get(1) + list.get(2)) / 2;
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /*为nums1和nums2新建一个存储空间，存储数据按照从小到达顺序*/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i1=0, i2=0, i=0;
        while (i1 < nums1.length && i2 < nums2.length){
            if (nums1[i1] <= nums2[i2]) {
                nums[i] = nums1[i1];
                i1++;
            } else {
                nums[i] = nums2[i2];
                i2++;
            }
            ++i;
        }

        if (i1< nums1.length){
            while (i1< nums1.length){
                nums[i]=nums1[i1];
                ++i;
                ++i1;
            }
        }
        if (i2<nums2.length){
            while (i2<nums2.length){
                nums[i]=nums2[i2];
                i2++;
                i++;
            }
        }
        if (nums.length % 2 == 0) {
            return (double) (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        } else {
            return (double) (nums[nums.length / 2]);
        }
    }
}