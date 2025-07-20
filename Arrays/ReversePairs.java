/*
    The reverse pairs is solved using merge sort.
    Here the intution is there are two sorted arrays then we will use two pointers for merging.
    Then just before merging we will perform some logic to find the count of reverse pairs.

    some logic means => for each element in left sorted array we will check whether element of right sorted array is less than 2times
    until condition fails and increment the count from mid to that current element and for next element for left array we will
    not iterate again from mid of right we just continue from where it resumes so O(n).

    TIME COMPLEXITY => O(2nlogn)
    =============================
    For dividing the array O(log n)
    For Merging O(n) => O(nlogn)
    And for counting reverse pairs another O(n) => O(2nlogn)

    SPACE COMPLEXITY => O(n)
    =============================
    For merging we use extra array.
 */



class ReversePairs {
    public int mergeSort(int[] a, int l, int h){
        int cnt = 0;
        if(l >= h) return cnt;
        int mid = l + (h - l)/2;
        cnt = mergeSort(a, l, mid);
        cnt += mergeSort(a, mid + 1, h);
        cnt += merge(a, l, mid, h);
        return cnt;
    }

    public int merge(int[] a, int l, int mid, int h){
        int k = mid + 1, low = l;
        ArrayList<Integer> list = new ArrayList<>();
        // Below line is the logic we added.
        int cnt = computeCount(a, l, mid, h);
        while(low <= mid && k <= h){
            if(a[low] <= a[k]) {
                list.add(a[low]);
                low ++;
            }
            else{
                list.add(a[k]);
                k++;
            }
        }
        while(low <= mid){
            list.add(a[low]);
            low++;
        }
        while(k <= h){
            list.add(a[k]);
            k++;
        }
        for(int i = 0; i < list.size(); i++){
            a[l + i] = list.get(i);
        }
        return cnt;
    }
    public int computeCount(int[] a, int l, int m, int h){
        int c = 0, k = m + 1;
        for(int  i = l; i <= m; i++){
            while(k <= h && (long)a[i] > (2L * (long)a[k])){
                k++;
            }
            c += (k - (m + 1));
        }
        return c;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}