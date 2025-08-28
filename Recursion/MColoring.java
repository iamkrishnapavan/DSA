import java.util.*;
public class MColoring {
    public static boolean compute(int[][] mat, int[] b, int v, int n, int m){
        boolean res = false;
        if(v == n) return true;

        for(int i = 0; i < m; i++){
            if(isNodeColorable(i, mat, b, v)){
                int temp = b[v];
                b[v] = i;
                res = compute(mat, b, v + 1, n, m);
                b[v] = temp;
            }
            if(res) return res;
        }
        return res;
    }

    public static boolean isNodeColorable(int m, int[][] mat, int[] b, int node){
        for(int i = 0; i < mat.length; i++){
            if(mat[node][i] == 1 && b[i] == m) return false;
        }
        return true;
    }
    public static String graphColoring(int [][]mat, int m) {
        int[] b = new int[mat.length];
        Arrays.fill(b, -1);
        if (compute(mat, b, 0, mat.length, m)) return "YES";
        else return "NO";
    }
}