/*
    TIME COMPLEXITY
    ================
    Suppose:
    Grid size = M x N
    Word length = k
    Starting points: You try compute(...) from every cell → O(M * N).
    DFS branching:
    At each step, you can move in 4 directions.
    Worst case, you explore all 4 paths recursively.
    Depth of recursion ≤ k (since string length cannot exceed word.length()).
    So worst-case:
    T=O(M * N * 4^k)
    👉 Because for each starting cell, you may explore up to 4^k possibilities.

    SPACE COMPLEXITY
    =======================
    Visited array b → O(m * n).
    StringBuilder str → at most length k → O(k).
    Recursion stack → depth k → O(k).
    So : S=O(m⋅n+k)
    KEY POINTS
    ============
    We can also solve with index rather than stringbuilder and we can exclude matrix b by changing the original matrix a and reverting back.
 */
// Approach - 1
class Solution {
    public boolean compute(char[][] a, int[][] b, StringBuilder str, String word, int i, int j){
        if(str.length() == word.length() && word.equals(str.toString())) return true;
        if( !(i >= 0 && i < a.length && j >= 0 && j < a[0].length && b[i][j] == 0) || (str.length() >= word.length()) || (a[i][j] != word.charAt(str.length()))) return false;
        boolean res = false;
        str.append(a[i][j]);
        b[i][j] = 1;
        res = compute(a, b, str, word, i + 1, j);
        if(!res) res = compute(a, b, str, word, i , j + 1);
        if(!res) res = compute(a, b, str, word, i - 1 , j);
        if(!res) res = compute(a, b, str, word, i , j - 1);
        str.deleteCharAt(str.length() - 1);
        b[i][j] = 0;

        return res;
    }
    public boolean exist(char[][] board, String word) {
        int[][] b = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(compute(board, b, new StringBuilder(), word, i, j)) return true;
            }
        }
        return false;
    }
}

// Approach - 2
class Solution {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        int[][] mem = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    mem[i][j]=1;
                    go(board, i, j, word,1,mem);
                    mem[i][j]=0;
                }
            }
        }
        return res;
    }
    private void go(char[][] board, int i, int j, String word, int index,int[][] mem){
        if(res) return;
        if(index==word.length()){
            res = true;
            return;
        }
        if( (j+1<board[0].length) && (word.charAt(index)==board[i][j+1]) && mem[i][j+1]!=1){
            mem[i][j+1]=1;
            go(board, i, j+1, word, index+1, mem);
            mem[i][j+1]=0;
        }
        if( (i+1<board.length) && (word.charAt(index)==board[i+1][j]) && mem[i+1][j]!=1){
            mem[i+1][j]=1;
            go(board, i+1, j, word, index+1, mem);
            mem[i+1][j]=0;
        }
        if( (j-1>=0) && (word.charAt(index)==board[i][j-1]) && mem[i][j-1]!=1){
            mem[i][j-1]=1;
            go(board, i, j-1, word, index+1, mem);
            mem[i][j-1]=0;
        }
        if( (i-1>=0) && (word.charAt(index)==board[i-1][j]) && mem[i-1][j]!=1){
            mem[i-1][j]=1;
            go(board, i-1, j, word, index+1, mem);
            mem[i-1][j]=0;
        }
    }
} i backtracked all 4 recursion calls are done but in this code which in leet code submission at each call it backtracked
