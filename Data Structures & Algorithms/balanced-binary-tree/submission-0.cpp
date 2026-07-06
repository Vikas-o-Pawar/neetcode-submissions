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
        if(root == nullptr) {
            return true;
        }

        bool left = isBalanced(root->left);
        bool right = isBalanced(root->right);

        int leftHeight = height(root->left);
        int rightHeight = height(root->right);

        int diff = leftHeight - rightHeight;

        if(!(diff >= -1 && diff <= 1)) {
            return false;
        }

        return left && right;
    }

    int height(TreeNode* root) {
        if(root == nullptr) {
            return -1;
        }

        int left = height(root->left) + 1;
        int right = height(root->right) + 1;

        return max(left, right);
    }
};
