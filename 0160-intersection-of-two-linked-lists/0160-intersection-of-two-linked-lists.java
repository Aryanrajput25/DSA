/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=0, l2=0;
        ListNode t1=headA, t2=headB;
        while(t1!=null){
            l1++;
            t1=t1.next;
        }
        while(t2!=null){
            l2++;
            t2=t2.next;
        }
        if(l1>l2) return collisionpt(headA,headB,l1-l2);
        return collisionpt(headB,headA,l2-l1);
    }
    ListNode collisionpt(ListNode t1,ListNode t2, int diff){
        while(diff>0){
            diff--;
            t1=t1.next;
        }
        while(t1!=null || t2!=null){
            if(t1==t2) return t1;
            t1=t1.next;
            t2=t2.next;
        }
        return null;
    }
}