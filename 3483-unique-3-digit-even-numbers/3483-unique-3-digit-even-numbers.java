class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        int ans=0;
        for(int i=0;i<digits.length;i++){
            freq[digits[i]]++;
        }
        int n=freq.length;
        for(int i=1;i<n;i++){
            if(freq[i]==0) continue;
            freq[i]--;
            for(int j=0;j<n;j++){
                if(freq[j]==0) continue;
                freq[j]--;
                for(int k=0;k<n;k+=2){
                    if(freq[k]>0) ans++;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return ans;
    }
}