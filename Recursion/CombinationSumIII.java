/*
    TIME COMPLEXITY
    ==================
    We are choosing k numbers from the range 1..9 without repetition.
    That’s C(9, k) possible combinations in the worst case.
    For each valid combination, we do O(k) work to build/copy the list.

    So : T=O(C(9,k)⋅k)
    SPACE COMPLEXITY
    ==================
    1. Recursion stack : Depth is O(k) because we can pick at most k numbers.
    2. Result storage → In the worst case, we can store all C(9, k) valid lists, each of size k.
    O(k)(stack)+O(C(9,k)⋅k)(output)

    C(9,k) = 9! / k!⋅(9−k)!
 */
class CombinationSumIII {
    public List<List<Integer>> compute(int k, int n, int ind, List<Integer> l){
        List<List<Integer>> list = new ArrayList<>();
        if(k == 0){
            if(n == 0) list.add(new ArrayList<>(l));
            return list;
        }

        for(int i = ind; i <= 9; i++){
            if(n - i < 0) break;
            l.add(i);
            list.addAll(compute(k - 1 , n - i, i + 1, l));
            l.remove(l.size() - 1);
        }
        return list;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        return compute(k, n, 1, new ArrayList<>());
    }
}