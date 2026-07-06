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
    int goodNodes(TreeNode* root) {
        return goodNodes(root, -10000);
    }

    int goodNodes(TreeNode* root, int max) {
        if(root == nullptr) {
            return 0;
        }

        int result = (root->val >= max)? 1 : 0;
        
        if(root->val > max) {
            max = root->val;
        }

        int left = goodNodes(root->left, max);
        int right = goodNodes(root->right, max);

        return result + left + right;
    }
};
