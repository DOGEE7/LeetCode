package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Practice17 {
    public static void main(String[] args) {
        String digits="234";
        List<String>stringList=letterCombinations(digits);
        for (String s : stringList) {
            System.out.print(s+" ");
        }
    }

    //想到用递归，但是还是写不出来...
    static Map<Character, String> mapTel = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    static List<String> reList ;

    public static List<String> letterCombinations(String digits) {
        reList = new LinkedList<>();
        if (digits.equals(""))
            return reList;
        findComb(digits,"",0);
        return reList;
    }
    public static void findComb(String digits,String s,int index){
        if (index==digits.length()){
            reList.add(s);
            return;
        }
        Character c=digits.charAt(index);
        String letters=mapTel.get(c);
        for (int i=0;i<letters.length();++i){
            findComb(digits,s+letters.charAt(i),index+1);
        }

    }
}
