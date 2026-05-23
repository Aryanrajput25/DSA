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
        ListNode t1=headA;
        ListNode t2=headB;
        int l1=0;
        int l2=0;
        while(t1!=null){
            l1++;
            t1=t1.next;
        }
        while(t2!=null){
            l2++;
            t2=t2.next;
        }
        t1 = headA;
        t2 = headB;
        if(l1>l2){
            return findpoint(t2,t1,l1-l2);
        }
        else{
            return findpoint(t1,t2,l2-l1);
        }
    }
    public ListNode findpoint(ListNode t1,ListNode t2,int d){
        while(d!=0){
            d--;
            t2=t2.next;
        }
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
        }
        return t1;

    }
}