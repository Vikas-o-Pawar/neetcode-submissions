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
    void reorderList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) {
            return;
        }

        ListNode* slow = head;
        ListNode* fast = head;

        while(fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* second = slow->next;
        slow->next = nullptr;
        ListNode* prev = nullptr;

        while(second != nullptr) {
            ListNode* next = second->next;

            second->next = prev;
            prev = second;
            second = next;
        }

        ListNode* secondHead = prev;
        ListNode* firstHead = head;

        while(secondHead != nullptr) {
            ListNode* t1 = firstHead->next;
            ListNode* t2 = secondHead->next;

            firstHead->next = secondHead;
            secondHead->next = t1;

            firstHead = t1;
            secondHead = t2;
        }

    }
};