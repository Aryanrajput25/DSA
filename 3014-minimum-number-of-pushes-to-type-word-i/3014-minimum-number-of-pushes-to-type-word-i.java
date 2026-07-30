class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int ans=0;
        for(int i=1;i<=4;i++){
            int num=Math.min(8,n);
            ans+=num*i;
            n=n-num;
            
        }
        return ans;

    }
}