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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx=findnode(root,x);
        TreeNode yy=findnode(root,y);

        return((!issibling(root,xx,yy))&&(level(root,xx,0)==level(root,yy,0)));
    }
    TreeNode findnode(TreeNode node,int x){
        if(node==null){
            return null;
        }
        if(node.val==x){
            return node;
        }
        TreeNode n=findnode(node.left,x);
        if(n!=null){
            return n;
        }
        return findnode(node.right,x);
    }
    Boolean issibling(TreeNode node,TreeNode xx,TreeNode yy){
        if(node==null){
            return false;
        }
        return((node.left==xx && node.right==yy)||(node.left==yy && node.right==xx)||issibling(node.left,xx,yy)||issibling(node.right,xx,yy));
    }
    int level(TreeNode node,TreeNode x,int height){
        if(node==null){
            return 0;
        }
        if(node==x){
            return height;
        }
        int l=level(node.left,x,height+1);
        if(l!=0){
            return l;
        }
        return level(node.right,x,height+1);
    }
}