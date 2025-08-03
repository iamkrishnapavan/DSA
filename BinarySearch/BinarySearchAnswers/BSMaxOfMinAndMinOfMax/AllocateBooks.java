/*
    TIME COMPLEXITY
    ================
    O(N log(sum - max))
    KEY POINTS
    =============
    Here lower bound is max of arr because if we select pages with small than a book in arr then we never select that
    book.
    Upper bound is sum of all pages in the array.

 */
import java.util.ArrayList;
public class AllocateBooks {
    public static boolean allStdGetBook(ArrayList<Integer> a, int m, int pages){
        int std = 1, s = a.get(0);
        for(int i = 1; i < a.size(); i++){
            if(a.get(i) + s <= pages){
                s += a.get(i);
            } else {
                s = a.get(i);
                std++;
            }
            if(std > m) return false;
        }
        return true;
    }
    public static int minPossiblePages(ArrayList<Integer> a, int l, int h, int m){
        if(l > h) return -1;
        int mid = l +(h - l)/2;
        if(allStdGetBook(a, m, mid)){
            int ans = minPossiblePages(a, l, mid - 1, m);
            return ans == -1 ? mid : ans;
        } else {
            return minPossiblePages(a, mid + 1, h, m);
        }
    }
    public static int[] fimdMaxAndSum(ArrayList<Integer> a){
        int max = Integer.MIN_VALUE, s = 0;
        for(int i = 0; i < a.size(); i++){
            max = Math.max(max, a.get(i));
            s += a.get(i);
        }
        return new int[] {max, s};
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m > arr.size()) return -1;
        int[] a = fimdMaxAndSum(arr);
        return minPossiblePages(arr, a[0], a[1], m);
    }
}