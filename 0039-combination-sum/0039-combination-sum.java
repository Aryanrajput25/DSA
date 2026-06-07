class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        func(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void func(int idx,int[] nums, int target,List<List<Integer>> ans,List<Integer> ds ){
        if(idx==nums.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[idx]<=target){
            ds.add(nums[idx]);
            func(idx,nums,target-nums[idx],ans,ds);
            ds.remove(ds.size()-1);
        }
        func(idx+1,nums,target,ans,ds);
    }
}