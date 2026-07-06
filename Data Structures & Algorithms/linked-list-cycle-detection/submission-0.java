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
    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        do {
            f = f.next;
            s = s.next;

            if(f == null || s == null) {
                return false;
            }

            s = s.next;
            if(s == null) {
                return false;
            }
        } while(f != s);

        return true;
    }
}
