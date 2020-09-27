package com.dou.tfx.prefect.algorithm;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/9/7 10:51
 */
public class StackQueue {
    //用栈来实现队列
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();
        Stack<Integer> integerStack = new Stack<>();
        Stack<Integer> integerStack1 = new Stack<>();
        integerQueue.offer(1);
        integerQueue.offer(2);
        integerQueue.offer(3);
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        while (!integerQueue.isEmpty()){
            System.out.println(integerQueue.poll());
        }
        while (!integerStack.isEmpty()){
            integerStack1.push(integerStack.pop());
        }
        while (!integerStack1.isEmpty()){
            System.out.println(integerStack1.pop());
        }
    }

    public void aaa(){
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("111",1);
    }
}
