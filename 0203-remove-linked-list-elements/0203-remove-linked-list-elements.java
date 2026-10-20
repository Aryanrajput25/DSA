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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy= new ListNode(0,head);
        if(head==null) return null;
        ListNode temp=head;
        ListNode prev=dummy;
        while(temp!=null){
            if(temp.val==val) prev.next=prev.next.next;
            else {
                prev=temp;
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}