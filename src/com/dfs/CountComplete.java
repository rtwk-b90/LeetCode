package com.dfs;


/*https://leetcode.com/problems/count-complete-tree-nodes/description/
*/	
public class CountComplete {
	
	public int countNodes(TreeNode root) {
		  
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
