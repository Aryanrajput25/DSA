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
    List<String> allpaths=new ArrayList<>();
    List<String> currpath=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root);
        return allpaths;
    }
    TreeNode helper(TreeNode node){
        if(node==null){
            return null;
        }
        currpath.add(String.valueOf(node.val));
        if(node.left==null && node.right==null){
            allpaths.add(String.join("->",currpath));
        }
        else{
            helper(node.left);
            helper(node.right);
        }
        currpath.remove(currpath.size()-1);
        return node;
    }
}