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
        Map<Node, Node> map = new HashMap<>();
        // index, node
        Node temp = head;

        while(temp != null) {
            map.put(temp, new Node(temp.val));    
            temp = temp.next;
        }    

        temp = head;
        Node newHead = null;
        Node newTemp = null;
        Node tail = null;


        while(temp != null) {
            if(newHead == null) {
                newHead = map.get(temp);
                newTemp = newHead;
            } 

            if(temp.next != null) {
                newTemp.next = map.get(temp.next);
            } 

            if(temp.random == null) {
                newTemp.random = tail;
            } else {
                newTemp.random = map.get(temp.random);
            }

            temp = temp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}