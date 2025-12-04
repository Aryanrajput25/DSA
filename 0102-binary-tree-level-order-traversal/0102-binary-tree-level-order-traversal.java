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
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> thislevel = new ArrayList<>(size);
            for(int i=0;i<size;i++){
                TreeNode currnode=queue.poll();
                thislevel.add(currnode.val);
                if(currnode.left!=null){
                    queue.offer(currnode.left);
                }
                if(currnode.right!=null){
                    queue.offer(currnode.right);
                }
            }
            result.add(thislevel);
        }
        return result;
    }
}