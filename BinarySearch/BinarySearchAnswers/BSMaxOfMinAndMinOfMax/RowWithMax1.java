/*
    This approach is useful only if array is sorted
    IF array is sorted TC => O(N log M)
    IF array is not sorted TC => O(N*M log M)
    IF brute force TC => O(N*M)
    Here for learning purpose i used binary search approach for unsorted.
 */
class RowWitmMax1 {
    public int findIndex(int[] a, int l, int h){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        if(a[mid] == 1){
            int ans = findIndex(a, l, mid - 1);
            return ans == -1 ? mid : ans;
        } else {
            return findIndex(a, mid + 1, h);
        }
    }
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = -1, max = Integer.MAX_VALUE;
        for(int i = 0; i < mat.length; i++){
            Arrays.sort(mat[i]);
            int index = findIndex(mat[i], 0, mat[i].length - 1);
            if(max > index && index != -1){
                row = i;
                max = index;
            }
        }
        if  (row == -1) return new int[] {0, 0};
        return new int[] {row, mat[0].length - max};
    }
}