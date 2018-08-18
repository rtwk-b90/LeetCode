package com.dfs;

/*https://leetcode.com/problems/path-sum/description/
*/


public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return rootToLeafSum(root,sum);
    }
    
    
    boolean rootToLeafSum(TreeNode root, int sum){
        
        if(root== null){
            return false;
        }
        if(root.left==null && root.right==null){
            
            if(root.val==sum){
                
                return true;
                
                
            }else return false;
        }
        
        if(rootToLeafSum(root.left,sum-root.val)){
            return true;
        }
        if(rootToLeafSum(root.right,sum-root.val)){
            return true;
        }
        return false;
    }
}
