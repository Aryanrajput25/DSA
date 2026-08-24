class Solution {
    public boolean sumGame(String num) {
        int leftsum=0, rightsum=0, leftquemark=0, rightquemark=0;
        for(int i=0;i<num.length()/2;i++){
            if(num.charAt(i)=='?') leftquemark++;
            else leftsum+=num.charAt(i)-'0';
        }
        for(int i=num.length()/2;i<num.length();i++){
            if(num.charAt(i)=='?') rightquemark++;
            else rightsum+=num.charAt(i)-'0';
        }
        return 2 * (leftsum - rightsum)!= 9 * (rightquemark - leftquemark);
    }
}