package com.dou.tfx.prefect.algorithm.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/28 14:21
 */
public class TestSolution {
    public static void main(String[] args) {

        TreeNode treeNodeG = new TreeNode(1, null, null, "G");
        TreeNode treeNodeH = new TreeNode(2, null, null, "H");
        TreeNode treeNodeE = new TreeNode(3, treeNodeG, treeNodeH, "E");
        TreeNode treeNodeD = new TreeNode(4, null, null, "D");
        TreeNode treeNodeB = new TreeNode(5, treeNodeD, treeNodeE, "B");
        TreeNode treeNodeF = new TreeNode(6, null, null, "F");
        TreeNode treeNodeC = new TreeNode(7, null, treeNodeF, "C");
        TreeNode treeNodeA = new TreeNode(8, treeNodeB, treeNodeC, "A");

        Solution solution = new Solution();
        List<String> integers = solution.inorderTraversal(treeNodeA);
        //integers.forEach(System.out::println);
        solution.preOrderWithStack(treeNodeA);

        //2022-04-18
        TreeNode treeNode6 = new TreeNode(6,null,null,"6");
        TreeNode treeNode5 = new TreeNode(5,null,null,"5");
        TreeNode treeNode4 = new TreeNode(4,null,null,"4");
        TreeNode treeNode3 = new TreeNode(3,null,treeNode6,"3");
        TreeNode treeNode2 = new TreeNode(2,treeNode4,treeNode5,"2");
        TreeNode treeNode1 = new TreeNode(1,treeNode2,treeNode3,"1");

        //前序
        TestSolution testSolution = new TestSolution();
        testSolution.aaa(treeNode1);
        //中序
        testSolution.bbb(treeNode1);
        //后序
        testSolution.ccc(treeNode1);
        //层序 队列
        testSolution.ddd(treeNode1);



    }

    public void aaa(TreeNode treeNode){
        //根
        if(treeNode!=null){
            System.out.println(treeNode);
            if(treeNode.left!=null){
                aaa(treeNode.left);
            }
            if(treeNode.right!=null){
                aaa(treeNode.right);
            }
        }

    }
    public void bbb(TreeNode treeNode){
        if(treeNode.left!=null){
            bbb(treeNode.left);
        }
        System.out.println(treeNode.val);
        if(treeNode.right!=null){
            bbb(treeNode.right);
        }
    }
    public void ccc(TreeNode treeNode){
        if(treeNode.left!=null){
            ccc(treeNode.left);
        }
        if(treeNode.right!=null){
            ccc(treeNode.right);
        }
        System.out.println(treeNode.val);
    }

    public void ddd(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            TreeNode treeNode1 = queue.poll();
            System.out.println(treeNode1.valString);
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }

        }

    }
}
