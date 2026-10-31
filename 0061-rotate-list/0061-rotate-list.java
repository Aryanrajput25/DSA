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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode temp=head, last=null, next=null;
        int length=0;
        while(temp!=null){
            length++;
            last=temp;
            temp=temp.next;
        }
        k=k%length;
        if (k == 0) return head;
        int count=length-k-1;
        temp=head;
        while(count>0 &&temp!=null){
            temp=temp.next;
            count--;
        }
        
        next=temp.next;
        temp.next=null;
        
        last.next=head;
        return next;
    }
}