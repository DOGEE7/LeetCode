package cn.edu.hqu.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Practice3 {
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        if (s.length()==0) {
//            return 0;
//        }
//        int max = 1;
//        int len = 0;
//        for (int i = 0; i < s.length(); ++i) {
//            char ch = s.charAt(i);
//            if (map.containsKey(ch)) {
//                if (max < len)
//                    max = len;
//                i=map.get(ch)+1;
//                map.remove(ch);
//                len = 1;
//            } else {
//                map.put(ch, i);
//                len++;
//            }
//        }
//        if (max < len)
//            max = len;
//        return max;
//    }

    public static void main(String[] args) {
        Practice3 prac = new Practice3();
        System.out.println(prac.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int sLength=s.length();
        if (sLength==0)
            return 0;
        int maxLenSubStr=0;
        Map<Character,Integer> map=new HashMap<>();
        int start,end;
        for (start=0,end=0;end<sLength;end++){
            char  c=s.charAt(end);
            if (map.containsKey(c)){
                if (map.get(c)>=start)
                    start=map.get(c)+1;
        }
            maxLenSubStr=Math.max(maxLenSubStr,(end-start+1));
            map.put(c,end);
        }
        return maxLenSubStr;
    }




}
