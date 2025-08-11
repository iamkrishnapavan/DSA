import java.util.*;

/*
    Time Complexity (TC)
    Let T(n) be the number of valid strings of length n without consecutive '1's.
    This is a classic Fibonacci-like counting problem:
    Number of strings ending with '0' = total valid strings of length n-1 (T(n-1))
    Number of strings ending with '1' = number of strings ending with '0' at n-1 (because you cannot put two '1's consecutively)
    So T(n) = T(n-1) + T(n-2) with base cases T(0)=1, T(1)=2.
    The size of your result list will be approximately O(φ^n), where φ ≈ 1.618 (golden ratio).
    Since you generate all valid strings, your time complexity is O(φ^n).

    Space Complexity (SC)
    The recursion tree depth is n.
    Each recursive call adds a new string of length n to the list.
    Total space to store all results is O(n * φ^n) (because each string has length n and there are about φ^n strings).
    The recursion stack depth is O(n).
    The temporary strings created during recursion have lengths up to n.


 */
// Pure Recursion

public class BinaryStringsNoConsec1 {
    public static List<String> fun(int n, String s){
        List<String> list = new ArrayList<>();
        if(s.length() == n){
            list.add(s);
            return list;
        }
        list.addAll(fun(n, s + '0'));
        if(s.length() == 0 || s.charAt(s.length() -1) != '1'){
            list.addAll(fun(n, s + '1'));
        }
        return list;
    }
    public static List< String > generateString(int N) {
        return fun(N, "");
    }
}

// Backtracking
public class Backtracking {
    public static void backtrack(int n, StringBuilder sb, List<String> res) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        // Always try to add '0'
        sb.append('0');
        backtrack(n, sb, res);
        sb.deleteCharAt(sb.length() - 1);  // backtrack

        // Try to add '1' only if last char is not '1'
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '1') {
            sb.append('1');
            backtrack(n, sb, res);
            sb.deleteCharAt(sb.length() - 1);  // backtrack
        }
    }

