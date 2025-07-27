/*
    Peak element means the element is greater than its neighbours(left and right)

    KEY POINTS
    ============
    In else we kept mid because if use mid - 1 the current element would miss because mid might be the peak and in if case we use
    mid + 1 because we already checked a[mid] < a[mid + 1] so mid + 1 might be the peak.
    We are not checking whether mid + 1 <= h because in base condition we wrote l >= h return so mid is always in the range.
 */

class FindPeak {
    public int findPeak(int[] a, int l, int h){
        if(l >= h) return l;
        int mid = l + (h - l)/2;
        if(a[mid] < a[mid + 1]) return findPeak(a, mid + 1, h);
        else return findPeak(a, l, mid);
    }
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }
}