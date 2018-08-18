package com.dfs;

import java.util.ArrayList;

/*https://leetcode.com/problems/leaf-similar-trees/description/
*/	
public class LeafSimilarTree {
    
    ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        
        dfs(root1,arr1);
        dfs(root2,arr2);
        
        if(arr1.size()!=arr2.size())
            return false;
        
        for(int i=0;i<arr1.size();i++){
            
            if(arr1.get(i)!=arr2.get(i)){
                return false;
            }
        }
        return true;
        
    }
    
    void dfs(TreeNode root,ArrayList<Integer> arr){
        
        if (root==null)
            return;
        if(root.left==null&&root.right==null){
            arr.add(root.val);
        }
        
        dfs(root.left,arr);
        dfs(root.right,arr);
            
        
    }
}
