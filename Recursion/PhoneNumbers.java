/*
    TME COMPLEXITY
    =================
    O(4^N * N) Where n = digits.length() N is for copying

    SPACE COMPLEXITY
    =================
    Recursion depth = n → O(n) call stack.
    StringBuilder stores intermediate characters → O(n)
    Result list stores up to 4^n strings of length n → O(n * 4^n) output space.

    So, SC = O(N) (auxiliary) + O(N * 4^N) (output).
    O(N) is for stringbuilder, and O(N * 4^N) for all combinations.
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi",
            '5', "jkl", '6', "mno", '7', "pqrs",
            '8', "tuv", '9', "wxyz"
        );

        backtrack(digits, 0, new StringBuilder(), res, map);
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder sb,
                           List<String> res, Map<Character, String> map) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb, res, map);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}
