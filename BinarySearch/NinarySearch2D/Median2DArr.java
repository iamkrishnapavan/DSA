/*
    Here the intution is that median is middle element.
    So we will find the place of middle element i.e (m*n)/2
    We will use binary search on answers with search space (1, max(arr))
    During search we will compute count of the elements which are less than given element of search space
    If count of smaller elements is gretaer than mid position then that value is median.
    EX
    ======
    [[1, 5, 7, 9, 11],
     [2, 3, 4, 5, 10]
     [9, 10, 12, 14 , 16]]

     Search Space                      = 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
     count of ele <= search space ele  = 1, 2, 3, 4, 6, 6, 7, 7, 9, 11, 12, 13, 13, 14, 14, 15

 */

import java.util.ArrayList;

public class Median2DArr
{
    public static int computeMedian(ArrayList<ArrayList<Integer>> a, int l, int h, int k){
        if(l > h) return l;
        int mid = l + (h - l)/2;
        int res = findSmallCount(a, mid);
        if(res <= k){
            return computeMedian(a, mid + 1, h, k);
        } else {
            return computeMedian(a, l, mid - 1, k);
        }
    }
    public static int returnCount(ArrayList<Integer> a, int l, int h, int ele){
        if(l > h) return l;
        int mid = l + (h - l)/2;
        if(a.get(mid) > ele) return returnCount(a, l, mid - 1, ele);
        else return returnCount(a, mid + 1, h, ele);
    }
    public static int findSmallCount(ArrayList<ArrayList<Integer>>a, int ele){
        int c = 0;
        for(int i = 0; i < a.size(); i++){
            c += returnCount(a.get(i), 0, a.get(i).size() - 1, ele);
        }
        return c;
    }
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
    {
        int l = Integer.MAX_VALUE, h = Integer.MIN_VALUE, n = matrix.size(), m = matrix.get(0).size();
        for(int i = 0; i < n; i++){
            l = Math.min(l, matrix.get(i).get(0));
            h = Math.max(h, matrix.get(i).get(m - 1));
        }
        return computeMedian(matrix, l, h, (n*m) / 2);
    }
}