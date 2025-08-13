class Solution {
    public List<List<Integer>> compute(int[] a, int x, int ind, List<Integer> l, int sum){
        List<List<Integer>> list = new ArrayList<>();
        if(sum == x){
            list.add(new ArrayList<>(l));
            return list;
        }
        if(sum > x || ind == a.length) return list;

        for(int i = ind; i < a.length; i++){
            l.add(a[i]);
            list.addAll(compute(a, x, i, l, sum + a[i]));
            l.remove(l.size() - 1);
        }
        return list;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return compute(candidates, target, 0, new ArrayList<>(), 0);
    }
}