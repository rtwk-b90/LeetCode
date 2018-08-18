package com.dfs;

/*https://leetcode.com/problems/balanced-binary-tree/description/
*/

public class BalancedTree {


    public boolean isBalanced(TreeNode root) {
        
        return getHeight(root)==-1?false:true;
    }
    
    int getHeight(TreeNode root){
        
        if(root==null)
            return 0;
        
        int h1=getHeight(root.left);
         int h2=getHeight(root.right);
        
        if(Math.abs(h1-h2)>1)
            return -1;
        
        if(h1==-1 || h2==-1)
            return -1;
        
        return 1+Math.max(h1,h2);
    }
}
