package cn.edu.hqu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

/**
 * 改进：选用字符串数组
 */
public class Practice6 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
        int _nienk$e=0;
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String[] arrays = new String[numRows];
        for (int i=0;i<numRows;++i)    arrays[i]="";
        int row = 0;
        int n = 0;
        if (row == 0) {
            while (n < s.length() && row < numRows) {
                arrays[row]+=s.charAt(n);
                ++row;
                ++n;
            }
        }
        while (n<s.length()){
            if (row==-1){
                row+=2;
                while (n < s.length() && row < numRows) {
                    arrays[row]+=s.charAt(n);
                    ++row;
                    ++n;
                }
            }
            if (row==numRows){
                row-=2;
                while (n<s.length()&&row>=0){
                    arrays[row]+=s.charAt(n);
                    --row;
                    ++n;
                }
            }
        }
        String re="";
        for (String array : arrays) re+=array;
        return re;

    }

//    public static String convert(String s, int numRows) {
////       泛型数组创建： E[] array= (E[]) new Object[length];
//        List[] array = new ArrayList[numRows];
//        for (int i = 0; i < numRows; ++i) {
//            array[i] = new ArrayList();
//        }
//        int row = 0;
//        int n = 0;
//        if (numRows == 1)
//            return s;
//        //第一次特殊
//        if (row == 0) {
//            while (row < numRows && n < s.length()) {
//                array[row].add(s.charAt(n));
//                ++n;
//                ++row;
//            }
//        }
//        //后几次
//        while (n < s.length()) {
//            if (row == -1) {
//                row += 2;
//                while (row < numRows && n < s.length()) {
//                    array[row].add(s.charAt(n));
//                    ++n;
//                    ++row;
//                }
//            }
//            if (row == numRows) {
//                row -= 2;
//                while (row >= 0 && n < s.length()) {
//                    array[row].add(s.charAt(n));
//                    ++n;
//                    --row;
//                }
//            }
//        }
//        String re = "";
//        for (int i = 0; i < numRows; ++i) {
//            for (int j = 0; j < array[i].size(); ++j) {
//                re += array[i].get(j);
//            }
//        }
//        return re;
//    }

}
