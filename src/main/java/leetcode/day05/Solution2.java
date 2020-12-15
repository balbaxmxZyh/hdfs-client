package leetcode.day05;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/21 13:27
 * @Operation:
 * @Description:
 *
 *  冒泡排序
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] a = new int[]{200,4,1,7,12,10,54,-1,-56,-20,2,7,19};
        int[] b = solution.bubblingSort(a);
        for (int i :b){
            System.out.println(i);
        }
    }


    public int[] bubblingSort(int[] a){
        for (int i = 1;i < a.length;i++ ){
            for (int j = 0;j < a.length - i;j++ ){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

}
