package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MyThead extends Thread{
    public static void main(String[] args) {
        MyThead t=new MyThead();
        MyThead s=new MyThead();
        t.start();
        System.out.println("one.");
        s.start();
        System.out.println("two.");
    }
    public void run() {
        System.out.println("Thread");
    }
}
