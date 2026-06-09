class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        func(0,nums,ans);
        return ans;
    }
    public void func(int idx,int[] nums,List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,idx,i);
            func(idx+1,nums,ans);
            swap(nums,idx,i);
        }
    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}