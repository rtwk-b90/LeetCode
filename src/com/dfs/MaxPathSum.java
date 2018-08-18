package com.dfs;

/*https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
*/

public class MaxPathSum {


    
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        getMaxPath(root);
        return maxSum;
        
    }
    
    int getMaxPath(TreeNode root){
         if(root==null)
            return 0;
        int left=getMaxPath(root.left);
         int right=getMaxPath(root.right);
        
        maxSum=Math.max(maxSum,left+right+root.val);
        
        return Math.max(left,right)+root.val;
        
    }
    
}
