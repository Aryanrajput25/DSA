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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(root);
        Boolean reverse=false;
        while(!queue.isEmpty()){
            List<Integer> currlev=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                if(!reverse){
                    TreeNode curr=queue.pollFirst();
                    currlev.add(curr.val);
                    if(curr.left!=null){
                        queue.offerLast(curr.left);
                    }
                    if(curr.right!=null){
                        queue.offerLast(curr.right);
                    }
                }
                if(reverse){
                    TreeNode curr=queue.pollLast();
                    currlev.add(curr.val);
                    if(curr.right!=null){
                        queue.offerFirst(curr.right);
                    }
                    if(curr.left!=null){
                        queue.offerFirst(curr.left);
                    }
                }
            }
            ans.add(currlev);
            reverse=!reverse;
        }
        return ans;
    }
}