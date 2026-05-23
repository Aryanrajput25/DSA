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
        ListNode temp=head;
        ListNode nextnode=head;
        ListNode prevnode=null;
        while(temp !=null){
            ListNode kthnode=findkthnode(temp,k);
            if(kthnode==null){
                if(prevnode!=null) prevnode.next=temp;
                break;
            }
            nextnode=kthnode.next;
            kthnode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthnode;
            }
            else prevnode.next=kthnode;
            prevnode=temp;
            temp=nextnode;

        }
        return head;
    }
    public ListNode findkthnode(ListNode node, int k){

        k--;

        while(node != null && k > 0){
            node = node.next;
            k--;
        }

        return node;
    }
    public ListNode reverse(ListNode head){
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