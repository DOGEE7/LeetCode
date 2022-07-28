import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    private String name = "abc";
    static int[] cache=new int[100];
    static {
        cache[0]=0;
    }

    public static void main(String[] args) {
//        int n= (int) 1e9;
//        System.out.println((int)1e9+7);
//        Math.max(1,2);
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(4);
        List<Integer> copylist=new ArrayList<>(Arrays.asList(new Integer[list.size()]));
//        Collections.addAll(copylist,new Integer[list.size()]);
        Collections.copy(copylist,list);
        System.out.println(list);
        System.out.println(copylist);
        list.remove(0);
        System.out.println(list);
        System.out.println(copylist);

    }
}