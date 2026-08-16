class Solution {
    public String longestPalindrome(String s) {
        int start=-1, end=-1;
        int maxlen=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(ispalindrome(s.substring(i,j+1))){
                    int length=j-i+1;
                    if(length>maxlen){
                        start=i;
                        end=j;
                        maxlen=length;
                    }
                }
            }
        }
        return s.substring(start,end+1);

    }
    public Boolean ispalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}