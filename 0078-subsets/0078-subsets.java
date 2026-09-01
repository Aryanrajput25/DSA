class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int subsets=1<<nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<subsets;i++){
            List<Integer> thisans=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0) thisans.add(nums[j]);
            }
            ans.add(thisans);
        }
        return ans;
    }
}