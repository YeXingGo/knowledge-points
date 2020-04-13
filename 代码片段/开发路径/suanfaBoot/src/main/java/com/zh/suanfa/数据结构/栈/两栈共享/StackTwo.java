package com.zh.suanfa.数据结构.栈.两栈共享;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2020/3/27  22:37
 * @版本：
 */
public class StackTwo {
    int [] array = new int[5];
    int top1 = -1; // 栈 1 栈顶指针
    int top2 = array.length; // 栈 2 栈顶指针

    /* @Author Light
     * @Description //TODO 压栈操作
     * @Date 22:42 2020/3/27
     * @Param [a, stackNumber 判断是哪个栈]
     * @return void
     **/
    void push (int a, int stackNumber) {
        // 说明 栈已满
        if (top1 + 1 == top2) {
            System.out.println("栈已满");
            return;
        }
        if (stackNumber  == 1) {
            top1 ++;
            array[top1] = a;
        }
        else {
            top2 --;
            array[top2] = a;
        }
    }
    /* @Author Light
     * @Description //TODO  出栈操作
     * @Date 22:49 2020/3/27
     * @Param [a, stackNumber]
     * @return void
     **/
    int pop ( int stackNumber) {
        if (stackNumber  == 1) {
            if (top1  == -1 ) {
                System.out.println("没有值了");
                return 0;
            }
            else {
                return array[top1 --];
            }
        }
        else {
            if (top2  == array.length) {
                System.out.println("没有值了");
                return 0;
            }
            return array[top2 ++];
        }
    }
    public int[] getArray () {
        return array;
    }

    public void soutArray () {
        for (int a : this.getArray()) {
            System.out.print(a + " ");
        }
    }
    public static void main(String[] args) {

        StackTwo stackTwo = new StackTwo();
        stackTwo.push(1,1);
        stackTwo.push(1,1);
        stackTwo.push(1,1);
        stackTwo.push(1,1);
        stackTwo.push(5,2);
        stackTwo.soutArray();
        System.out.println(stackTwo.pop(2));
        stackTwo.soutArray();