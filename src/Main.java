import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
            else break;
        }
        int res = 0;
        if (low <= high) {
            while (mid >= 0) {
                if (nums[mid] == target) mid--;
                else break;
            }
            mid++;
            while (mid < n) {
                if (nums[mid] == target) {
                    mid++;
                    res++;
                } else return res;
            }
        }
        return res;
    }

    public int longestPalindrome(String s) {
        // HashMap:找所有的偶个数+最大的奇个数
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        int res = 0;
        Set<Character> keys = map.keySet();
        int maxOdd = 0;
        for (char k : keys) {
            if (map.get(k) % 2 == 0) res += map.get(k);
            else maxOdd = (map.get(k) > maxOdd) ? map.get(k) : maxOdd;
        }
        return res + maxOdd;
    }
}

public class Main {
    public static void main(String[] args) {
//        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        Solution sol = new Solution();
//        System.out.println(sol.longestPalindrome(s));
        int[] count=new int[128];
        char ch='a';
        count[ch]++;
        System.out.println(count[ch]);

    }
}