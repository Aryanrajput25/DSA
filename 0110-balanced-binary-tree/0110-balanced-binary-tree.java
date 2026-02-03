/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;
        
    }
    Integer height(TreeNode node){
        if(node==null){
            return 0;
        }
        Integer leftheight=height(node.left);
        Integer rightheight=height(node.right);
        if(leftheight==-1 || rightheight==-1 || Math.abs(leftheight-rightheight)>1){
            return -1;
        }
        return Math.max(leftheight,rightheight)+1;
    } 
}