package com.zh.light.collectiondemo.list;

import com.zh.light.collectiondemo.list.test.A;
import com.zh.light.collectiondemo.list.ArraysLight;
import com.zh.light.collectiondemo.list.test.B;
import com.zh.light.collectiondemo.list.test.C;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

/**
 * @描述： TODO  ArrayList 的模仿者
 * @作者: Light
 * @时间: 2019/9/30  9:19
 * @版本：
 */
public class ArrayListLight<E> extends AbstractListLight<E> implements  ListLight<E>,java.io.Serializable{
    //transient变量不会贯穿对象的序列化和反序列化，生命周期仅存于调用者的内存中而不会写到磁盘里持久化。
    //transient 不可被序列化  ，  static 可以被串行化

    transient Object[] elementData; //储存数据

    //用于 初始化 无参构造  默认容量 空元素数据
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {} ;

    /**
     * Shared empty array instance used for empty instances.
     * 用于空实例的共享空数组实例。
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //数组长度
    private Integer size = 0;

    //初始化容量大小
    private static final int DEFAULT_CAPACITY = 10;

    // 最大长度
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    //无参构造方法
    public ArrayListLight () {
        this.elementData =   DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // 带有初始长度的构造
    public ArrayListLight (int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        }
        else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
        else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
    /* @Author Light
     * @Description //TODO
     * @Date 23:54 2019/10/9
     * @Param
     * @return
     **/
    public ArrayListLight (Collection<? extends  E> collection) {
        elementData = collection.toArray();
        if ((size = elementData.length) != 0) {
            if (elementData.getClass() !=  Object[].class) {
                elementData = Arrays.copyOf(elementData,size);
            }
        }
        else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }


    /* @Author Light
     * @Description //TODO list中添加的方法 add
     * @Date 20:58 2019/10/7
     * @Param
     * @return
     **/
    public boolean add (E e) {
        ensureCapacityInternal(size + 1);
        elementData[size ++] = e;
        return true;
    }

    /* @Author Light
     * @Description //TODO 向指定下标插入
     * @Date 9:48 2019/10/10
     * @Param [index 下标, e  值]
     * @return boolean
     **/
    public void add (int index, E e) {
        rangeCheckForAdd(index);
        // 实现自动扩容  计算 容量是否充足，如果不充足就开始扩容
        ensureCapacityInternal(size +  1);
        // 数组移动
        ArraysLight.arrayCopy(elementData,index,elementData,index + 1 ,size - index);
        System.out.println(Arrays.toString(elementData));
        elementData [index] = e;
        size ++ ;
    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    /* @Author Light
     * @Description //TODO  确保内部容量
     * @Date 21:00 2019/10/7
     * @Param
     * @return
     **/
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData,minCapacity));
    }
    /* @Author Light
     * @Description //TODO 计算容量
     * @Date 21:04 2019/10/7
     * @Param
     * @return
     **/
    private static int calculateCapacity(Object[] elementData,int minCapacity) {
        //如果当前的对象 是 默认创建的
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // 比较 默认值 和当前的下标  初始默认值
            return Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        return minCapacity;
    }
    /* @Author Light
     * @Description //TODO 保证扩展能力
     * @Date 21:03 2019/10/7
     * @Param
     * @return
     **/
    private  void ensureExplicitCapacity (int minCapacity) {
        modCount++;

        // 如果当前的长度 大于 数组的长度
        if (minCapacity - elementData.length > 0) {
            grow (minCapacity);
        }
    }
    /* @Author Light
     * @Description //TODO 扩展数组
     * @Date 21:52 2019/10/7
     * @Param
     * @return
     **/
    private void grow(int minCapacity) {
        //获取之前数组的长度
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果新的长度 小于 现在的下标
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw  new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }


    public E get (int index) {
        return (E) elementData [index];
    }


    // ArrayList 遍历 会先执行他
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
    /* @Author Light
     * @Description //TODO  ArrayList 的迭代器对象
     * @Date 23:09 2019/10/7
     * @Param
     * @return
     **/
    private class Itr implements  Iterator<E> {
        int cursor ; //要返回的下一个元素的索引
        int lastRet = -1; //返回的最后一个元素的索引；如果没有 -1
        int expectedModCount = modCount;

        Itr () { }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayListLight.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }



    @Override
    public void forEach(Consumer<? super E> action) {
      /*  //判断 对象是否为空
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        @SuppressWarnings("unchecked")
        final E [] elementData = (E[]) this.elementData;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size ; i++) {
            action.accept(elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw  new ConcurrentModificationException();
        }*/
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
    // 使用 forEach 会先调用 iterator 方法 ,
    /*
     使用 forEach 必须有 iterator 方法 和 iterator 对象
     调用forEach 会先初始化一个 迭代器 （iterator）
        1. 先调用 迭代器的 hasNext 方法
        2. 调用next 方法
    */
    public static void main(String[] args) {
        /*ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.toString());
        integers.add(1);
        System.out.println(integers.toString());
        integers.add(0,2);
        integers.add(0,3);
        System.out.println(integers.toString());*/

        List<String> strings = Arrays.asList(1 + "", 2 + "");

        Object []  a =  {1};
        Object[] clone = a.clone();
        System.out.println(Arrays.toString(clone));
        System.out.println(Arrays.toString(a));
        System.out.println( a == clone);





       /*
        System.out.println(Arrays.toString(elementData));
        //               修改的数组  迁移下标 修改的数组         从哪开始          循环次数
        System.arraycopy(elementData,index, elementData,index + 1,size - index);
        System.out.println(Arrays.toString(elementData));*/
       /* System.out.println(Arrays.toString(elementData));
        ArraysLight.arrayCopyPlus(elementData,index, elementData,index + 1,size - index);
        System.out.println(Arrays.toString(elementData));*/

    }
    public static void testAddArrayListLight() {
        ArrayListLight<Integer> integers = new ArrayListLight<>();
        integers.add(1);
        integers.add(0,2);
        for (Integer i: integers) {
            System.out.print(i +" ");
        }


        Object[] elementData = {2,0,1,1,0,0};
        int index = 1;
        int size = 4;
    }
    /* @Author Light
     * @Description //TODO  测试带有构造和 泛型的使用 的方法
     * @Date 8:52 2019/10/10
     * @Param []
     * @return void
     **/
    public static void testTArrayListLight () {
        ArrayList<A> as1 = new ArrayList<>();
        as1.add(new A());
        ArrayListLight<A> as = new ArrayListLight<A>(as1);
        System.out.println(as.size);
        for (A a : as) {
            System.out.println(a);
        }
    }

    /* @Author Light
     * @Description //TODO  测试 迭代器的使用
     * @Date 23:06 2019/10/9
     * @Param
     * @return
     **/
    public static void testIterator () {
        ArrayListLight<Integer> integerArrayListLight = new ArrayListLight<Integer>();
        for (int i = 0; i < 11; i++) {
            integerArrayListLight.add(i+1);
        }
        for (Integer i : integerArrayListLight) {
            System.out.print(i + " ");
        }
        System.out.println();
        int index = 0;
        System.out.println(integerArrayListLight.get(index ));
        System.out.println(integerArrayListLight.get(index = 1));
        System.out.println(integerArrayListLight.toString());
    }
}
