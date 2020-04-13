package com.zh.suanfa.力扣.无重复的最长子串3;

import java.util.HashMap;
import java.util.Map;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/23  9:15
 * @版本：1.0
 *          lengthOfLongestSubstring     690 ms  42.4 MB
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringMap("abba"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null ) {
            return 0;
        }
        String[] split = s.split("");
        String [] newString = new String [split.length];
        int num = 0;
        int begin = 0;
        int dNum = 0;
        for (int i = 0; i < split.length ; i ++) {
            if (split[i].equals("")) {
                continue;
            }
            for (int j = begin ; j < i;j ++) {
                if (newString[j] != null && newString[j].equals(split[i])) {
                    if (num < dNum) {
                        num = dNum;
                    }
                    begin = j + 1;
                    newString = new String[split.length];
                    i = begin;
                    dNum =0;
                    break;
                }

            }
            newString[i] = split[i];
            dNum ++;
        }
        if (num < dNum) {
            num = dNum;
        }
        return  num;
    }


    /* @Author Light
     * @Description //TODO  9ms  36.1 MB
     * @Date 10:08 2019/12/23
     * @Param [s]
     * @return int
     **/
    public  static int lengthOfLongestSubstringMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                // 防止 start 往回走  如 abba  此时 到最后一个  a  就是 1 ，但是此时的 start 应是 2
                start = Math.max(map.get(alpha), start);
            }
            // 如果有比原来大的就赋值
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
