package com.zh.suanfa.力扣.两数相加2;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/19  17:35
 * @版本：  1.0   2ms
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Test_1 {

    //
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode NewNode = null;
        ListNode TopNode = null;  // 第一个
        int i = 1;
        int b = 0;
        do {
            ListNode listNode = new ListNode(0);
            i = i * 10;
            int l1vale = 0;
            int l2vale = 0;
            if (l1 != null) {
                l1vale = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2vale = l2.val;
                l2 = l2.next;
            }
            int sum = l1vale + l2vale + b;
            b = sum / 10;
            listNode.val = sum % 10;

            if (TopNode == null) {
                NewNode = listNode;
                TopNode = listNode;
            }
            else {
                if (NewNode != null) {
                    NewNode.next = listNode;
                    NewNode = NewNode.next;
                }
            }



        } while ((b > 0)||(l1 != null) || l2 != null);
        return TopNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode1_1 = new ListNode(4);
        ListNode listNode1_1_1 = new ListNode(3);
        ListNode listNode1_1_1_1 = new ListNode(3);
       /* listNode1.next = listNode1_1;
        listNode1_1.next = listNode1_1_1;
        listNode1_1_1.next = listNode1_1_1_1;*/

        ListNode listNode2 = new ListNode(5);
        ListNode listNode2_2 = new ListNode(5);
        ListNode listNode2_2_2 = new ListNode(4);
        ListNode listNode2_2_2_2 = new ListNode(4);
        /*listNode2.next = listNode2_2;
        listNode2_2.next = listNode2_2_2;
        listNode2_2_2.next = listNode2_2_2_2;*/

        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        while (listNode != null);

    }
}
