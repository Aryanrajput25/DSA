class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        func(0,ans,new ArrayList<>(),nums);
        return ans;
    }
    void func(int idx,List<List<Integer>> ans,List<Integer> ds,int[] nums){
        ans.add(new ArrayList<>(ds));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            func(i+1,ans,ds,nums);
            ds.remove(ds.size()-1);
        }
    }
}