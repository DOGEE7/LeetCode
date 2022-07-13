package leetcode;

public class Practice13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMM"));
    }

    public static int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        int i=0;
        int res=0;
        while (index < romans.length) {
            while (i<s.length()) {
                if ((i+2<s.length())&&s.substring(i,i+2).equals(romans[index]))    {res+=nums[index];i+=2;}
                else if ((i+2==s.length())&&s.substring(i).equals(romans[index]))  {res+=nums[index];i+=2;}
                else if ((i+1<s.length())&&s.substring(i,i+1).equals(romans[index]))  {res+=nums[index];i++;}
                else if((i+1==s.length())&&s.substring(i).equals(romans[index])) {res+=nums[index];i++;}
                else break;
            }
            index++;
        }

        return res;
    }
}
