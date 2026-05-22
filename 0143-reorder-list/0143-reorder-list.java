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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode mid=middlenode(head);
        ListNode hf=head;
        ListNode hs=reverseList(mid);
        while(hf!=null && hs!=null){
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;
            ListNode temp1=hs.next;
            hs.next=hf;
            hs=temp1;
        }
        if(hf!=null){
            hf.next=null;
        }
    }
    public ListNode middlenode(ListNode node){
        ListNode s=node;
        ListNode f=node.next;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode pres=head;
        ListNode next=head.next;
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