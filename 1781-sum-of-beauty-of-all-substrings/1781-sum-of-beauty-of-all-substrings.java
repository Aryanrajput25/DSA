class Solution {
    public int beautySum(String s) {
        int count=0;
        for(int l=0;l<s.length();l++){
            int[] freq=new int[26];
            for(int r=l;r<s.length();r++){
                int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
                freq[s.charAt(r)-'a']++;
                for(int i=0;i<26;i++){
                    if(freq[i]==0) continue;
                    max=Math.max(max,freq[i]);
                    min=Math.min(min,freq[i]);
                }
                count+=max-min;
            }
            freq[s.charAt(l)-'a']--;
        }
        return count;
    }
}