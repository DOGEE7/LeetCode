package leetcode;

public class Practice14 {
    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix2(strings));
    }

    //横向扫描O(m*n)
    public static String longestCommonPrefix1(String[] strs) {
        StringBuilder re = new StringBuilder("");
        if (strs.length == 1) return strs[0];
        if (strs.length == 0) return "";
        int minLen = strs[0].length();
        boolean flagBreak=false;
        for (int i = 1; i < strs.length; ++i) minLen = Math.min(strs[i].length(), minLen);
        for (int i = 0; i < minLen; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (c == strs[j].charAt(i)) continue;
                else flagBreak=true;
            }
            if (flagBreak)  break;
            re.append(c);
        }
        return re.toString();
    }
    //逐减prefix获得最长公共子串
    public static String longestCommonPrefix2(String[] strs){
        if (strs.length == 0) return "";
        String res=strs[0];
        for (int i=1;i<strs.length;++i){
            while (strs[i].indexOf(res.toString())!=0){
                res=res.substring(0,res.length()-1);
            }
        }
        return res;
    }
}
