class Solution {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = next(n);
        }
        return n == 1;
    }

    private int next(int num) {
        int sum = 0;
        while (num > 0) {
            int d = num % 10;
            sum += d * d;
            num /= 10;
        }
        return sum;
    }
}