class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int arr1[26] = {0};
        int arr2[26] = {0};

        for(int i = 0 ; i < s1.length(); i++) {
            int chi = (s1[i] - 'a');
            arr1[chi]++;
        }

        int j = 0;
        int i = 0;

        while(j < s1.length()) {
            int chj = (s2[j] - 'a');
            arr2[chj]++;
            j++;
        }        

        while(j < s2.length()) {
            if(arrEquals(arr1, arr2)) {
                return true;
            }


            arr2[(s2[i] - 'a')]--;
            i++;

            arr2[(s2[j] - 'a')]++;
            j++;
        }

        return arrEquals(arr1, arr2);
    }

    bool arrEquals(const int arr1[], const int arr2[]) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
    return true;
}

};
