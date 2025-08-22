/*
    It can be optimized using DP.
    Below code is came TLE on leetcode
    TIME COMPLEXITY
    ==============
    O(N · 2^N)
    SPACE COMPLEXITY
    =================
    O(N) (recursion stack) + O(N) (StringBuilder) = O(N)
 */
class Solution {
    public boolean compute(String s, StringBuilder str, List<String> dict){
        boolean flag = false;
        if(s.length() < str.length()) return false;
        if(s.length() == str.length() && s.equals(str.toString())) return true;
        if(!s.startsWith(str.toString())) return false;
        for(int i = 0; i < dict.size(); i++){
            str.append(dict.get(i));
            flag = compute(s, str, dict);
            if(flag) return flag;
            str.delete(str.length() - dict.get(i).length(), str.length());
        }
        return flag;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return compute(s, new StringBuilder(), wordDict);
    }
}