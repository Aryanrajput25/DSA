class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int high=sum;
        int low=max;
        if(days==1) return sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(func(weights,days,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    Boolean func(int[] weights, int days, int capacity){
        int dayused=1, sum=0;
        for (int i = 0; i < weights.length; i++) {

            if (sum + weights[i] > capacity) {
                dayused++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }

        return dayused <= days;
    }
}