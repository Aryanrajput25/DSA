class Solution {
    public int divide(int dividend, int divisor) {

        // Same numbers
        if (dividend == divisor) {
            return 1;
        }

        // Determine sign
        boolean positive = true;

        if (dividend < 0 && divisor > 0 ||
            dividend > 0 && divisor < 0) {
            positive = false;
        }

        // Convert to long before abs() to handle Integer.MIN_VALUE
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        // Subtract powers of divisor
        while (n >= d) {

            int cnt = 0;

            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            quotient += (1L << cnt);
            n -= (d << cnt);
        }

        // Handle overflow cases
        if (quotient == (1L << 31) && positive) {
            return Integer.MAX_VALUE;
        }

        if (quotient == (1L << 31) && !positive) {
            return Integer.MIN_VALUE;
        }

        return positive ? (int) quotient : (int) -quotient;
    }
}