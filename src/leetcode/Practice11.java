package leetcode;

import java.util.regex.Matcher;

/*
* 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Practice11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));
    }

    //解法1：暴力求解O(n^2)
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    //解法2：双指针法：两头向中间移动，不动的是较长的指针
    public static int maxArea2(int[] height) {
        int area;
        int maxArea = 0;
        for (int l = 0, r = height.length-1; l < r; ) {
            area = Math.min(height[l], height[r]) * (r - l);
            maxArea=Math.max(area,maxArea);
            if (height[l]<height[r])    l++;
            else r--;
        }
        return maxArea;
    }
}
