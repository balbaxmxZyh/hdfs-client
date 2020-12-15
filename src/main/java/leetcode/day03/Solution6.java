package leetcode.day03;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/18 11:12
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/container-with-most-water/
 *
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 */
public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        int[] height = new int[]{4,3,2,1,5,6,7,1};
        System.out.println(solution.maxArea(height));
        System.out.println(solution.maxArea2(height));
    }

    public int maxArea(int[] height) {
        if(height.length < 2) {
            return 0;
        }
        int len = height.length;
        int max = 0;

        for (int i = 0;i < len;i++ ) {
            for (int j = i+1;j < len;j++ ) {
                int min = Math.min(height[i],height[j]);
                int volume = (j-i)*min;
                if(max < volume){
                    max = volume;
                }
            }
        }

        return max;
    }


    /**
     * 两个指针往中间移动
     * 1、每次移动都可以排除一个
     * 2、假设 左（低）  右（高）
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if(height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0,right = height.length - 1;

        while (left < right){
            int volume;
            if(height[left] > height[right]){
                volume =  (right - left)*height[right];
                right--;
            }else {
                volume =  (right - left)*height[left];
                left++;
            }
            if(max < volume){
                max = volume;
            }
        }

        return max;
    }
}
