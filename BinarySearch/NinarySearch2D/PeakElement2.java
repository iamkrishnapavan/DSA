/*
    We first find mid column then find row with max element.
    Then check if it is greater than left and right eleemnts then it is peak else perform same process gain.
 */
class PeakElement2 {
    public int findRow(int[][] a, int col){
        int max = Integer.MIN_VALUE, row = -1;
        for(int i = 0; i < a.length; i++){
            if(a[i][col] > max){
                max = a[i][col];
                row = i;
            }
        }
        return row;
    }
    public int[] bSearch(int[][] a, int l, int h){
        if(l > h) return new int[] {-1, -1};
        int mid = l + (h - l)/2;
        int row = findRow(a, mid);
        int left = mid - 1 >= 0? a[row][mid - 1] : -1;
        int right = mid + 1 < a[0].length ? a[row][mid + 1] : -1;
        if(a[row][mid] > left && a[row][mid] > right) return new int[] {row, mid};
        else if(a[row][mid] < left) return bSearch(a, l, mid - 1);
        else return bSearch(a, mid + 1, h);
    }
    public int[] findPeakGrid(int[][] mat) {
        return bSearch(mat, 0, mat[0].length - 1);
    }
}