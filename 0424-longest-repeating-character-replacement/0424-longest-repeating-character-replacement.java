class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen=0, l=0, r=0, maxfreq=0;
        int[] hash=new int[26];
        Arrays.fill(hash,0);
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,hash[s.charAt(r)-'A']);
            while(((r-l+1)-maxfreq)>k){
                hash[s.charAt(l)-'A']--;
                maxfreq=0;
                for(int i=0;i<hash.length;i++){
                    maxfreq=Math.max(maxfreq,hash[i]);
                }
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}