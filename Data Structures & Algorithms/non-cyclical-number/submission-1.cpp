class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> st;

        while(true) {
            n = digitSum(n);

            if(n == 1) {
                return true;
            } 

            if(st.find(n) != st.end()) {
                // element found again
                return false;
            }

            st.insert(n);
        }

        
        return false;
    }

    int digitSum(int n) {
        int x = 0;

        while(n != 0) {
            int rem = n % 10;
            x = x + (rem * rem);
            n = n / 10;
        }

        return x;
    }
};
