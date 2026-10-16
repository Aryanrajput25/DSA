class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num;i++){
            int n=Math.min(sum,9);
            sb.append(n);
            sum-=n;
        }
        if(sum>0) return "";
        return sb.toString();
    }
}