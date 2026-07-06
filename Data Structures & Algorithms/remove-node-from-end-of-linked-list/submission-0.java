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
        int length = getLengthOfLL(head);

        if(n == length) {
            head = head.next;
            return head;
        }

        int i = 1;
        int diff = length - n;
        ListNode temp = head;

        while(i < diff) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        return head;
    }

    public int getLengthOfLL(ListNode head) {
        ListNode temp = head;
        int len = 0;

        while(temp != null) {
            temp = temp.next;
            len++;
        }

        return len;
    }
}
