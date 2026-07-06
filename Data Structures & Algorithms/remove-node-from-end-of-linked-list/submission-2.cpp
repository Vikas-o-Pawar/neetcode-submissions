/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int i = 0;
        int j = 0;

        ListNode* temp = head;

        while(temp != nullptr) {
            temp = temp->next;
            i++;
        }

        temp = head;
        
        while(j < (i - n - 1)) {
            j++;
            temp = temp->next; 
        }

        if(i == n) {
            head = head->next;
            return head;
        } else if(temp->next == nullptr) {
            return nullptr;
        } else if(temp->next->next == nullptr ) {
            temp->next = nullptr;
        } else {
            ListNode* savedNode = temp->next->next;
            temp->next = nullptr;
            temp->next = savedNode; 
        }

        return head;
    }
};