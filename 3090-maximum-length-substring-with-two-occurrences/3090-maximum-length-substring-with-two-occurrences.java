class Solution {
    public int maximumLengthSubstring(String s) {
        int[] hash = new int[26];
        Arrays.fill(hash,0);
        int l=0, r=0;
        int maxfreq=0;
        int maxlen=0;
        while(r<s.length()){
            hash[s.charAt(r)-'a']++;
            while (hash[s.charAt(r)-'a']>2){
                hash[s.charAt(l)-'a']--;
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}