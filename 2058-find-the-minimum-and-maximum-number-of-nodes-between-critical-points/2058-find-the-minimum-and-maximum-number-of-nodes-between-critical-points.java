/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        int i=1;
        while(head.next!=null){
            ListNode prev=head;
            head=head.next;
            if(head.next==null) break;
            if(head.val>head.next.val && head.val>prev.val) arr.add(i);
            else if(head.val<head.next.val && head.val<prev.val) arr.add(i);
            i++;
        }
        if(arr.size()<=1) return new int[]{-1,-1};
        int maxdist=arr.get(arr.size()-1)-arr.get(0);
        int mindist=arr.get(1)-arr.get(0);;
        for(int j=1;j<arr.size();j++){           
            mindist=Math.min(mindist,arr.get(j)-arr.get(j-1));
        }
        return new int[]{mindist,maxdist};
    }
}