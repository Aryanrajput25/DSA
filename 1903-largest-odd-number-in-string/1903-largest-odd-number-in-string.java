class Solution {
    public String largestOddNumber(String num) {
        StringBuilder ans=new StringBuilder();
        for(int i=num.length()-1;i>=0;i--){
            if(num.charAt(i)%2!=0){
                for(int j=0;j<=i;j++){
                    ans.append(num.charAt(j));
                } 
                break;              
            }
            else continue;
        }
        return ans.toString();
    }
}