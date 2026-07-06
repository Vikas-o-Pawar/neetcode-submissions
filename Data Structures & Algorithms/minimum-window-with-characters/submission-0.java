class Solution {
    public String minWindow(String s, String t) {
        int[] arr1 = new int[52];
        int[] arr2 = new int[52];
        int n = s.length();
        initStringT(arr2, t);

        int i = 0;
        int j = 0;

        int start = -1;
        int end = -1;

        while(j < n) {
            char cj = s.charAt(j);
            int idx = -1;

            if(isUpper(cj)) {
                idx = charToIntUpper(cj);
            } else {
                idx = charToIntLower(cj);
            }

            if(arr2[idx] >= 1) {
                arr1[idx]++;
            }

            j++;

            if(covers(arr1, arr2)) {
                if((start == -1 && end == -1) || (j - i < end - start)) {
                    start = i;
                    end = j;
                }


                while(covers(arr1, arr2)) {
                    if((start == -1 && end == -1) || (j - i < end - start)) {
                        start = i;
                        end = j;
                    }

                    char ci = s.charAt(i);
                    int id = -1;

                    if(isUpper(ci)) {
                        id = charToIntUpper(ci);
                    } else {
                        id = charToIntLower(ci);
                    }

                    if(arr2[id] >= 1) {
                        arr1[id]--;
                    }

                    i++;
                }
            }

        }

        if(start == -1) {
            return "";
        }

        return s.substring(start, end);
    }

    public boolean covers(int[] arr1, int[] arr2) {
        for(int i = 0; i < 52; i++) {
            if(arr1[i] < arr2[i]) {
                return false;
            } 
        }

        return true;
    }

    public void initStringT(int[] arr, String t) {
        for(int i = 0; i < t.length(); i++) {
            char ci = t.charAt(i);
            int idx = -1;

            if(isUpper(ci)) {
                idx = charToIntUpper(ci);
            } else {
                idx = charToIntLower(ci);
            }
            arr[idx]++;
        }
    }

    public boolean isUpper(char ch) {
        return Character.isUpperCase(ch);
    }

    public int charToIntLower(char ch) {
        return (ch - 'a');
    }

    public int charToIntUpper(char ch) {
        return (ch - 'A') + 26;
    }
}
