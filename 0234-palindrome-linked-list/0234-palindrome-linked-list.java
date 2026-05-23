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
    public boolean isPalindrome(ListNode head) {
        ListNode mid=middle(head);
        ListNode l2=reverseList(mid.next);
        ListNode l1=head;
        while(l1!=null && l2!=null){
            if(l1.val!=l2.val){
                reverseList(l2);
                return false;
            }
            l1=l1.next;
            l2=l2.next;
        }
        reverseList(l2);
        return true; 
    }
    public ListNode middle(ListNode head){
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode pres=head;
        ListNode next=pres.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }
}