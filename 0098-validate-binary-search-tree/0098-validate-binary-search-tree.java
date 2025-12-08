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
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    boolean helper(TreeNode node,Integer high,Integer low){
        if(node==null){
            return true;
        }
        if(low!=null && node.val<=low){
            return false;
        }
        if(high!=null && node.val>=high){
            return false;
        }
        boolean l=helper(node.left,node.val,low);
        boolean r=helper(node.right,high,node.val);
        return l&&r;
    }
    
}