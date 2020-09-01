package com.dou.tfx.prefect.leet.one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/31 10:11
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
