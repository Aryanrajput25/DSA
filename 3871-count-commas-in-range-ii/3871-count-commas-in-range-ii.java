class Solution {
    public long countCommas(long n) {
        long start=999;
        long total=0;
        int comma=1;
        while(start<n){
            long end=start*1000+999;
            if(end>n) end=n;
            total+=(end-start)*comma;
            start=start*1000+999;
            comma++;
        }
        return total;
    }
}