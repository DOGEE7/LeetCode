// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<List> list2d=new ArrayList<>();
        for(int i=0;i<3;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=i;j<4;j++){
                list.add(i*j+1);
            }
            list2d.add(list);
        }
        Integer[][] arr2d=new Integer[list2d.size()][];
        int k=0;
//        for(List<Integer> l:list2d){
//            int[] arr=new int[l.size()];
//            int i=0;
//            for(int a:l){
//                arr[i++]=a;
//            }
//            arr2d[k++]=l.toArray(new Integer[0]);
//        }
        int[] arr={0,1,2,3,4};
        List<Integer> list=new ArrayList<>(arr.length);
        System.out.println(Arrays.deepToString(arr2d));
    }
}