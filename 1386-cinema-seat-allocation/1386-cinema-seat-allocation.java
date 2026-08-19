class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            int row=reservedSeats[i][0];
            int seat=reservedSeats[i][1];
            map.putIfAbsent(row,new int[10]);
            map.get(row)[seat-1]=1;
        }
        int count=0;
        count+=(n-map.size())*2;
        for(int row: map.keySet()){
            int[] seats=map.get(row);
            boolean left=seats[1]==0 && seats[2]==0 && seats[3]==0 && seats[4]==0;
            boolean right=seats[5]==0 && seats[6]==0 && seats[7]==0 && seats[8]==0;
            boolean middle=seats[3]==0 && seats[4]==0 && seats[5]==0 && seats[6]==0;
            if(left && right) count+=2;
            else if(left || right) count++;
            else if(middle) count++;
        }
        return count;
    }
}