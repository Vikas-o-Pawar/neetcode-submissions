/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        int result = checkHeight(root);

        if(result == -10000) {
            return false;
        }

        return true;
    }

    int checkHeight(TreeNode* root) {
        if(root == nullptr) {
            return -1;
        }

        int left = checkHeight(root->left);

        if(left == -10000) return -10000;

        int right = checkHeight(root->right);

        if(right == -10000) return -10000;       

        int diff = right - left;

        if(!(diff >= -1 && diff <= 1)) {
            return -10000;
        }

        return max(left, right) + 1;
    }
};
