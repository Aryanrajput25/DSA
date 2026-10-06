class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!stack.isEmpty() && k>0 && (stack.peek()-'0')>num.charAt(i)-'0'){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder s=new StringBuilder();
        while(!stack.isEmpty()){
            s.append(stack.peek());
            stack.pop();
        }
        while(s.length()!=0 && s.charAt(s.length()-1)=='0'){
            s.deleteCharAt(s.length()-1);
        }
        s.reverse();
        if(s.length()==0) return "0";
        return s.toString();
    }
}