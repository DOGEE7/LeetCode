import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        // 找到比目标值小的那个值的索引，二分查找
        int n=nums.length;
        int low=0;
        int high=n-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<target)    low=mid+1;
            else if(nums[mid]>target)    high=mid-1;
            else    break;
        }
        int res=0;
        if(low<=high){
            while(mid>=0){
                if(nums[mid]==target)   mid--;
                else    break;
            }
            mid++;
            while(mid<n){
                if(nums[mid]==target){
                    mid++;
                    res++;
                }
                else    return res;
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();
        int[] nums={1};
        int res=sol.search(nums,1);
        System.out.println(res);

    }
}