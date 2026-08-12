class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
            char curr=s.charAt(i);
            char next=s.charAt(i+1);
            if(map.get(curr)<map.get(next)){
                sum-=map.get(curr);
            }
            else{
                sum+=map.get(curr);
            }
        }
        return sum;
    }
}