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
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list2d=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();   //暂时存储，用于转换顺序
        Queue<TreeNode> queue=new LinkedList<>();   //存储
        boolean flag=true;  //true:左->右; false：右->左
        if(root==null)  return list2d;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<queue.size();i++){
                TreeNode tnode=queue.poll();
                list.add(tnode.val);
                if(flag){
                    if(tnode.left!=null)    stack.push(tnode.left);
                    if(tnode.right!=null)   stack.push(tnode.right);
                }else{
                    if(tnode.right!=null)   stack.push(tnode.right);
                    if(tnode.left!=null)    stack.push(tnode.left);
                }
            }
            list2d.add(list);
            flag=!flag;
            while(!stack.isEmpty()) queue.offer(stack.pop());
        }
        return list2d;
    }
    public TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> newqueue=new LinkedList<>();
        TreeNode newtree=root;
        queue.offer(root);
        newqueue.offer(newtree);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            TreeNode newnode=newqueue.poll();
            if(node.right!=null){
                queue.offer(node.right);
                newnode.left=node.right;
                newqueue.offer(newnode.left);
            }
            if(node.left!=null){
                queue.offer(node.left);
                newnode.right=node.left;
                newqueue.offer(newnode.right);
            }
        }
        return newtree;
    }
    public int fib(int n) {
        if(n==1 || n==0) return n;
        return fib(n-1)+fib(n-2);
    }
    public int maxProfit(int[] prices) {
        // 动态规划：状态：天数n、买卖一次k=1、reset(0或1)是否拥有股票；选择：卖、买、reset
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n+1;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);   // 当前无股票
            dp[i][1]=Math.max(dp[i-1][1],-prices[i-1]);   // 当前持有股票
        }
        return dp[n][0];
    }
}

public class Main {

    public static void main(String[] args) {
//        TreeNode root=new TreeNode(3);
//        TreeNode nodel=new TreeNode(9);
//        TreeNode noder=new TreeNode(20);
//        root.left=nodel;
//        root.right=noder;
//        noder.left=new TreeNode(15);
//        noder.right=new TreeNode(7);
        Solution sol=new Solution();
//        sol.mirrorTree(root);
        int[] prices=new int[]{7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices));


    }
}