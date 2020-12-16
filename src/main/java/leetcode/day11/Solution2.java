package leetcode.day11;

import sun.security.util.Length;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/12/15 20:35
 * @Operation:
 * @Description: ${description}
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] a = new int[]{1,3,4,5};
        System.out.println(solution.searchInsert2(a,2));
    }

    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }
        boolean a = true;
        if(nums[0] > nums[nums.length - 1]){
            a = false;
            //倒序
        }
        for (int i = 0;i < nums.length;i++){
            if(a) {
                if (nums[i] >= target){
                    return i;
                }
            }else {
                if (nums[i] <= target){
                    return i;
                }
            }

        }
        return nums.length;
    }


    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */

    public int searchInsert2(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }
        boolean a = true;
        int left = 0;
        int right = nums.length - 1;

        if(nums[left] > nums[right]){
            a = false;
            //倒序
        }
        while (left <= right){
            int mid = (left +right)/2;
            if(a) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return left;
    }
}
