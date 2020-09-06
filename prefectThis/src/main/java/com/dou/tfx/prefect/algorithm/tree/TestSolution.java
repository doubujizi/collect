package com.dou.tfx.prefect.algorithm.tree;

import java.util.List;

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


    }
}
