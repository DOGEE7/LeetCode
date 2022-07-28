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

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    int k;
    int res;
    public int kthLargest(TreeNode root, int k) {
        // 右中左遍历
        this.k=k;
        return res;
    }

    public void dfs(TreeNode node){
        if(node==null)  return;
        dfs(node.right);
        k--;
        if(k==0)    res=node.val;
        dfs(node.left);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        TreeNode nodel=new TreeNode(2);
        TreeNode noder=new TreeNode(5);
        root.left=nodel;
        root.right=noder;
        TreeNode nodell=new TreeNode(1);
        nodel.left=nodell;
        nodel.right=new TreeNode(3);
//        nodell.left=new TreeNode(7);
//        nodell.right=new TreeNode(2);
//        noder.left=new TreeNode(7);
//        TreeNode noderr=new TreeNode(10);
//        noder.right=noderr;
//        noderr.left=new TreeNode(5);
//        noderr.right=new TreeNode(1);

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
        System.out.println(sol.kthLargest(root,3));



    }
}