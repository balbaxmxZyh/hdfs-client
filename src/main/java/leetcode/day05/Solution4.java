package leetcode.day05;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/21 13:27
 * @Operation:
 * @Description:
 *
 *  快速排序
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] a = new int[]{200,4,1,7,12,10,54,-1,-56,-20,2,7,19};
        solution.quickSork(a,0,a.length-1);
        for (int i :a){
            System.out.println(i);
        }
    }


    /**
     *  分解
     *
     * @param a
     * @param left
     * @param right
     */
    public void quickSork(int[] a ,int left,int right){
        if(left < right){
            int mid = compare(a,left,right);
            quickSork(a,left,mid-1);
            quickSork(a,mid+1,right);
        }
    }

    /**
     * 找到 a[left] 的位置 mid
     * 分解 [left-mid-1] mid [mid+1,right]
     *
     * 找到a[left] 的位置 mid2,和a[mid+1] 的位置 mid3
     *
     * 分解...
     * @param a
     * @param left
     * @param right
     * @return
     */
    public int compare(int[] a,int left,int right){

        int pri = a[left];
        while (left < right){
            while (left < right && a[right] >= pri){
                right--;
            }
            a[left] = a[right];

            while (left <right && a[left] <= pri){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pri;
        return left;

    }





}
