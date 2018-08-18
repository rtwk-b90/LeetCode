package com.dfs;


/*https://leetcode.com/problems/symmetric-tree/description/
*/	
	
public class SymmetricTree {
	

    public boolean isSymmetric(TreeNode root) {
        
        if(root==null)
            return true;
        
        return isSym(root.left,root.right);
        
    }
    boolean isSym(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        
        if(left==null || right==null)
            return false;
        
        return left.val==right.val && isSym(left.left,right.right) && isSym(left.right,right.left);
    }

}
