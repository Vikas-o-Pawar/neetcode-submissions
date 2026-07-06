class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> q;

        for(auto st: stones) {
            q.push(st);
        }


        while(q.size() >= 2) {
            int y = q.top();
            q.pop();
            
            int x = q.top();
            q.pop();

            if(x != y) {
                q.push(y - x);
            }
        }


        return q.size() == 0? 0: q.top();
    }
};
