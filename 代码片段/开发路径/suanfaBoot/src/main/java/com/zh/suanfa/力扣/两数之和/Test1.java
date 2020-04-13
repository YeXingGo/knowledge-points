package com.zh.suanfa.力扣.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/19  9:15
 * @版本：  1.0  41 ms
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
public class Test1 {
    /**
     * @param nums  41 ms
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int [] array = new int [2];
        for (int i = 0;i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

    /* @Author Light
     * @Description //TODO 3ms
     * @Date 9:32 2019/12/19
     * @Param [nums, target]
     * @return int[]
     **/
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int array[] = {1,2,4,5};
        System.out.println(Arrays.toString(twoSum2(array,3)));
    }
}
