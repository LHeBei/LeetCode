package Le19;


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
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        if(find(head,n)==n) return head.next;
        return head;
    }

    private int find(ListNode head,int n){
        if(head==null) return 0;
        else{
            int pos=find(head.next,n)+1;
            if(pos==n+1){
                head.next=head.next.next;
            }
            return pos;
        }
    }
    public static void print(ListNode head){
        if(head==null) return;
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+"-");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode listNode=new ListNode(1);
        ListNode head=listNode;
        for (int i=2;i<6;i++){
            ListNode temp=new ListNode(i);
            listNode.next=temp;
            listNode=temp;
        }
        head=solution.removeNthFromEnd(head,5);
        print(head);
    }
}