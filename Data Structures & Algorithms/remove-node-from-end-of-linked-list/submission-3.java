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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalLength = 0;

        ListNode temp = head;

        while(temp != null) {
            totalLength++;
            temp = temp.next;
        }

        temp = head;
        int i = 0;
        
        if(n == totalLength) {
            head = head.next;
            return head;
        }


        while(i < totalLength - n - 1) {
            temp = temp.next;
            i++;
        }

        if(temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}