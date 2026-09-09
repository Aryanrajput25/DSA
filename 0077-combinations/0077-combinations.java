class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        func(n,k,ans,new ArrayList<>(),1);
        return ans;
    }
    public void func(int n, int k,List<List<Integer>> ans, List<Integer> ds,int start){
        if(ds.size()==k) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=start;i<=n;i++){
            ds.add(i);
            func(n,k,ans,ds,i+1);
            ds.remove(ds.size()-1);
        }
    }
}