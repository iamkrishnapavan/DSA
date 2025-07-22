/*
    For sorted array we will use binary search.
    PROBLEM LINK : https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401?leftPanelTabValue=SUBMISSION
 */
public class Solution {
    public static int[] findFloorceilUsingBsearch(int[] a, int l, int h, int x){
        if(l > h){
            l = l >= a.length ? -1 : a[l];
            h = h < 0 ? -1 : a[h];
            return new int[] {h, l};
        }
        int mid = l + (h - l)/2;
        if(a[mid] == x) return new int[] {a[mid], a[mid]};
        else if(a[mid] < x) return findFloorceilUsingBsearch(a, mid + 1, h, x);
        else return findFloorceilUsingBsearch(a, l, mid - 1, x);
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        return findFloorceilUsingBsearch(a, 0, n - 1, x);
    }

}