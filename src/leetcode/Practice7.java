package leetcode;
/*
* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

//import org.omg.CORBA.INTERNAL;

public class Practice7 {
    public static void main(String[] args) {
        System.out.println(reverse(153423));
    }

//    public static int reverse(int x) {
//        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) return 0;
//        boolean negFlag = false;
//        if (x < 0) {
//            negFlag = true;
//        }
//        long absX=(long)Math.abs(x);
//        String s = String.valueOf(absX);
//        int len = s.length();
//        long re = 0;
//        for (int i = len - 1; i >= 0; --i) {
//            long div = (int) Math.pow(10, i);
//            long mul = (int) Math.pow(10, (len - 1 - i));
//            re = re + absX / div * mul;
//            absX = absX % div;
//        }
//        if (re > Integer.MAX_VALUE) return 0;
//        if (negFlag) re = -re;
//        return (int)re;
//    }
    public static int reverse(int x){
//        if (x>Integer.MAX_VALUE||x<Integer.MIN_VALUE)   return 0;
//        boolean negFlag=false;
//        if (x<0) negFlag=true;
//        x=Math.abs(x);
        int pop=0;
        int re=0;
        while (x!=0){
            pop=x%10;
            if (re>Integer.MAX_VALUE/10||(re==Integer.MAX_VALUE/10&&pop>7)) return 0;
            else if (re<Integer.MIN_VALUE/10||(re==Integer.MIN_VALUE/10&&pop<-8))   return 0;
            re=re*10+pop;
            x=x/10;
        }
        return re;
    }

}
