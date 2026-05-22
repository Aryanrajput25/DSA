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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        if(length==n){
            return head.next;
        }
        int num=length-n;
        ListNode start=head;
        for(int i=1;i<num;i++){
            start=start.next;
        }
        start.next=start.next.next;
        
        return head;
    }
}