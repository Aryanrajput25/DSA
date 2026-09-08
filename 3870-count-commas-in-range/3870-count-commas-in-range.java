class Solution {
    public int countCommas(int n) {
        int total = 0;
        int start = 1000;
        int commas = 1;
        while (start <= n) {
            int end = start * 1000 - 1;
            if (end > n) {
                end = n;
            }
            int numbers = end - start + 1;

            total += numbers * commas;

            start *= 1000;
            commas++;
        }
        return total;
    }
}