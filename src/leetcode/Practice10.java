package leetcode;
/**
 * 未解
 */

import java.nio.BufferOverflowException;

/*
* 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/regular-expression-matching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Practice10 {
    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty())return s.isEmpty();
        if (s.equals(p) )return true;
        int i, j;
        boolean flag=false;
//        if (s.length() > p.length()) return false;
        for (i = 0, j = 0; i < s.length() && j < p.length(); ) {
            if (p.charAt(j) == '.' && (j + 1 < p.length() && p.charAt(j + 1) != '*')) {
                ++i;
                flag=true;
            }
            else if (p.charAt(j) == '.' && (j + 1 < p.length() && p.charAt(j + 1) == '*')) {
//                flag=true;
//                do {
//                    ++i;
//                } while (i < s.length() && s.charAt(i) != s.charAt(i - 1));
                return true;
            } else if (p.charAt(j) != '.' && (j + 1 < p.length() && p.charAt(j + 1) != '*')) {
                if (p.charAt(j) != s.charAt(i)) return false;
                else {
                    ++i;
                    ++j;
                }
            } else if (p.charAt(j) != '.' && (j + 1 < p.length() && p.charAt(j + 1) == '*')) {
                flag=true;
                while ((i < s.length()) && p.charAt(j) == s.charAt(i)) {
                    ++i;
                }
                try {
                    if (p.charAt(j) != s.charAt(i)) ++j;
                }catch (StringIndexOutOfBoundsException e){
                    ++j;
                }
                ++j;
            } else if (s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
                ++i;
                ++j;
            } else return false;
        }
        if (i>=s.length()-1&&j>=p.length()-1&&flag)   return true;
        else return false;
    }
}
