/*
    We will split array so that we can get k elements from both arrays.
    l = Math.max(0, k - m) because if k > arr2 then for k elements we must need some elements from arr1 to form k
    h = Math.min(k, n) because we want only k elements not all arr elements i.e k = 2 and arr length = 6.
 */
import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        if(n > m) return kthElement(arr2, arr1, m, n, k);
        int l = Math.max(0, k - m), h = Math.min(k, n);
        while(l <= h){
            int mid1 = l + (h - l)/2;
            int mid2 = k - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 - 1 >= 0) l1 = arr1.get(mid1 - 1);
            if(mid2 - 1 >= 0) l2 = arr2.get(mid2 - 1);
            if(mid1 < n) r1 = arr1.get(mid1);
            if(mid2 < m) r2 = arr2.get(mid2);
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            } else if(l1 > r2){
                h = mid1 - 1;
            } else{
                l = mid1 + 1;
            }
        }
        return 0;
    }
}