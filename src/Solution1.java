import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;


class Fool{
    int i=3;
}
public class Solution1 {
    /**
     * 求解字符串最长子串的长度
     * @param s string字符串 
     * @return int整型
     */
    public int lengthOfLongestSubstring (String s) {
        // write code here
        // 借助set
        Set<Character> set=new HashSet<>();
        int n=s.length();
        if(n==0)    return 0;
        int maxLen=1;
        int j=0;    //左指针
        for(int i=0;i<n;i++){
            if(set.contains(s.charAt(i))){
                while(s.charAt(j)!=s.charAt(i)){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            maxLen=(i-j+1)>maxLen?(i-j+1):maxLen;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Solution1 sol=new Solution1();
//        System.out.println(sol.lengthOfLongestSubstring("abcbbcacab"));
        int a=Integer.parseInt("12");
        int b=Integer.valueOf("12").intValue();

    }
}