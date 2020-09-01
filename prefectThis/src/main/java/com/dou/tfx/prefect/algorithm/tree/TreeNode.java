package com.dou.tfx.prefect.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/27 15:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
      Integer val;
      TreeNode left;
      TreeNode right;
      String valString;
}
