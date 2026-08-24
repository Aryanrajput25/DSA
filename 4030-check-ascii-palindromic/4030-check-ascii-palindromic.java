class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            binary.append("0" + Integer.toBinaryString(s.charAt(i)));
        }
        int start = 0;
        int end = binary.length() - 1;
        while (start <= end) {
            if (binary.charAt(start) != binary.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}