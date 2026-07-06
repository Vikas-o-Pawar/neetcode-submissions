class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

        for(int row = 0; row < 9; row++) {
            bool rowResult = checkRow(board, row);

            if(!rowResult) {
                return false;
            }
        }        

        for(int col = 0; col < 9; col++) {
            bool colResult = checkCol(board, col);

            if(!colResult) {
                return false;
            }
        }

        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j <9; j+= 3) {
                bool cellResult = checkCell(board, i, j);
                if(!cellResult) {
                    return false;
                }
            }
        }
        return true;
    }


    bool checkCell(vector<vector<char>> &board, int r, int c) {
        unordered_set<char> st;

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board[i][j] != '.' && (st.find(board[i][j]) != st.end())) {
                    return false;
                }
                st.insert(board[i][j]);
            }
        }

        return true;
    }

    bool checkRow(vector<vector<char>> &board, int r) {
        // to check the row, keep r same and increment c;
        unordered_set<char> st;

        for(int i=0; i<9;i++) {
            if(st.find(board[r][i]) != st.end() && board[r][i] != '.') {
                cout<< r << " " << i << endl;
                return false;
            } 

            st.insert(board[r][i]);
        }

        return true;
    }

    bool checkCol(vector<vector<char>> &board, int c) {
        // to check the col, increment row and c same
        unordered_set<char> st;
        
        for(int i = 0; i < 9; i++) {
            if(st.find(board[i][c]) != st.end() && board[i][c] != '.') {
                return false;
            }

            st.insert(board[i][c]);
        }

        return true;
    }
};
