/*
    here we are checking in the range 0 to n, since it is in sorted order i used binary search.
 */
class SquareRootOfNum {
    public int root(int x, int l, int h){
        if(l > h) return h;
        int mid = l + (h - l)/2;
        if((long)mid * mid == x) return mid;
        else if((long)mid * mid > x) return root(x, l, mid - 1);
        else return root(x, mid + 1, h);
    }
    public int mySqrt(int x) {
        return x >=2 ? root(x, 0, x) : x;
    }
}