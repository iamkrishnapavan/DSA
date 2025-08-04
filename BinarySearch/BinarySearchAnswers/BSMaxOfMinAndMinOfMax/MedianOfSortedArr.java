class MedianOfSortedArr {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        if(n1 > n2) return findMedianSortedArrays(b, a);
        int l = 0, h = n1;
        int left = (n1 + n2 + 1) / 2;
        while(l <= h){
            int mid1 = l + (h - l)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = b[mid2 - 1];
            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];
            if(l1 <= r2 && l2 <= r1){
                if((n1 + n2) % 2 == 0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                return Math.max(l1, l2);
            }
            else if(l1 > r2) h = mid1 - 1;
            else l = mid1 + 1;
        }
        return 0;
    }
}