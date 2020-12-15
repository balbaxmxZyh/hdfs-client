package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhangyh
 * @ClassName: Test1
 * @Date: 2020/11/24 13:58
 * @Operation:
 * @Description: ${description}
 */
public class Test1 {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        System.out.println("192.168.1.0:1111".hashCode());
        String str = Integer.toOctalString(9);
        Integer a = Integer.valueOf("11111",2) & Integer.valueOf("101",2);
        System.out.println(Integer.toBinaryString(a));
        /*while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PingUtil.ping("10.46.51.227");
        }*/
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;

    }


}
