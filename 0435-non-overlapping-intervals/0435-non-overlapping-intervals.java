class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int endtime=intervals[0][1], count=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=endtime){
                count++;
                endtime=intervals[i][1];
            }
        }
        return intervals.length-count-1;
    }
}