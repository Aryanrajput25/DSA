class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0, min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            maxprofit=Math.max(maxprofit,prices[i]-min);
        }
        return maxprofit;
    }
}