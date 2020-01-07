package com.zh.light.collectiondemo.list.likeedList;

import org.springframework.core.annotation.Order;

import java.util.*;

/**
 * @描述： TODO  hasNext 方法实现在 AbstractSequentialList
 * @作者: Light
 * @时间: 2019/10/23  9:17
 * @版本：
 */
public class LinkedListLight<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    // 链表的长度
    transient int size = 0;
    /**
     * 用于初始化Node的最后一个值
     * transient 标识此值不被序列化
     */
    transient Node<E> last;

    /**
     * 用于初始化Node的第一个值
     * transient 标识此值不被序列化
     */
    transient Node<E> first;

    // 无参构造
    public LinkedListLight() {

    }
    /* @Author Light
     * @Description //TODO  向linkedList 的链表最后边追加e
     * @Date 13:07 2019/10/23
     * @Param [e]
     * @return boolean
     **/
    @Override
    public boolean add (E e) {
        // 向后添加
        linkLast(e);
        return true;
    }
    @Override
    public void add(int index , E element) {
        checkPositionIndex (index);
        // 0 个元素  和  size 的元素
        if (index == size) {
            linkLast(element);
        }
        else {
            // TODO 加入中间
        }
    }

    private void checkPositionIndex(int index) {
        if (! isPositionIndex(index)) {
            throw  new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override
    public void addLast(E e) {
        linkLast(e);
    }

    /* @Author Light
     * @Description //TODO
     * @Date 9:39 2019/10/28
     * @Param [index, element]
     * @return E
     **/
    public E set(int index, E element) {
        //只有在下标范围内才可以
        checkElementIndex(index);
        //获取指定的下标的值
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    /* @Author Light
     * @Description //TODO 链表中添加frist
     * @Date 9:06 2019/10/28
     * @Param [e]
     * @return void
     **/
    private void linkFirst(E e) {
        //获取第一个元素
        final  Node<E> f = first;
        //创建元素，并建立关系
        final Node<E> newNode = new Node<>(null,e,f);
        first = newNode;
       //说明链表中只有一个元素
        if (f == null)
            last =  newNode;
        //说明链表中还有其他元素
        else
            //把之前的第一个元素指向当前对象
            f.prev = newNode;
        size ++ ;
        modCount++;
    }


    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {

        return 0;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    /* @Author Light
     * @Description //TODO  把值添加到最后
     * @Date 9:41 2019/10/23
     * @Param []
     * @return void
     **/
    void linkLast(E e) {

        // 拿到列表之后的 对象
        final Node<E> l = this.last;
        // 3 -2
        final  Node<E> newNode = new Node<>(l,e,null);
        // 最后一对象
        last = newNode;
        //说明是首次添加的
        if (l == null) {
            first = newNode;
        }
        // 说明不是首次，把当前值的   2-3
        else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /* @Author Light
     * @Description //TODO  获取指定下标的值
     * @Date 9:27 2019/10/24
     * @Param [index]
     * @return E
     **/
    @Override
    public E get (int index) {

        checkElementIndex (index);
        return node(index).item;
    }
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public  int indexOf (Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first;x != null;x = x.next) {
                if (x.item == null) {
                    return  index;
                }
                index++;
            }
        }
        else {
            for (Node<E> x = first; x != null;x = x.next) {
                if (x.item == o) {
                    return index;
                }
                index ++;
            }
        }
        return -1;
    }

    /* @Author Light
     * @Description //TODO 下标异常提示信息
     * @Date 9:26 2019/10/24
     * @Param [index]
     * @return java.lang.String
     **/
    private String outOfBoundsMsg (int index) {
        return "Index: "+ index + ", Size: "+size;
    }

    /* @Author Light
     * @Description //TODO 下标检验 ,
     * @Date 9:20 2019/10/24
     * @Param [index] 当前下标
     * @return void
     **/
    private void checkElementIndex(int index) {
        // 如果下标不符合标准，则抛出异常
        if (! isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }


    /* @Author Light
     * @Description //TODO 判断当前下标是否是正常的
     * @Date 9:23 2019/10/24
     * @Param [index]
     * @return boolean
     **/
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    /* @Author Light
     * @Description //TODO 获取指定下标的值
     * @Date 9:31 2019/10/24
     * @Param [index]
     * @return com.zh.light.collectiondemo.list.likeedList.LinkedListLight.Node<E>
     **/
    private Node<E> node (int index) {
        Node<E> node = null;
        // 判断下标是 前半部分 还是后半部分
        // 说明是前部分
        if(index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
        }
        // 说明是后半部分
        else {
            // 相当于 size -1
            node = last;
            // 从
            for (int i = size - 1; i >  index; i--)
                node = node.prev;
        }
        return node;
    }

    /* @Author Light
     * @Description //TODO  LinkedList的内部类
     * @Date 9:24 2019/10/23
     * @Param
     * @return
     **/
    private static class Node<E> {
        E item; // 当前值
        Node<E> next; // 下一个Node对象
        Node<E> prev; // 上一个Node对象

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    /* @Author Light
     * @Description //TODO 猜测是模板方法, 用于  ForEach
     * @Date 13:10 2019/10/30  只会调用一次
     * @Param [index]
     * @return java.util.ListIterator<E>
     **/
    @Override
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    private class ListItr implements  ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount =  modCount;

        ListItr(int index) {
            next = (index == size) ? null: node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size ;
        }

        @Override
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw  new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex ++;

            return lastReturned.item;
        }
        // 并行修改 抛出错误
        private void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }

    }
}
