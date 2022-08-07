import java.util.*;


public class Test {
    public int singleNumber(int[] nums) {
        // 利用HashMap
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)==1) return key;
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

    }
}
