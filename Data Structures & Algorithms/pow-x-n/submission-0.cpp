class Solution {
public:
    double myPow(double x, int n) {
        double res = 1;
        bool neg = false;

        if(n < 0) {
            neg = true;
            n = - (n);
        }

        while(n != 0) {
            res = (res * x);
            n--;
        }

        if(neg) {
            return 1 / res;
        }

        return res;
    }
};
