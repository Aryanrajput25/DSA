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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null){
            return ans;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> currentList=new ArrayList<>();
            int levelsize=queue.size();
            for(int i=0;i<levelsize;i++){
                TreeNode currentNode=queue.poll();
                currentList.add(currentNode.val);
                if(currentNode.left!=null) queue.offer(currentNode.left);
                if(currentNode.right!=null) queue.offer(currentNode.right);
            }
            ans.add(currentList);
        }
        return ans;
    }
}