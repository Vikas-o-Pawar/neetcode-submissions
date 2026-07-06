class Solution {
public:
    int characterReplacement(string s, int k) {
        int arr[26] = {0};

        int i = 0, j = 0, dist = 0, n = s.length(), maxFreq = 0;

        while(j < n) {
            char ch = s[j];
            int chIdx = charToInt(ch); // get the index : A -> 0 as so on..
            arr[chIdx]++; // increase the frequency of a character

            maxFreq = max(arr[chIdx], maxFreq); // find the maximum frequency so far
            int windowSize = j - i + 1;

            int diff = windowSize - maxFreq;

            while(diff > k) {
                char chi = s[i];
                arr[charToInt(chi)]--;
                i++;

                diff = (j - i + 1) - maxFreq;
            }

            dist = max(dist, j - i + 1);
            j++;
        }

        return dist;
    }

    int charToInt(char c) {
        return (c - 'A');
    }
};
