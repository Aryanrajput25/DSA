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
        if(k<=0 || head==null || head.next==null) return head;
        ListNode end=head;
        int length=1;
        while(end.next!=null){
            end=end.next;
            length++;
        }
        end.next=head;
        int rotations=k%length;
        int skip=length-rotations;
        ListNode lastnode=head;
        for (int i=0;i<skip-1;i++){
            lastnode=lastnode.next;
        }
        head=lastnode.next;
        lastnode.next=null;
        return head;
    }
}