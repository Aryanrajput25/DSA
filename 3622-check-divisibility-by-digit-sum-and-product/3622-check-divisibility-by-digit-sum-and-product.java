class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        long product=1;
        int og=n;
        while(n>0){
            int digit=n%10;
            n=n/10;
            sum+=digit;
            product*=digit;
        }
        return (og%(sum+product)==0);
    }
}