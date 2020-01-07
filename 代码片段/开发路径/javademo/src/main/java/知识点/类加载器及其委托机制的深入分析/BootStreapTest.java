package 知识点.类加载器及其委托机制的深入分析;

/**
 * @描述： TODO 寻求规则
 * @作者: Light
 * @时间: 2019/12/2  18:32
 * @版本：
 */
public class BootStreapTest {
    public static void main(String[] args) {
        System.out.println(System.class.getClassLoader());
        ClassLoader classLoader = BootStreapTest.class.getClassLoader();
        while (classLoader != null) {

            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);
    }
}
