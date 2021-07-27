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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode headOdd = head;
        ListNode headEven = head.next;
        ListNode odd = headOdd;
        ListNode even = headEven;
        ListNode temp = even.next;
        
        if(temp==null){
            return head;
        }
        
        boolean isOdd = true;
        while(temp!=null){
            if(isOdd){
                odd.next = temp;
                temp = temp.next;
                odd = odd.next;
                odd.next = headEven;
                even.next=null;
                isOdd = false;
            }else{
                even.next = temp;
                temp = temp.next;
                even = even.next;
                even.next=null;
                isOdd = true;
            }
        }
        
        return headOdd;
        
    }
}