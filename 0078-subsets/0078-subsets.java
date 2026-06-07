class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        func(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void func(int idx,int[] nums,List<Integer> ds,List<List<Integer>> ans){
        ans.add(new ArrayList<Integer> (ds));
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            func(i+1,nums,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}