package leetcode.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2021/1/5 11:08
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/pairs-with-sum-lcci/
 *
 * 面试题 16.24. 数对和
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 * 示例 1:
 *
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 *
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] a = new int[]{2, 1, 8, 6, 5, 7, -1, 3, 5, 5};
        System.out.println(solution.pairSums(a,7));
    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 2){
            return result;
        }

        //排序
//        quickSort(nums,0,nums.length-1);
//        heapSort(nums);
        mergeSort(nums,0,nums.length -1);
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            if(nums[left] + nums[right] == target){
                List<Integer> list = new ArrayList<>(2);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                left++;
                right--;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }

    public void quickSort(int[] a,int left,int right){
        if(left < right){
            int mid = chooseSort(a,left,right);
            quickSort(a,left,mid-1);
            quickSort(a,mid+1,right);
        }
    }

    public int chooseSort(int[] a,int left,int right){
        int temp = a[left];
        while (left < right){
            while (left < right && temp <= a[right]){
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }



    public void heapSort(int[] a){

        for (int i = a.length - 1;i >= 0;i--){
            createHeap(a,0,i);
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }

    /**
     *  从1编号开始
     *  i  左孩子 i*2
     *     右孩子 i*2+1
     *  从0编号开始
     *  i  左孩子 （i+1）*2-1    2*i+1
     *     右孩子 （i+1）*2+1-1  2*i+2
     *
        从1编号开始
        n  的父节点 n/2

     *  0编号开始
     *  n  的父节点 （n+1）/2 -1

     *
     *
     * @param a
     * @param left
     * @param right
     */
    public void createHeap(int[] a,int left,int right){
        //最后一个非叶子节点
        int last = (right+1)/2 -1;
        for (int i = last;i >= left ;i--){
            //左孩子
            int lChilren = (i+1) * 2 -1;
            int rChilren = (i+1) * 2;
            int max = i;
            if(lChilren <= right && a[lChilren] > a[max]){
                max = lChilren;
            }
            if(rChilren <= right && a[rChilren] > a[max]){
                max = rChilren;
            }
            if(max != i){
                int temp = a[max];
                a[max] = a[i];
                a[i] = temp;
            }
        }
    }



    public void mergeSort(int[] a ,int left,int right){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }

    public void merge(int[] a ,int left ,int mid,int right) {
        int[] tmpArray = new int[a.length];
        int rightStart = mid + 1;
        int tmp = left;
        int third = left;
        //比较两个小数组相应下标位置的数组大小，小的先放进新数组
        while (left <= mid && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                tmpArray[third++] = a[left++];
            } else {
                tmpArray[third++] = a[rightStart++];
            }
        }
        //如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
        while (left <= mid) {
            tmpArray[third++] = a[left++];
        }
        //如果右边还有数据......
        while (rightStart <= right) {
            tmpArray[third++] = a[rightStart++];
        }
        while (tmp <= right) {
            a[tmp] = tmpArray[tmp++];
        }
    }
}
