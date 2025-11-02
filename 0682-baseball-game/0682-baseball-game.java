

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            

            if (operations[i].equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.peek();
                stack.push(val1);
                stack.push(val1 + val2);
            } 
            else if (operations[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } 
            else if (operations[i].equals("C")) {
                stack.pop();
            } 
            else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;
        for (int val : stack) {
            sum += val;
        }

        return sum;
    }
}
