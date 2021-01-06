package leetcode.day14;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2021/1/5 9:35
 * @Operation:
 * @Description:
 *
 * https://leetcode-cn.com/problems/count-number-of-teams/
 *
 * 1395. 统计作战单位数
 *  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 *
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 *
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] a = new int[]{2,5,3,4,1};
        System.out.println(solution.numTeams(a));
    }


    /**
     * 枚举算法
     * 假设i j k 三个值
     *
     * 满足a[i} < a[j]   jless 个
     * 满足a[j} < a[k]   jmost 个
     *
     * 一共符合要求  jless*jmost
     *
     * 同理
     *满足a[i} > a[j]   jless2 个
     *满足a[j} >a[k]   jmost2 个
     *
     *  一共符合要求  jless2*jmost2
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }
        int sum = 0;
        for (int j = 1; j < rating.length - 1; j++) {
            int jless = 0;
            int jmost = 0;
            int jless2 = 0;
            int jmost2 = 0;
            for (int i = 0; i < j; i++){
                if(rating[i] < rating[j]){
                    jless++;
                }else if(rating[i] > rating[j]){
                    jless2++;
                }
            }

            for (int k = rating.length-1; k > j; k--){
                if(rating[j] < rating[k]){
                    jmost++;
                }else if(rating[j] > rating[k]){
                    jmost2++;
                }
            }
            sum+=(jless*jmost)+(jless2*jmost2);
        }
        return sum;
    }
    public int numTeams2(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i+1; j < rating.length - 1; j++) {
                for (int k = j+1; k < rating.length; k++) {
                    if ((rating[i] > rating[j] && rating[j] > rating[k])) {
                        System.out.println(rating[i] + ":" + rating[j] + ":" + rating[k]);
                        sum++;
                    } else if ((rating[i] < rating[j] && rating[j] < rating[k])) {
                        System.out.println(rating[i] + ":" + rating[j] + ":" + rating[k]);
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
