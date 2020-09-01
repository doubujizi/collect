package com.dou.tfx.prefect.leet.one;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/31 10:12
 */
public class SolutionOne {
    int i = 0;
    int j = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        Integer m = forListNode(l1, 0);
        Integer n = forListNode(l2, 0);
        Integer z = m + n;
        return null;
    }

    public Integer forListNode(ListNode l1, Integer num) {
        double pow = Math.pow(10, i);
        int aaa = new Double(pow).intValue();
        Integer result = l1.val * aaa + num;
        i++;
        if (l1.next == null) {
            i = 0;
            return result;
        }
        return forListNode(l1.next, result);
    }

    public ListNode setNode(Integer integer) {
        if (integer != 0) {
            int length = integer.toString().length();
            double pow = Math.pow(10, length - 1);
            int aaa = new Double(pow).intValue();
            int bbb = integer % aaa;
            ListNode listNode = new ListNode(bbb, null);
        }
        return null;
    }
}
