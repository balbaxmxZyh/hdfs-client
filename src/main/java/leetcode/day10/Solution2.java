package leetcode.day10;

import javax.naming.ldap.LdapReferralException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/12/13 10:23
 * @Operation:
 * @Description: ${description}
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] a = new int[]{0,0,0,0};
        List<List<Integer>> l = solution.threeSum(a);
        for (List<Integer> i : l){
            System.out.println(i);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 3){
            return list;
        }

        quickSort(0,nums.length-1,nums);

        for (int i = 0 ;i < nums.length;i++){
            if(nums[i] > 0){
                break;
            }

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            int a = nums[i];
            while (left < right){
                //a 固定值，b只能变大，c只能变小
                int b = nums[left];
                int c = nums[right];
                if(a + b + c == 0){
                    left++;
                    right--;
                    List<Integer> node = new ArrayList<>();
                    node.add(a);
                    node.add(b);
                    node.add(c);
                    list.add(node);
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(a + b + c > 0){
                    //太大
                    right--;
                }else if(a + b + c < 0){
                    //太小
                    left++;
                }

            }
        }

        return list;
    }

    public void quickSort(int left,int right ,int[] a){

        if(left < right){
            int mid = looking(left,right,a);
            quickSort(left,mid-1,a);
            quickSort(mid+1,right,a);
        }
    }

    public int looking(int left,int right ,int[] a){
        int mid = a[left];
        while (left <right){
            while (left < right && a[right] >= mid){
                right--;
            }
            a[left] = a[right];

            while (left <right && a[left] <= mid){
                left++;
            }
            a[right] = a[left];
        }

        a[left] = mid;
        return left;
    }
}
