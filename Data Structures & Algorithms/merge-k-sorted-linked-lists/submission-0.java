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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(
           (a, b) -> Integer.compare(a.val, b.val) 
        );

        for(ListNode list : lists) {
            while(list != null) {
                q.offer(list);
                list = list.next;
            }
        }

        ListNode head = null;
        ListNode temp = null;
        
        while(!q.isEmpty()) {
            ListNode node = q.poll();
            node.next = null;
            
            if(head == null) {
                head = node;
                temp = node;
            } else {
                temp.next = node;
                temp = temp.next;

            }
        }

        return head;
    }
}