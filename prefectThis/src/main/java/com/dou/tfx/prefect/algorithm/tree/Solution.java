package com.dou.tfx.prefect.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/27 15:57
 */
public class Solution {
    public List<String> inorderTraversal(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper2(root, res);
        return res;
    }

    //中序
    public void helper(TreeNode root, List<String> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.valString);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    //前序
    public void helper1(TreeNode root, List<String> res) {
        if (root != null) {
            res.add(root.valString);
            if (root.left != null) {
                helper1(root.left, res);
            }
            if (root.right != null) {
                helper1(root.right, res);
            }
        }
    }

    //后序
    public void helper2(TreeNode root, List<String> res) {
        if (root != null) {
            if (root.left != null) {
                helper2(root.left, res);
            }
            if (root.right != null) {
                helper2(root.right, res);
            }
            res.add(root.valString);
        }
    }

    public TreeNode buildTree(String[] preorder, String[] inorder) {
        String preS = preorder[0];
        return null;

    }


}
