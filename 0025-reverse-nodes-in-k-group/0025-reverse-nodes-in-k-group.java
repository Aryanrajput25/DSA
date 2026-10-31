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
        ListNode temp=head, prevnode=null;
        while(temp!=null){
            ListNode kthnode=kthnode(temp,k);
            if(kthnode==null){
                if(prevnode!=null) {
                    prevnode.next=temp;
                    
                }
                break;
            }
            ListNode nextnode=kthnode.next;
            kthnode.next=null;
            reverse(temp);
            if(prevnode == null) head = kthnode;
            else prevnode.next=kthnode;
            prevnode=temp;
            temp=nextnode;
        }
        return head;
    }
    ListNode kthnode(ListNode temp,int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
            
        }
        return temp;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}