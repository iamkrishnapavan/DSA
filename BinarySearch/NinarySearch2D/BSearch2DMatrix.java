class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        int i = 0, j = a[0].length - 1;
        while(j >= 0 && i < a.length){
            while(j >= 0 && a[i][j] >= target){
                if(a[i][j] > target) j--;
                else if(a[i][j] == target) return true;
            }
            while(i < a.length && j >= 0 && a[i][j] <= target){
                if(a[i][j] < target) i++;
                else if(a[i][j] == target) return true;
            }
        }
        return false;
    }
}