/*
    PATTERN : Binary Search Max(min) or Min(max)
    TIME COMPLEXITY
    ===============
    O(N log N + N log (max(arr) - min(arr))

    KEY POINTS
    ==========
    1. We have to place all k cows such that we have to return minimum difference b/w cows, try with possible configurations
       and need to return maximum of all configurations.
    2. Sorted the array because we need minimum difference between two cows so it will be easy
    3. First we will start with min possible distance is 1, 2, 3 and so on i.e we will place cows if the difference between prev
       and present cow is less than or equal to selected min possible distance.
    4. We will select min possible distance until we are not able to place all k cows, because if one value is not able to place k ccows then
       number greater than that will never able to place all k cows.
    EX
    ====
    Give array = [0, 3, 4, 10, 7, 9], k = 4
    Sorted array = [0, 3, 4, 7, 9, 10]
    Min possible distance means we can place cows so that distance b/w two cows can be >= selected min poss dist.
    if min possbile distance = 1  [0,         3,        4,        7,        9,        10] Min dis b/w cows = 1
                                   c1,<--3-->c2, <--1-->c3,<--3-->c4
    if min possbile distance = 2  [0,         3,        4,        7,        9,        10] Min dis b/w cows = 2
                                   c1,<--3-->c2, <------3-------->c3,<--2-->c4            (We not placed if dist is 1 because min poss
                                                                                            dist is 2)
    if min possbile distance = 3  [0,         3,        4,        7,        9,        10] Min dis b/w cows = 3
                                  c1,<--3-->c2, <------3-------->c3,<--------3-------->c4
    if min possbile distance = 4  [0,         3,        4,        7,        9,        10] Min dis b/w cows = 3
                                  c1,<--------4-------->c2, <------5------->c3             (We stop here because we are not able to
                                                                                            place all k cows)
    5. So the range we can check is from (1, to max(arr) - min(arr))
 */


import java.util.Arrays;
public class AggressiveCows {
    public static boolean iSCowsPlaced(int[] a, int k, int dist){
        int cows = 1, prevCow = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i] - a[prevCow] >= dist){
                prevCow = i;
                cows++;
            }
            if(cows == k) return true;
        }
        return false;
    }
    public static int findMaxPossible(int[] a, int l, int h, int k){
        if(l > h) return -1;
        int mid = l +(h - l)/2;
        if(iSCowsPlaced(a, k, mid)){
            int ans = findMaxPossible(a, mid + 1, h, k);
            return ans == -1 ? mid : ans;
        } else {
            return findMaxPossible(a, l, mid - 1, k);
        }
    }
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        return findMaxPossible(stalls, 1, stalls[stalls.length - 1] - stalls[0], k);
    }
}