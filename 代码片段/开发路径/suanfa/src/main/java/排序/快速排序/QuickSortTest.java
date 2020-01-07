package 排序.快速排序;

import java.util.Arrays;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/21  14:55
 * @版本：
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int [] array = {20,40,50,10,60};
        kuaiSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    /* @Author Light
     * @Description //TODO  基数要与 启动 端相反  从小到大
     * @Date 16:06 2019/11/21
     * @Param [array, left, right]
     * @return void
     **/
    public static void quickSort (int [] array , int left,int right) {
        int i = left;
        int j = right;
        int temp = array[left];  // 基准数
        // 出口
        if (i >= j) {
            return;
        }
        while (i != j) {
            // 右边
            while (i < j && array[j] >= temp) {
                j--;
            }
            // 说明还没有撞到
            if (j > i) {
                // 把右边的给左边
                array [i] = array [j];
            }

            while (i < j && array[i] <= temp) {
                i ++;
            }
            if (i < j) {
                array [j] = array[i];
            }
        }
        array [i] = temp;
        quickSort(array,left,i-1);
        quickSort(array,i + 1,right);
    }

    /* @Author Light
     * @Description //TODO 从大到小
     * @Date 17:19 2019/11/21
     * @Param [array, left, right]
     * @return void
     **/
    public static void kuaiSort (int[] array,int left,int right) {
        int i = left;
        int j = right ;
        int temp = array[left];
        if (i >= j) {
            return;
        }
        while (i < j) {
            while (i < j && array[j] <= temp) {
                j -- ;
            }
            if (i < j) {
                array[i] = array[j];
            }
            while (i < j && array[i] >= temp) {
                i ++ ;
            }
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[i] = temp;
        kuaiSort(array,left,i -1 );
        kuaiSort(array,i + 1,right);
    }
}
