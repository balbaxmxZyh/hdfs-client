package leetcode.day01;

/**
 * @Author: zhangyh
 * @ClassName: OnlyEdit
 * @Date: 2020/10/14 16:55
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/one-away-lcci/
 */
public class OnlyEdit {

    public static void main(String[] args) {
        OnlyEdit onlyEdit = new OnlyEdit();
        System.out.println(onlyEdit.oneEditAway("horse","hosre"));
    }

    public boolean oneEditAway(String first, String second) {
        int fLen = first.length();
        int sLen = second.length();
        if(fLen == sLen){
            //有可能:替换一个字符,
            // 只能一种情况有一个位置字符不一样
            char[] fchars = first.toCharArray();
            char[] schars = second.toCharArray();
            int u = 0;
            for (int i = 0 ;i < fLen ; i++){
                if(fchars[i] == schars[i]){
                    continue;
                }
                if(u > 0){
                    return false;
                }
                u++;
            }
            return true;
        }else if (fLen == sLen + 1 || fLen+1 == sLen){
            //有可能：删除一个字符
            //当等位出现不一样时候，后续必须都一样
            char[] fchars = first.toCharArray();
            char[] schars = second.toCharArray();
            if(fLen+1 == sLen){
                fchars = second.toCharArray();
                schars = first.toCharArray();
            }
            boolean flag = false;
            for (int i = 0,j = 0 ;i < fLen && j < sLen; i++){
                if(fchars[i] == schars[j]){
                    j++;
                    continue;
                }
                if(flag){
                    return false;
                }
                flag = true;
            }
            return true;
        }
        
        return false;
        

    }
}
