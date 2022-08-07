import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        // 后序遍历 + 剪枝 （从底至顶）
        return recur(root)!=-1;

    }
    public int recur(TreeNode node){
        if(node==null)  return 0;
        int left=recur(node.left);
        if(left==-1)    return -1;
        int right=recur(node.right);
        if(right==-1)   return -1;
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
    public double convert(int[] l){
        return l[0];
    }

    public int totalSteps (int[] nums) {
        // write code here
        int res=0;
        int n=nums.length;
        int count=1;    //统计本次数组中被删除的个数
        int prev = 0,curr;
        while(count!=0){
            count=0;
            for(int i=0;i<n;i++){
                if(i==0){
                    prev=nums[0];
                    continue;
                }
                if(nums[i]==0)  continue;
                curr=nums[i];
                if(prev>curr){
                    nums[i]=0;
                    count++;
                }
                prev=curr;
            }
            if(count!=0)    res++;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode nodel = new TreeNode(2);
        TreeNode noder = new TreeNode(5);
        root.left = nodel;
        root.right = noder;
        TreeNode nodell = new TreeNode(1);
        nodel.left = nodell;
        nodel.right = new TreeNode(3);
        nodell.left = new TreeNode(7);
        nodell.right = new TreeNode(2);
        noder.left = new TreeNode(7);
        TreeNode noderr = new TreeNode(10);
        noder.right = noderr;
        noderr.left = new TreeNode(5);
        noderr.right = new TreeNode(1);

//        Node root=new Node(4);
//        Node rootl=new Node(2);
//        root.right=new Node(5);
//        root.left=rootl;
//        rootl.left=new Node(1);
//        rootl.right=new Node(3);
        Solution sol = new Solution();
//        sol.mirrorTree(root);
//        System.out.println(sol.uniquePaths(10,10));
//        System.out.println(func(15,20));
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "is", "day", "the", "the", "sunny", "is", "is"};
//        System.out.println(sol.isBalanced(root));
//        String[] strings=new String[]{"apple","paddle","pool","offer"};
//        Arrays.sort(strings);;
//        System.out.println(strings);
//        Arrays.sort(strings,(a,b)->b.compareTo(a));
//        System.out.println(strings);
//        Arrays.sort(strings,(a,b)->(a+b).compareTo(b+a));
//        System.out.println(strings);
//        ArrayList<Integer> l=new ArrayList<>();
//        l.add(0);
//        l.add(2);
//        l.add(1,10);
//        System.out.println(l);
//        System.out.println(sol.totalSteps(new int[]{5,4,3,2,1,1,1,1}));
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n1 = in.nextInt();      // 变量数
            Map<Character,String> map=new HashMap<>();
            for (int i = 0; i < n1; i++) {
                String k=in.next();
                String v=in.next();
                map.put(k.charAt(0),v);
            }
            int n2 = in.nextInt();      // 表达式个数
            for(int i=0;i<n2;i++){
                String s=in.next();
                String[] strings=s.split("\\s+");
                for(int j=0;j<strings.length;j++){
                    int res=0;
                    if(strings[j].length()==1 && strings[j].charAt(0)-'a'>=0 && strings[j].charAt(0)-'a'<=26){
                        res+=map.get(strings[j].charAt(0)).length()==1?map.get(strings[j].charAt(0)).charAt(0)-'0':0;
                    }
                    
                }
            }


        }





    }
}