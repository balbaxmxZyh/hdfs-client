package leetcode.day02;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/11/16 16:08
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *  
 *
其实不用保存到一个新数组
 * 只要判定是否中间位置
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] a1 = new int[]{3};
        int[] a2 = new int[]{-2};

        //123345569 10
        System.out.println(solution.findMedianSortedArrays(a1,a2));

    }

    /**
     * 其实不用保存到一个新数组
     * 只要判定是否中间位置
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length == 0 && nums2.length == 0){
            return 0.0;
        }
        if(nums1.length == 0){
            int mid1 = (nums2.length)/2;
            int mid2 = (nums2.length)%2==0?mid1-1:-1;
            if(mid2 == -1){
                return nums2[mid1];
            }else {
                return (nums2[mid1]+nums2[mid2]) / 2.0;
            }
        }
        if(nums2.length == 0){
            int mid1 = (nums1.length)/2;
            int mid2 = (nums1.length)%2==0?mid1-1:-1;
            if(mid2 == -1){
                return nums1[mid1];
            }else {
                return (nums1[mid1]+nums1[mid2]) / 2.0;
            }
        }
        int i =0 , j = 0,k = 0;
        int lenA = nums1.length;
        int lenB = nums2.length;
        int[] result = new int[lenA+lenB];
        int mid1 = (lenA+lenB)/2;
        int mid2 = (lenA+lenB)%2==0?mid1-1:-1;
        while (i < lenA || j < lenB){
            if(nums1[i] <= nums2[j]){
                result[k] = nums1[i];
                if(i >= lenA-1){
                    for (;j < lenB;j++){
                        k++;
                        result[k] = nums2[j];
                    }
                    break;
                }
                i++;
            }else {
                result[k] = nums2[j];
                if(j >= lenB-1){
                    for (;i < lenA;i++){
                        k++;
                        result[k] = nums1[i];
                    }
                    break;
                }
                j++;
            }
            k++;
        }
        if(mid2 == -1){
            return result[mid1];
        }else {
            return (result[mid1]+result[mid2]) / 2.0;
        }
    }



}
