package leetcode.day05;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/21 13:27
 * @Operation:
 * @Description:
 *
 *  普通排序
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] a = new int[]{200,4,1,7,12,10,54,-1,-56,-20,2,7,19};
        int[] b = solution.commonSort(a);
        for (int i :b){
            System.out.println(i);
        }
    }


    public int[] commonSort(int[] a){
        for (int i = 0;i < a.length;i++ ){
            int min = i;
            for (int j = i + 1;j < a.length;j++ ){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        return a;
    }

}
