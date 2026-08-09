class Solution {
    public String largestOddNumber(String num) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<num.length();i++){
            ans.append(num.charAt(i));
        }
        for(int i=ans.length()-1;i>=0;i--){
            if((ans.charAt(i) - '0')%2!=0){
                return ans.toString();             
            }
            else ans.deleteCharAt(i);
        }
        return "";
    }
}