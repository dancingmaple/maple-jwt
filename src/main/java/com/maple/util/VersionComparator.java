package com.maple.util;

/**
 * @author zhongsj
 * @date 2020/4/20 17:46
 */
public class VersionComparator {


    public VersionComparator() {
    }

    public static void main(String[] args) {
        String v1 = "1.1.1";
        String v2 = "1.9.2";
        System.out.println(compareTo(v1, v2));
    }

    public static int compareTo(String v1, String v2) {
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int max = Math.max(len1, len2);

        for(int k = 0; k < max; ++k) {
            String str1 = k > len1 - 1 ? "0" : s1[k];
            String str2 = k > len2 - 1 ? "0" : s2[k];

            Integer i1;
            try {
                i1 = Integer.parseInt(str1);
            } catch (Exception var14) {
                i1 = 0;
            }

            Integer i2;
            try {
                i2 = Integer.parseInt(str2);
            } catch (Exception var13) {
                i2 = 0;
            }

            int t = i1.compareTo(i2);
            if (t != 0) {
                return t;
            }
        }

        return 0;
    }

    /**
     * v1 比 v2 更大
     * @param v1
     * @param v2
     * @return
     */
    public static Boolean gt(String v1,String v2){
        return compareTo(v1, v2) > 0;
    }

    /**
     * v1 比 v2 更大或相等
     * @param v1
     * @param v2
     * @return
     */
    public static Boolean gte(String v1,String v2){
        return compareTo(v1, v2) >= 0;
    }

}
