package 知识点.泛型.泛型集合插入多种类型数据.arrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述： TODO  使用 反射 爆破 泛型
 * @作者: Light
 * @时间: 2019/12/2  17:44
 * @版本：
 */
public class ArrayListTest {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 通过发射调用list的add方法
        Object invoke = list.getClass().getMethod("add", Object.class).invoke(list, "abc");
        for (int i = 0; i < list.size() ; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
