package 反射;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/15  9:06
 * @版本：
 */
public class LayInnerClassSingleton {
    // 使用 LazyInnerClassGeneral 的时候，默认会初始化内部类
    //如果没使用，则内部类是不会加载的
    private  LayInnerClassSingleton () {
        System.out.println("============ "+LazyHolder.LAZY);
        if (LazyHolder.LAZY != null) {
            throw  new RuntimeException("不允许创建多个实例");
        }
    }
    // 每一个关键字都不是多余的，static 是为了使单例的空间共享，保证这个方法不会被重写，
    public static final LayInnerClassSingleton getInstance() {
        return  LazyHolder.LAZY;
    }

    // 默认不加载
    private static class LazyHolder {
        private  static final LayInnerClassSingleton LAZY = new LayInnerClassSingleton();
    }

    public static void main(String[] args) {
        System.out.println(LayInnerClassSingleton.getInstance() == LayInnerClassSingleton.getInstance());
        System.out.println(LayInnerClassSingleton.getInstance() == LayInnerClassSingleton.getInstance());
    }
}
