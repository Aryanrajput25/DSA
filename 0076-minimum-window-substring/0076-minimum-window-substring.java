class Solution {
    public String minWindow(String s, String t) {
        int l=0,r=0,count=0,startidx=-1,minlen=Integer.MAX_VALUE;
        int[] hash=new int[256];
        Arrays.fill(hash,0);
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }
        while(r<s.length()){
            if(hash[s.charAt(r)]>0) count++;
            hash[s.charAt(r)]--;
            while(count==t.length()){
                if(minlen>r-l+1){
                    startidx=l;
                    minlen=r-l+1;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) count--;
                l++;
            }
            r++;
        }
        if(startidx==-1) return "";
        return s.substring(startidx,startidx + minlen);
    }
}