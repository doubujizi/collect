package com.dou.tfx.prefect.leet.one;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/31 10:35
 */
public class TestSolutionOne {
    public static void main(String[] args) {
        SolutionOne solutionOne = new SolutionOne();
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode listNodeL1 = new ListNode(2, listNode4);

        ListNode listNode42 = new ListNode(4);
        ListNode listNode6 = new ListNode(6, listNode42);
        ListNode listNodeL2 = new ListNode(5, listNode6);

        //solutionOne.addTwoNumbers(listNodeL1, listNodeL2);
        Integer integer = solutionOne.forListNode(listNodeL1, 0);
        System.out.println(integer);
    }
}
