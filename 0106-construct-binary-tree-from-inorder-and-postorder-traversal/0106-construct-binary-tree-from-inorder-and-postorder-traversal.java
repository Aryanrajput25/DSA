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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l=postorder.length;
        if(l==0){
            return null;
        }
        int r=postorder[l-1];
        int index=0;
        for(int i=0;i<l;i++){
            if(inorder[i]==r){
                index=i;
            }
        }
        TreeNode node=new TreeNode(r);
        node.left=buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        node.right=buildTree(Arrays.copyOfRange(inorder,index+1,l),Arrays.copyOfRange(postorder,index,l-1));
        return node;
    }
}