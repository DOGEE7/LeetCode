package cn.edu.hqu.leetcode;

import java.lang.annotation.ElementType;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        List<Integer> list1=new LinkedList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
        List<Integer> list2=new LinkedList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };

        Set<List<Integer>> listSet=new LinkedHashSet<>();
        listSet.add(list1);
        listSet.add(list2);
        for (List<Integer> list : listSet) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }




//        String str = "Hello  ,  world . ";
//        String pattern = "(\\w*)(\\s+)([.,])";
//
//        Pattern p=Pattern.compile(pattern);
//
//        Matcher m=p.matcher(str);
//
//        if (m.find()){
//            System.out.println("0:"+m.group(0));
//            System.out.println("1:"+m.group(1));
//            System.out.println("2:"+m.group(2));
//            System.out.println("3:"+m.group(3));
//        }else {
//            System.out.println("No find!");
//        }


//        // 按指定模式在字符串查找
//        String line = "This order was placed for QT3000! OK?";
//        String pattern = "(\\D*)(\\d+)(.*)";
//
//        // 创建 Pattern 对象
//        Pattern r = Pattern.compile(pattern);
//
//        // 现在创建 matcher 对象
//        Matcher m = r.matcher(line);
//        if (m.find( )) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//        } else {
//            System.out.println("NO MATCH");
//        }


    }
}


