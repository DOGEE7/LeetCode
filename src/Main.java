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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list2d = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();   //暂时存储，用于转换顺序
        Queue<TreeNode> queue = new LinkedList<>();   //存储
        boolean flag = true;  //true:左->右; false：右->左
        if (root == null) return list2d;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode tnode = queue.poll();
                list.add(tnode.val);
                if (flag) {
                    if (tnode.left != null) stack.push(tnode.left);
                    if (tnode.right != null) stack.push(tnode.right);
                } else {
                    if (tnode.right != null) stack.push(tnode.right);
                    if (tnode.left != null) stack.push(tnode.left);
                }
            }
            list2d.add(list);
            flag = !flag;
            while (!stack.isEmpty()) queue.offer(stack.pop());
        }
        return list2d;
    }

    public TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> newqueue = new LinkedList<>();
        TreeNode newtree = root;
        queue.offer(root);
        newqueue.offer(newtree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode newnode = newqueue.poll();
            if (node.right != null) {
                queue.offer(node.right);
                newnode.left = node.right;
                newqueue.offer(newnode.left);
            }
            if (node.left != null) {
                queue.offer(node.left);
                newnode.right = node.left;
                newqueue.offer(newnode.right);
            }
        }
        return newtree;
    }

    public int fib(int n) {
        if (n == 1 || n == 0) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public int maxProfit(int[] prices) {
        // 动态规划：状态：天数n、买卖一次k=1、reset(0或1)是否拥有股票；选择：卖、买、reset
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);   // 当前无股票
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);   // 当前持有股票
        }
        return dp[n][0];
    }

    public int maxValue(int[][] grid) {
        // 动态规划——状态为走m+n-1格、2个方向（选择:右0-下1）
        // 每一步都最大，结果最大？
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m + n - 1];
        for (int i = 0, j = 0, k = 0; k < (m + n - 1); k++) {
            if (k == 0) {
                dp[i] = grid[0][0];
                continue;
            }
            if (i >= m - 1 && j < n - 1) dp[k] = dp[k - 1] + grid[m - 1][j++];
            else if (i < m - 1 && j >= n - 1) dp[k] = dp[k - 1] + grid[i++][n - 1];
            else if (i < m - 1 && j < n - 1) {    // 向右j++；向下i++
                if (dp[k - 1] + grid[i][j + 1] > dp[k - 1] + grid[i + 1][j]) {
                    dp[k] = dp[k - 1] + grid[i][j + 1];
                    j++;
                } else {
                    dp[k] = dp[k - 1] + grid[i + 1][j];
                    i++;
                }
            } else break;

        }
        return dp[m + n - 2];

    }

    public int translateNum(int num) {
        // 动态规划 1.若num%100>=10&&<=25:dp[i]=dp[i-1]+dp[i-2];2.若num%100<10或>25，dp[i]=dp[i-1]
        int dpi = 0, dpi_1 = 1, dpi_2 = 1, x, y = num % 10;
        while (num > 0) {
            num = num / 10;
            x = num % 10;
            int tmp = x * 10 + y;
            dpi = (tmp >= 10 && tmp <= 25) ? dpi_1 + dpi_2 : dpi_1;
            dpi_2 = dpi_1;
            dpi_1 = dpi;
            y = x;
        }
        return dpi;
    }

    public int lengthOfLongestSubstring(String s) {
        // 动态规划：如果s[i]不在子串中，dp[i]=dp[i-1]+1; 否则max=dp[i-1]>max?dp[i-1]:max,dp[i-dp[i-1]+1]=1
        int n = s.length();
        if (n <= 1) return n;
        int[] dp = new int[n];
        int maxLen = 0;
        String subS = "";
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (i == 0) {
                dp[0] = 1;
                subS = s.substring(i, i + 1);
                maxLen = 1;
                i++;
                continue;
            }
            if (subS.indexOf(c) == -1) {
                dp[i] = dp[i - 1] + 1;
                subS = subS + c;
                i++;
            } else {
                maxLen = dp[i - 1] > maxLen ? dp[i - 1] : maxLen;
                i = i - subS.length() + 1;
                subS = s.substring(i, i + 1);
                dp[i] = 1;
                i++;
            }
        }
        return maxLen;
    }

    public int uniquePaths(int m, int n) {
        // 数学，C(m+n-2)(m-1):总共走m+n-2，向右走m-1步
        int a = m + n - 2;
        int b = (m < n) ? m - 1 : n - 1;
        int up = 1, down = 1;
        while (b != 0) {
            up *= a;
            down *= b;
            a--;
            b--;
        }
        return up / down;
    }

    public String reverseWords(String s) {
        // 双指针 + StringBuilder
        StringBuilder res = new StringBuilder();
        s = s.strip();
        int n = s.length();
        int j = n - 1, i = j;
        for (; i >= 0; i--) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().strip();
    }

    public List<Integer> findAnagrams(String s, String p) {
        // HashMap哈希表：key为char，value为次数
        int n1 = s.length();
        int n2 = p.length();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            char c = p.charAt(i);
            if (map2.containsKey(c)) map2.put(c, map2.get(c) + 1);
            else map2.put(c, 1);
        }
        for (int i = 0; i <= n1 - n2; ) {
            Map<Character, Integer> map1 = new HashMap<>();
            boolean fBreak = false; // 标记不同，组成不同：true；相同：false
            for (int j = i; j < i + n2; j++) {
                char c = s.charAt(j);
                if (map2.containsKey(c)) {
                    if (map1.containsKey(c)) map1.put(c, map1.get(c) + 1);
                    else map1.put(c, 1);
                } else {
                    fBreak = true;
                    i = j + 1;
                    break;
                }
            }
            if (fBreak) continue;
            else {
                if (compare(map1, map2)) res.add(i);
                i++;
            }
        }
        return res;
    }

    // 比较两个map是否相等
    public boolean compare(Map map1, Map map2) {
        Set<Character> set1 = map1.keySet();
        Set<Character> set2 = map2.keySet();
        if (set1.size() != set2.size()) return false;
        for (char c : set1) {
            if (map1.get(c) != map2.get(c)) return false;
        }
        return true;
    }

    public int characterReplacement(String s, int k) {
        // 双指针，滑动窗口——数组存储26个字母
        int n = s.length();
        int left = 0, right = 0;
        int maxv = 0;
        int[] sarr = new int[26];
        int res = 0;
        while (right < n) {
            sarr[s.charAt(right) - 'A']++;
            maxv = sarr[s.charAt(right) - 'A'] > maxv ? sarr[s.charAt(right) - 'A'] : maxv;
            if (right - left + 1 - maxv > k) {
                sarr[s.charAt(left) - 'A']--;
                left++;
            } else {
                res = right - left + 1 > res ? right - left + 1 : res;
                right++;
            }
        }
        return res;

    }

    public String getHint(String secret, String guess) {
        // hashmap哈希表
        int Anum = 0, Bnum = 0;     // Anum为公牛个数，Bnum为奶牛个数
        int n = secret.length();  // secret和guess的长度一样
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = guess.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) Anum++;
            else {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) - 1);
                    Bnum++;
                }
            }
        }
        String res = String.valueOf(Anum) + "A" + String.valueOf(Bnum) + "B";
        return res;
    }

    public String decodeString(String s) {
        // 数字栈，字符栈
        String res= "";
        int n=s.length();
        int i=0;
        int count=0;    // 计数括号
        Deque<Integer> stackNum=new LinkedList<>();
        Deque<Character> stackStr=new LinkedList<>();
        while(i<n){
            int tmpNum=0;
            while(i<n && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
                tmpNum=tmpNum*10+(s.charAt(i)-'0');
                i++;
            }
            tmpNum=tmpNum==0?1:tmpNum;
            stackNum.push(tmpNum);
            while(i<n && !(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)){
                if(s.charAt(i)=='['){
                    stackStr.push(s.charAt(i));
                    count++;
                }
                else if(s.charAt(i)==']')   count--;
                else stackStr.push(s.charAt(i));
                i++;
                if(count==0 && !stackStr.isEmpty())  break;
            }
            if(count==0){
                String tmpStr="";
                while(!stackStr.isEmpty()){
                    while(!stackStr.isEmpty() && stackStr.peek()!='['){
                        tmpStr=stackStr.pop()+tmpStr;
                    }
                    if(!stackStr.isEmpty() && stackStr.peek()=='[')  stackStr.pop();
                    String tmp=tmpStr;
                    int num=stackNum.pop();
                    for(int k=0;k<num-1;k++){
                        tmpStr+=tmp;
                    }
                }
                res=res+tmpStr;
            }
        }
        return res;
    }
}

public class Main {
    int N = 30;
    static int[] cache = new int[30];

    static {
        cache[0] = 0;
        cache[1] = 1;
    }

    static int func(int i, int j) {
        if (i <= 0 || j <= 0) return 1;
        return 2 * func(i - 3, j / 2);

    }

    public static void main(String[] args) {
//        TreeNode root=new TreeNode(3);
//        TreeNode nodel=new TreeNode(9);
//        TreeNode noder=new TreeNode(20);
//        root.left=nodel;
//        root.right=noder;
//        noder.left=new TreeNode(15);
//        noder.right=new TreeNode(7);
        Solution sol = new Solution();
//        sol.mirrorTree(root);
//        System.out.println(sol.uniquePaths(10,10));
//        System.out.println(func(15,20));
        System.out.println(sol.decodeString("2[cd]ef"));
        Arrays.sort();


    }
}