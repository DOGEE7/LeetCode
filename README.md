### 《剑指offer（第2版）》
第 1 天 栈与队列（简单）  
[剑指 Offer 09. 用两个栈实现队列](https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)  简单 （栈 设计 队列）<br/>
[剑指 Offer 30. 包含min函数的栈](https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/) 简单 （栈 设计） —— *[本题与主站 155 题相同](https://leetcode-cn.com/problems/min-stack/)*<br/>

第 2 天 链表（简单）  
[剑指 Offer 06. 从尾到头打印链表](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/) 简单 (栈 递归 链表 双指针)    
[剑指 Offer 24. 反转链表](https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/) 简单 (递归 链表)   —— *[本题与主站 206 题相同](https://leetcode-cn.com/problems/reverse-linked-list/)*  &nbsp;&nbsp; tips：可用next指针实现逆转  
[剑指 Offer 35. 复杂链表的复制](https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/) 中等 (哈希表 链表)  ——  *[本题与主站 138 题相同](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)*  &nbsp;&nbsp; tips:①先复制再拆分，节省空间；②利用HashMap  

第 3 天 字符串（简单）  
[剑指 Offer 05. 替换空格](https://leetcode.cn/problems/ti-huan-kong-ge-lcof/) 字符串 （简单）   
[剑指 Offer 58 - II. 左旋转字符串](https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)   数学 双指针 字符串 （简单）

第 4 天 查找算法（简单）  
[剑指 Offer 03. 数组中重复的数字](https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)  数组 哈希表 排序 (简单) —— 1.借助HashSet；2.双循环暴力求解；3.原地交换，观察条件数值范围为0~n  
[剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)  数组 二分查找 (简单)  
[剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/) 位运算 数组 哈希表 数学 二分查找 (简单) —— 1.数学(高斯求和公式); 2.遍历; 3.双指针  

第 5 天 查找算法（中等）  
[剑指 Offer 04. 二维数组中的查找](https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/) 数组 二分查找 分治 矩阵 (中等) —— 1.二分法；2.右上角，二叉树查找    
[剑指 Offer 11. 旋转数组的最小数字](https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/) 数组 二分查找 (简单)  
[剑指 Offer 50. 第一个只出现一次的字符](https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/) 队列 哈希表 字符串 计数 (简单) —— 1.哈希表；2.数组

第 6 天 搜索与回溯算法（简单）  
[剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/) 树 广度优先搜索 二叉树 (中等)  
[剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/) 树 广度优先搜索 二叉树 (简单) —— [本题与主站 102 题相同](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)  利用queue的当前长度进行本层遍历  
[剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/) 树 广度优先搜索 二叉树 (中等) —— 1.双端队列；2.采用倒序Collections.reverse(list)  

第 7 天 搜索与回溯算法（简单）  
[剑指 Offer 26. 树的子结构](https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/) 树 深度优先搜索 二叉树 (中等) —— **递归**  
[剑指 Offer 27. 二叉树的镜像](https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/) 树 深度优先搜索 广度优先搜索 二叉树 (简单) —— 1.迭代；2.递归  
[剑指 Offer 28. 对称的二叉树](https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/) 树 深度优先搜索 广度优先搜索 二叉树 （简单） 

第 8 天 动态规划（简单）  
[剑指 Offer 10- I. 斐波那契数列](https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/) 记忆化搜索 数学 动态规划 (简单) —— 1.递归实现动态规划（记忆化搜索，即设置缓存数组）；2.递推实现动态规划；3.矩阵幂；4.打表（根据已知的数据范围）  
[剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/) 记忆化搜索 数学 动态规划 (简单) —— [注意：本题与主站 70 题相同](https://leetcode-cn.com/problems/climbing-stairs/) 所有方法同上（在动态规划中，状态是跳1或跳2，选择是当前的台阶数0~n)  
[剑指 Offer 63. 股票的最大利润](https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/) 数组 动态规划 (中等) —— [注意：本题与主站 121 题相同](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)    

第 9 天 动态规划（中等）  
[剑指 Offer 42. 连续子数组的最大和](https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/) 数组 分治 动态规划 (简单) —— [注意：本题与主站 53 题相同](https://leetcode-cn.com/problems/maximum-subarray/)  —— 动态规划  
[剑指 Offer 47. 礼物的最大价值](https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/) 数组 动态规划 矩阵 (中等) —— 动态规划（转移矩阵`f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)`）  

第 10 天 动态规划（中等）  
[剑指 Offer 46. 把数字翻译成字符串](https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/) 字符串 动态规划 (中等) —— 1.青蛙跳台阶；2.动态规划：状态转移矩阵！`若10<=num%100<=25,dp[i]=dp[i-1]+dp[i-2]; 否则dp[i]=dp[i-1]`    
[剑指 Offer 48. 最长不含重复字符的子字符串](https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/) 哈希表 字符串 滑动窗口 (中等) —— [注意：本题与主站 3 题相同](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) 动态指针×;滑动窗口，用set维护√







<br/>

****


### 《LeetCode 75》
#### Level1
第 1 天  
[1480. 一维数组的动态和](https://leetcode.cn/problems/running-sum-of-1d-array/) 数组 前缀和 (简单)  
[724. 寻找数组的中心下标](https://leetcode.cn/problems/find-pivot-index/)  数组 前缀和 (简单)

第 2 天  
[205. 同构字符串](https://leetcode.cn/problems/isomorphic-strings/) 哈希表 字符串 (简单)  
[392. 判断子序列](https://leetcode.cn/problems/is-subsequence/) 双指针 字符串 动态规划 (简单)

第 3 天  
[21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/) 递归 链表 (简单)  
[206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) 递归 链表 (简单)  

第 4 天  
[876. 链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list/) 链表 双指针 (简单) —— 1.ListNode列表；2.遍历两次列表（全遍历+半遍历）；3.快慢指针  
[142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) 哈希表 链表 双指针 (中等) —— 1.HashMap或HashSet; 2.两次双指针（快慢指针）

第 5 天  
[121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) 数组 动态规划 (简单) —— [股票问题|动态规划](https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%9B%A2%E7%81%AD%E8%82%A1%E7%A5%A8%E9%97%AE%E9%A2%98.md)；单层遍历    
[409. 最长回文串](https://leetcode.cn/problems/longest-palindrome/) 贪心 哈希表 字符串 (简单) —— 1.数组，`char c;count[c]++; //128个ASCII` 2.哈希表

第 6 天  
[589. N 叉树的前序遍历](https://leetcode.cn/problems/n-ary-tree-preorder-traversal/) 栈 树 深度优先搜索 (简单) —— 1.[递归法系列：一套拳法👊刷掉n个遍历树的问题](https://leetcode.cn/problems/n-ary-tree-preorder-traversal/solution/yi-tao-quan-fa-shua-diao-nge-bian-li-shu-de-wen--3/);2.迭代（栈）  
[102. 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/) 树 广度优先搜索 二叉树 (中等) —— [BFS 的使用场景总结：层序遍历、最短路径问题](https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/)

第 7 天  
[704. 二分查找](https://leetcode.cn/problems/binary-search/) 数组 二分查找 (简单) —— [二分法细节详解](https://leetcode.cn/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/)  
[278. 第一个错误的版本](https://leetcode.cn/problems/first-bad-version/) 二分查找 交互 (简单) —— 二分法细节`while(left<right); right=mid; left=mid+1; 最后判定条件是left==right`

第 8 天  
[98. 验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/) 树 深度优先搜索 二叉搜索树 二叉树 (中等) —— 1.（递归/非递归）中序遍历结果为递增；2.递归设置边界值（最大值、最小值）  
[235. 二叉搜索树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/) 树 深度优先搜索 二叉搜索树 二叉树 (简单) —— 利用二叉搜索树的特性（递归/迭代）`(root.val-p.val)*(root.val-q.val)<=0     // 替代比较`  

第 9 天  (Both)  
[733. 图像渲染](https://leetcode.cn/problems/flood-fill/) 深度优先搜索 广度优先搜索 数组 矩阵 (简单)
[200. 岛屿数量](https://leetcode.cn/problems/number-of-islands/) 深度优先搜索 广度优先搜索 并查集 数组 矩阵 (中等) —— [岛屿类问题的通用解法、DFS 遍历框架](https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/)

第 10 天  
[509. 斐波那契数](https://leetcode.cn/problems/fibonacci-number/) 递归 记忆化搜索 数学 动态规划 (简单)—— [动态规划套路详解](https://leetcode.cn/problems/fibonacci-number/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-labuladong/)  
[70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/) 记忆化搜索 数学 动态规划 (简单)  







<br/>



