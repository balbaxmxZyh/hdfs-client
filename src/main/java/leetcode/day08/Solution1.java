package leetcode.day08;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/25 14:02
 * @Operation:
 * @Description: ${description}
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] a = new int[]{1,67,-1,2,5,23,7,0,122,234,43,1,5,7};

//        solution.quickSort(0,a.length-1,a);
        solution.heapSort(a);

        for (int i : a){
            System.out.println(i);
        }

    }


    public void quickSort(int left,int right,int[] a){
        if(left < right){
            int mid = compare(left,right,a);
            quickSort(left,mid-1,a);
            quickSort(mid+1,right,a);

        }

    }

    public int compare(int left,int right,int[] a){
        int mid = a[left];
        while (left < right){

            while (left < right && a[right] >= mid){
                right--;
            }
            a[left] = a[right];

            while (left < right && a[left] <= mid){
                left++;
            }
            a[right] = a[left];

        }

        a[left] = mid;

        return left;
    }



    public void heapSort(int[] a){
        for (int i = a.length -1;i > 0;i--){
            createHeap(a,0,i);
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }

    /**
     * 建最大堆
     * @param a
     * @param left
     * @param right
     */
    public void createHeap(int[] a,int left,int right){
        // i 的左节点 2(i+1)-1
        // i 的右节点 2(i+1)
        // right 的根节点 （right+1）/2 -1
        int start = (right+1)/2 -1;
        for (int i = start;i >= left;i--){
            int l = 2*(i+1)-1;
            int r = 2*(i+1);
            int max = i;
            if( l <= right && a[l] > a[max]){
                max = l;
            }
            if( r <= right && a[r] > a[max]){
                max = r;
            }
            if(max != i){
                int temp = a[max];
                a[max] = a[i];
                a[i] = temp;
            }
        }

    }


}
