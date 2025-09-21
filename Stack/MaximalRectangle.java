/*
    Variation of Histogram problem
    Build histogram per row.
    Solve histogram with monotonic stack.
    Use a.length as right boundary if no smaller element on right.
    Maximal Rectangle = max of all histograms.

    Time & Space Complexity
    O(n * m) → n = rows, m = columns
    Each row builds histogram: O(m)
    Each histogram solved in O(m) (stack)

    Space: O(m) for heights + stack
 */
class MaximalRectangle{
    public int maximalRectangle(char[][] matrix) {
        int[] s = new int[matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '0') s[j] = 0;
                else s[j] += 1;
            }
            res = Math.max(res, compute(s));
        }
        return res;
    }

    public int compute(int[] a){
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i = 0; i < a.length; i++){
            if(s.isEmpty() || a[s.peek()] <= a[i]) s.push(i);
            else {
                while(!s.isEmpty() && a[s.peek()] > a[i]){
                    int height = a[s.pop()];
                    int left = s.isEmpty() ? -1 : s.peek();
                    res = Math.max(res, (i - left - 1) * height);
                }
                s.push(i);
            }
        }
        while(!s.isEmpty()){
            int right = s.pop();
            int height = a[right];
            int left = s.isEmpty() ? -1 : s.peek();
            res = Math.max(res, (a.length - left - 1) * height);
        }
        return res;
    }
}