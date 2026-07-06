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
        ListNode globalStartNode = null, startNode = null, endNode = head, 
        temp = head, curr = head;
        int i = 0;
        if(k == 1) return head;
        int dk = k;

        while(true) {
            i++;
            temp = temp.next;

            if(i == k) {
                ListNode prev = null;
                ListNode nextEndNode = curr;

                while(curr != temp) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;

                    if(next == temp) {
                        // startNode of the this current window 'k'
                        startNode = curr;

                        if(globalStartNode == null) {
                            globalStartNode = curr;
                        }
                    }

                    curr = next;
                }

                endNode.next = startNode;
                endNode = nextEndNode;

                k += dk;
            }
            
            if(i < k && temp == null) {
                endNode.next = curr;
                break;
            }            
        }

        return globalStartNode;
    }
}