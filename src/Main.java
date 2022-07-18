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
}

public class Main {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode nodel=new TreeNode(9);
        TreeNode noder=new TreeNode(20);
        root.left=nodel;
        root.right=noder;
        noder.left=new TreeNode(15);
        noder.right=new TreeNode(7);
        Solution sol=new Solution();
        sol.mirrorTree(root);


    }
}