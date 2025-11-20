class Solution {
    public int[] sumZero(int n) {
        int[] ans= new int[n];
        if (n%2==0){
            int idx=0;
            for(int i=1;i<=n/2;i++){
                ans[idx++]=i;
                ans[idx++]=-i;
            }
        }

        else{
            int idx=1;
            ans[0]=0;
            for(int i=1;i<=n/2;i++){
                
                ans[idx++]=i;
                ans[idx++]=-i;
            }
        }

        return ans;
    }
}