/*
    TIME COMPLEXITY O(p * N ^ 2) where p is no of valid paths.
    ================
    At each cell, we explore up to 4 directions (D, L, R, U).
    WORST CASE: the grid is full of 1s (no walls).
    Then from each cell you might recurse in 4 directions, but you don’t revisit already visited cell
    So essentially, it’s like exploring all possible simple paths from (0,0) to (n-1,n-1).
    Upper bound: O(4^(n*n)) (at most 4 choices from each cell).
    But practically, since each cell is visited once per path, and there are at most n*n cells, one path costs O(n^2) work.
    If there are P paths, total time is O(P * n^2).

    SPACE COMPLEXITY  O(n^2 + P * n^2)
    ===================
    Recursion stack: at most depth n*n (if path visits all cells) → O(n^2).
    Path storage (StringBuilder): also O(n^2) (max path length).
    Output list: stores all paths. If P paths are found, and each path has length ≤ n^2, output size is O(P * n^2).

 */

import java.util.* ;
import java.io.*;
public class Solution {
    public static ArrayList < String > compute(int[][] arr, int i, int j, StringBuilder str, int n){
        ArrayList < String > l = new ArrayList<>();
        if(i == n - 1 && j == n - 1){
            l.add(str.toString());
            return l;
        }
        if((i >= 0 && i < n - 1) && (j >= 0 && j < n) && arr[i + 1][j] == 1){
            str.append("D");
            arr[i + 1][j] = 2;
            l.addAll(compute(arr, i + 1, j, str, n));
            str.deleteCharAt(str.length() - 1);
            arr[i + 1][j] = 1;
        }
        if((i >= 0 && i < n) && (j > 0 && j < n) && arr[i][j - 1] == 1){
            str.append("L");
            arr[i][j - 1] = 2;
            l.addAll(compute(arr, i, j - 1, str, n));
            str.deleteCharAt(str.length() - 1);
            arr[i][j - 1] = 1;
        }
        if((i >= 0 && i < n) && (j >= 0 && j < n - 1) && arr[i][j + 1] == 1){
            str.append("R");
            arr[i][j + 1] = 2;
            l.addAll(compute(arr, i, j + 1, str, n));
            str.deleteCharAt(str.length() - 1);
            arr[i][j + 1] = 1;
        }
        if((i > 0 && i < n) && (j >= 0 && j < n) && arr[i - 1][j] == 1){
            str.append("U");
            arr[i - 1][j] = 2;
            l.addAll(compute(arr, i - 1, j, str, n));
            str.deleteCharAt(str.length() - 1);
            arr[i - 1][j] = 1;
        }
        return l;
    }
    public static ArrayList < String > findSum(int[][] arr, int n) {
        if(arr.length == 0 || arr[0][0] == 0) return new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        if(arr.length > 0 && arr[0][0] == 1){
            arr[0][0] = 2;
        }
        return compute(arr, 0, 0, str, n);
    }
}