/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        insertCopyInBW(head);
        connectrandom(head);
        return getdeepcopy(head);
    }
    public void insertCopyInBW(Node head) {
        Node temp=head;
        while(temp!=null){
            Node nextnode=temp.next;
            Node copy=new Node(temp.val);
            copy.next=nextnode;
            temp.next=copy;
            temp=nextnode;
        }
    }
    public void connectrandom(Node head){
        Node temp=head;
        while(temp!=null){
            Node copynode=temp.next;
            if(temp.random!=null) copynode.random=temp.random.next;
            else copynode.random=null;
            temp=temp.next.next;
        }
    }
    public Node getdeepcopy(Node head){
        Node temp=head;
        Node dummynode=new Node(-1);
        Node res=dummynode;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummynode.next;
    }
}