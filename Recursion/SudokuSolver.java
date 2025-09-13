/*
    
 */
class SudokuSolver {
    public boolean compute(char[][] board, int i, int j){
        boolean res = false;
        if(j == 9){
            i++;
            j = 0;
        }
        if(i == 9) return true;

        if(board[i][j] != '.'){
            res = compute(board, i, j + 1);
            if(res) return res;
        }
        else{
            for(int k = 1; k <=9; k++){
                if(isSafe(board, i, j, (char)(k + '0'))){
                    board[i][j] = (char)(k + '0');
                    res = compute(board, i, j + 1);
                    if(res) return res;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
    public boolean isSafe(char[][] board, int i, int j, char k){
        for(int l = 0; l < 9; l++) if(board[i][l] == k) return false;
        for(int l = 0; l < 9; l++) if(board[l][j] == k) return false;

        int r = (i / 3) * 3, c = (j / 3) * 3;
        for(int l = 0; l < 3; l++){
            for(int h = 0; h < 3; h++){
                if(board[r + l][c + h] == k) return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        compute(board, 0, 0);
    }
}