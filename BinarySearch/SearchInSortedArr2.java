/*
    Here there is an edge case that since it has duplicates then when a[l] and a[m] and a[h] are same values then search in rotated
    sorted arr 1 sol will not work. We need some modification.
    So in that case we will decrease the search space with l + 1 and h - 1, and we dont need to bother that this element will miss
    because we are checking a[mid] == ele if not only other will execute.

    EX :- [1, 0, 1, 1, 1], ele = 0
    TIME COM[LEXITY
    =================
    O(log2n)-> Average
    O(n/2) -> Worst([3,3,3,3,3,1,3,3,3,3,3,3] we will decresase space search until a[l] != a[mid] != a[h]
 */
class Solution {
    public boolean bSearch(int[] a, int l, int h, int x){
        if(l > h) return false;
        int mid = l + (h - l)/2;
        if(a[mid] == x){
            boolean res = bSearch(a, l, mid - 1, x);
            return res ? res : true;
        } else if(a[l] == a[mid] && a[mid] == a[h]){// Decreasing search space
            return bSearch(a, l + 1, h - 1, x);
        }else if(a[l] <= a[mid]){
            if(a[l] != a[mid] && a[l] <= x && a[mid] >= x) return bSearch(a, l, mid - 1, x);
            else return bSearch(a, mid + 1, h, x);
        } else{
            if(a[mid] <= x && a[h] >= x) return bSearch(a, mid + 1, h, x);
            else return bSearch(a, l, mid - 1, x);
        }
    }
    public boolean search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length - 1, target);
    }
}