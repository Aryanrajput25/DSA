class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[nums.length];
        int n=nums.length;
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i%n]>=stack.peek()) stack.pop();
            if(i<n){
                if(stack.isEmpty()) ans[i]=-1;
                else ans[i]=stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return ans;
    }
}