package leetcode.day05;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/21 13:27
 * @Operation:
 * @Description:
 *
 *  插入排序
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] a = new int[]{2,4,1,7,12,10,54,-1,-5,-20,2,7,9};
        int[] b = solution.insertSort(a);
        for (int i :b){
            System.out.println(i);
        }
    }


    public int[] insertSort(int[] a){
        for (int i = 1;i < a.length;i++ ){
            for (int j = 0;j < i;j++ ){
                if(a[i] < a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

}
