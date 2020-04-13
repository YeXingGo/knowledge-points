package com.zh.suanfa.力扣.寻找两个有序数组的中位数_4;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/25  9:38
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4,6} ;
        int[] nums5 = {3,5,7,8};
        System.out.println(findMedianSortedArraysLi(nums1,nums5));
    }
        // 自己写的  做法是  先求一个 数组的中位数， 再去融合，去求，有错误
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums5 = null;
        int []  nums4 = null;
        if (nums1.length < nums2.length) {
            nums4 = nums1;
            nums5 = nums2;
        }
        else {
            nums4 = nums2;
            nums5 = nums1;
        }
        double result = 0;

        int  beign = 0;
        int end = 0;
        if (nums4 == null || nums4.length == 0) {
            int index = nums5.length / 2;
            if (nums5.length %2 == 0) {
                result = (double) (nums5[index - 1] + nums5[index]) / 2;
            }
            else {
                result = nums5[index];
            }
            return result;
        }
        if (nums5 == null || nums5.length == 0) {
            int index = nums4.length / 2;
            if (nums4.length %2 == 0) {
                result = (double) (nums4[index - 1] + nums4[index]) / 2;
            }
            else {
                result = nums4[index];
            }
            return result;
        }


        // 偶数
        if (nums4.length % 2 == 0) {
            // 算出 nums4 的  中位数
            beign = nums4 [(nums4.length / 2) - 1];
            end = nums4 [nums4.length / 2];

        }
        // 奇数
        else {
            beign = nums4 [(nums4.length / 2)];
        }
        boolean beginflag = false;
        boolean endflag = false;

        int length = 2;
        if (end == 0) {
            length = 1;
            endflag = true;
        }

       int [] nums3 = new int[nums5.length + length];
       int j = 0;
        for  (int i = 0; i < nums3.length ; i ++) {

            // 处理 begin
            if((j >= nums5.length && !beginflag  )   ) {
                nums3 [i] = beign;
                beginflag = true;
                continue;
            }
            else if (j < nums5.length && !beginflag && nums5[j] >= beign) {
                nums3 [i] = beign;
                beginflag = true;
                continue;
            }
            // 处理 end
            if((j >= nums5.length &&!endflag) ) {
                nums3 [i] = end;
                endflag = true;
                continue;
            }
             else if ( j < nums5.length &&  nums5[j] >= beign && !endflag && nums5[j] >= end)  {
                nums3 [i] = end;
                endflag = true;
                continue;
            }

            if ( j < nums5.length && nums5[j] <= beign || (j < nums5.length && nums5[j] >= beign) || (j < nums5.length && !endflag && end <= nums5[j])) {
                nums3 [i] = nums5[j];
                j++;
            }
        }
        int index = nums3.length / 2;
        if (nums3.length %2 == 0) {
            result = (double) (nums3[index - 1] + nums3[index]) / 2;
        }
        else {
            result = nums3[index];
        }
        return result;
    }

    public static double findMedianSortedArraysLi(int[] A, int [] B) {
        // A总是 长度较小   B 总是长度 较长
        //  n  >=  m
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        // haldLen 是 使用了向上取整 （4+3 +1） / 2 = 4
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            //  i < iMax 判断 A的下标是否不会越界
            if ( i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            //  i > iMix 判断 A的下标是否不会越界
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            // B[j -1 ] <= A [i]  &&  A[i - 1] <= B [j]
             else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;


    }
}
