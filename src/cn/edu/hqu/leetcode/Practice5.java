package cn.edu.hqu.leetcode;

/*
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Practice5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        String pls = "";
        int size = 0;
        for (int i = 0; i < s.length(); ++i) {
            //奇数回文
            if ((i - 1) >= 0 && (i + 1) < s.length() && s.charAt(i - 1) == s.charAt(i + 1)) {
                start = i - 1;
                end = i + 1;
                while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    --start;
                    ++end;
                }
                ++start;
                --end;
            }
            if (size < (end - start + 1)) {
                size = end - start + 1;
                pls = s.substring(start, end + 1);
            }
            //偶数回文
            if ((i + 1) < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                end = i + 1;
                while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    --start;
                    ++end;
                }
                ++start;
                --end;
            }
            if (size < (end - start + 1)) {
                size = end - start + 1;
                pls = s.substring(start, end + 1);
            }
        }
        return pls;
    }

}
