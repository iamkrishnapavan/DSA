/*
    This is solved using binart=y search and i used BS because iam checking in the range from 0 to given num m which is sorted.

    TIME COMPLEXITY
    ==================
    O(log m * log n) where log n is for finding power of computation if use exponentioal method
 */
public class FindNthRoot {
    public static int findNthRoot(int n, int m, int l,int h){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        if(Math.pow(mid, n) == m) return mid;
        else if(Math.pow(mid, n) > m) return findNthRoot(n, m, l, mid - 1);
        else return findNthRoot(n, m, mid + 1, h);
    }
    public static int NthRoot(int n, int m) {
        return findNthRoot(n, m, 0, m);
    }
}
