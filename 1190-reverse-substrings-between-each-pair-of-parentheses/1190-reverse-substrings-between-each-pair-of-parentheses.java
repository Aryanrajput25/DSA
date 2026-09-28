class Solution {
    public String reverseParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(sb.length());
            }
            else if (s.charAt(i) == ')') {
                int start = stack.pop();
                reverse(sb, start, sb.length() - 1);
            }
            else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    void reverse(StringBuilder sb, int i, int j) {

        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);

            i++;
            j--;
        }
    }
}