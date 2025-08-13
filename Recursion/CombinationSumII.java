/*
    TIME COMPLEXITY
    ================
    O(2^N * K) where k is for adding subsequence to list
 */
class Solution {
    public List<List<Integer>> compute(int[] a, int x, int ind, List<Integer> l){
        List<List<Integer>> list = new ArrayList<>();
        if(x == 0){
            list.add(new ArrayList<>(l));
            return list;
        }
        if(ind == a.length){
            return list;
        }

        for(int i = ind; i < a.length; i++){
            if(a[i] > x) break;
            if(i == ind || a[i] != a[i - 1]){
                l.add(a[i]);
                list.addAll(compute(a, x - a[i], i + 1, l));
                l.remove(l.size() - 1);
            }
        }
        return list;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return compute(candidates, target, 0, new ArrayList<>());
    }
}