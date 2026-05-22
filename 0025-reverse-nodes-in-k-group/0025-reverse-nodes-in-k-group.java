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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<1){
            return head;
        }
        ListNode prev=null;
        ListNode pres=head;
        while(true){

            ListNode NewEnd=pres;
            ListNode last=prev;

            ListNode next=pres.next;
            ListNode temp = pres;
            int count = 0;

            while(temp != null && count < k) {
                temp = temp.next;
                count++;
            }
            if(count < k) {
                if(prev != null) {
                    prev.next = pres;
                }
                break;
            }       
            for(int i=0;pres!=null && i<k;i++){
                pres.next=prev;
                prev=pres;
                pres=next;
                if(next!=null) next=next.next;
            }
            if(last!=null) last.next=prev;
            else head=prev;
            NewEnd.next=pres;
            if(pres==null){
                break;
            }
            prev=NewEnd;
        }
        return head;
    }
}