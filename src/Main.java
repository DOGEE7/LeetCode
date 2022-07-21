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
    public int maxValue(int[][] grid) {
        // 动态规划——状态为走m+n-1格、2个方向（选择:右0-下1）
        // 每一步都最大，结果最大？
        int m=grid.length;
        int n=grid[0].length;
        int[] dp=new int[m+n-1];
        for(int i=0,j=0,k=0; k<(m+n-1);k++){
            if(k==0){
                dp[i]=grid[0][0];
                continue;
            }
            if(i>=m-1 && j<n-1)    dp[k]=dp[k-1]+grid[m-1][j++];
            else if(i<m-1 && j>=n-1)    dp[k]=dp[k-1]+grid[i++][n-1];
            else if(i<m-1 && j<n-1){    // 向右j++；向下i++
                if(dp[k-1]+grid[i][j+1]>dp[k-1]+grid[i+1][j]){
                    dp[k]=dp[k-1]+grid[i][j+1];
                    j++;
                }else{
                    dp[k]=dp[k-1]+grid[i+1][j];
                    i++;
                }
            }else   break;

        }
        return dp[m+n-2];

    }

    public int translateNum(int num) {
        // 动态规划 1.若num%100>=10&&<=25:dp[i]=dp[i-1]+dp[i-2];2.若num%100<10或>25，dp[i]=dp[i-1]
        int dpi=0,dpi_1=1,dpi_2=1,x,y=num%10;
        while(num>0){
            num=num/10;
            x=num%10;
            int tmp=x*10+y;
            dpi=(tmp>=10 && tmp<=25)?dpi_1+dpi_2:dpi_1;
            dpi_2=dpi_1;
            dpi_1=dpi;
            y=x;
        }
        return dpi;
    }

    public int lengthOfLongestSubstring(String s) {
        // 动态规划：如果s[i]不在子串中，dp[i]=dp[i-1]+1; 否则max=dp[i-1]>max?dp[i-1]:max,dp[i-dp[i-1]+1]=1
        int n=s.length();
        if(n<=1)    return n;
        int[] dp=new int[n];
        int maxLen=0;
        String subS="";
        int i=0;
        while(i<n){
            char c=s.charAt(i);
            if(i==0){
                dp[0]=1;
                subS=s.substring(i,i+1);
                maxLen=1;
                i++;
                continue;
            }
            if(subS.indexOf(c)==-1){
                dp[i]=dp[i-1]+1;
                subS=subS+c;
                i++;
            }else{
                maxLen=dp[i-1]>maxLen?dp[i-1]:maxLen;
                i=i-subS.length()+1;
                subS=s.substring(i,i+1);
                dp[i]=1;
                i++;
            }
        }
        return maxLen;
    }
}

public class Main {
    int N=30;
    static int[] cache=new int[30];
    static {
        cache[0]=0;
        cache[1]=1;
    }
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
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(sol.maxProfit(prices));
//        System.out.println(sol.maxValue(grid));
//        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        Deque<int[]> stack =new LinkedList<>();
        stack.push(new int[]{0, 9});
        int[] tmp=stack.pop();
        System.out.printf("%d,%d",tmp[0],tmp[1]);
        cache[0]=0;




    }
}