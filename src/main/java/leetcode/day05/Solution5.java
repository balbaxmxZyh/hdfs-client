package leetcode.day05;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/21 13:27
 * @Operation:
 * @Description:
 *
 *  堆排序排序
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        int[] a = new int[]{-1000,5,0,31,-43,21,7,8,-9,1,78,2,6,99,100,-9};
        solution.stackSork(a);
        for (int i :a){
            System.out.println(i);
        }
    }


    /**
     * 交换最大根
     *
     * @param a
     */
    public void stackSork(int[] a){
        for (int i = a.length -1;i > 0;i --) {
            createStack(a, 0, i);
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }


    /**   5
     *  1     3
     * 4 2   7 8
     * 建堆
     * @param a
     * @param start
     * @param len
     */
    public void createStack(int[] a,int start ,int len){
        int begin = (len + 1)/ 2 - 1;
        for (;begin >= start;begin--){
            int left = begin * 2 + 1;
            int right = begin * 2 + 2;
            int max = begin;
            if (left <= len && a[left] > a[max]) {
                max = left;
            }
            if (right <= len && a[right] > a[max]) {
                max = right;
            }
            if (max != begin) {
                int temp = a[begin];
                a[begin] = a[max];
                a[max] = temp;
            }
        }
    }


    public void insertSort(int[] a,int left,int right){
        if(left < right){
            int mid = comparea(a,left,right);
            insertSort(a,left,mid - 1);
            insertSort(a,mid + 1,right);

        }
    }


    public int comparea(int[] a,int left,int right){
        int pri = a[left];
        while (left < right){
            while (left < right && a[right] >= pri){
                right--;
            }
            a[left] = a[right];

            while (left < right && a[left] <= pri){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pri;
        return left;
    }

}
