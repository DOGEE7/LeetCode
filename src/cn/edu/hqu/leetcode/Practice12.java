package cn.edu.hqu.leetcode;

//贪心算法
public class Practice12 {
    public static void main(String[] args) {
        System.out.println(intToRoman2(4));
    }

    public static String intToRoman1(int num) {
        if (num < 1 || num > 3999) return null;
        String res = "";
        while (num != 0) {
            if (num >= 1000) {
                for (int i = num / 1000; i != 0; i--) res += "M";
                num = num % 1000;
            } else if (num >= 900) {
                res += "CM";
                num -= 900;
            } else if (num >= 500) {
                res += "D";
                num -= 500;
            } else if (num >= 400) {
                res += "CD";
                num -= 400;
            } else if (num >= 100) {
                for (int i = num / 100; i != 0; i--) res += "C";
                num = num % 100;
            } else if (num >= 90) {
                res += "XC";
                num -= 90;
            } else if (num >= 50) {
                res += "L";
                num -= 50;
            } else if (num >= 40) {
                res += "XL";
                num -= 40;
            } else if (num >= 10) {
                for (int i = num / 10; i != 0; i--) res += "X";
                num = num % 10;
            } else if (num == 9) {
                res += "IX";
                return res;
            } else if (num >= 5) {
                res += "V";
                num -= 5;
            } else if (num == 4) {
                res += "IV";
                return res;
            } else if (num >= 1) {
                for (int i = num; i != 0; --i) res += "I";
                return res;
            }
        }
        return res;
    }

    public static String intToRoman2(int num) {
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int index=12;
        StringBuilder res = new StringBuilder();
        while(index>=0){
            while(num>=nums[index]){
                res.append(romans[index]);
                num-=nums[index];
            }
            index--;
        }
        return String.valueOf(res);
    }

}
