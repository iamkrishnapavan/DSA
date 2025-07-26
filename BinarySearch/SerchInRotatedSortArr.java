/*
    Here i solved by first finding the pivot and then perform binary search.
    But we can solve it using single scan.
 */

//My first code
class Solution {
    public int partition(int[] a, int l, int h){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        if(mid + 1 <= h && a[mid] > a[mid + 1]) return mid;
        if(mid - 1 >= l && a[mid] < a[mid - 1]) return mid - 1;
        if(a[0] < a[mid]) return partition(a, mid + 1, h);
        if(a[0] > a[mid]) return partition(a, l, mid - 1);
        return -1;
    }
    public int bSearch(int[] a, int l, int h, int x){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        if(a[mid] == x) return mid;
        else if(a[mid] < x) return bSearch(a, mid + 1, h, x);
        else return bSearch(a, l, mid - 1, x);
    }
    public int search(int[] nums, int target) {
        int part = partition(nums, 0, nums.length - 1);
        System.out.println(part);
        if(part == -1) return bSearch(nums, 0, nums.length - 1, target);
        else{
            if(nums[0] <= target) return bSearch(nums, 0, part, target);
            else return bSearch(nums, part + 1, nums.length - 1, target);
        }
    }
}

/*
    Below is one scan binary search
 */

class Solution {
    public int bSearch(int[] a, int l, int h, int x){
        if(l > h) return -1;
        int mid = l +(h - l)/2;
        if(a[mid] == x) return mid;
        else if(a[l] <= a[mid]){
            if(a[mid] >=x && a[l] <= x) return bSearch( a, l, mid - 1, x);
            else return bSearch(a , mid + 1, h,  x);
        }
        else{
            if(a[mid] <= x && a[h] >= x) return bSearch(a, mid + 1, h, x);
            else return bSearch(a, l, mid - 1, x);
        }

    }
    public int search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length - 1, target);
    }
}