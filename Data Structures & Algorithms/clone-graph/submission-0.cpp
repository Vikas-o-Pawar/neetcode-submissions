/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(node == nullptr) {
            return nullptr;
        }
        
        unordered_map<Node*, Node*> mp;

        return dfs(node, mp);
    }

    Node* dfs(Node* node, unordered_map<Node*, Node*> &mp) {
        if(mp.find(node) != mp.end()) {
            return mp[node];
        }


        Node* newNode = new Node(node->val);
        mp[node] = newNode;

        vector<Node*> neighbors = node->neighbors;

        for(Node* n: neighbors) {
            newNode->neighbors.push_back(dfs(n, mp));
        }

        return newNode;
    }
};
