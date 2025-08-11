/*
    SPACE COMPLEXITY
    =================
    O(2 * N) because we are going to depth of tree until we get string of length 2 * n
    TIME COMPLEXITY
    ================
    O(Catalan * N)
 */
class GenerateParanthesis {
    public List<String> compute(int n, StringBuilder str, int open, int close){
        List<String> list = new ArrayList<>();
        if(2 * n == str.length()){
            if(open == close)
                list.add(str.toString());
            return list;
        }
        str.append('(');
        list.addAll(compute(n, str, open + 1, close));
        str.deleteCharAt(str.length() - 1);

        if(open > close){
            str.append(')');
            list.addAll(compute(n, str, open, close + 1));
            str.deleteCharAt(str.length() - 1);
        }
        return list;
    }
    public List<String> generateParenthesis(int n) {
        return compute(n, new StringBuilder(), 0, 0);
    }
}