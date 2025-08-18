/*
    TIME COMPLEXITY
    ===================
    O(N * 2^N-1) ====> O(N * 2^N)
    The number of ways to partition a string of length n is O(2^(n-1)) (because between every two characters, you either "cut" or
    "don’t cut").
    So there can be up to 2^(n-1) partitions.

    Checking for palindrome (isPalindrome)::::::::::
    Each check in your code costs O(n) (in worst case substring length).

    SPACE COMPLEXITY
    =====================
    Recursion depth (stack): O(N)
    Auxiliary structures (list building): O(N)
    Result storage:
    The output itself can be very large (all partitions).
    So output space is O(N * 2^N) in the worst case.
    Auxiliary SC (excluding output) = O(N)

    NOTES
    =======
    WIth DP we can optimize Time Complexity
 */


class Solution {
    public List<List<String>> compute(String s, int size, int ind, List<String> l){
        List<List<String>> list = new ArrayList<>();
        if(ind == size){
            list.add(new ArrayList<>(l));
            return list;
        }
        for(int i = ind; i < size; i++){
            if(isPalindrome(s, ind, i)){
                l.add(s.substring(ind , i + 1));
                list.addAll(compute(s, size, i + 1, l));
                l.remove(l.size() - 1);
            }
        }
        return list;
    }

    public boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        return compute(s, s.length(), 0, new ArrayList<>());
    }
}