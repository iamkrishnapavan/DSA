/*
    If we use below bethod at each recursion call it will give one subset so we are adding the subset into our list.
    TIME COMPLEXITY
    ==================
    O(2^N *N + N LOG N)

    SPACE COMPLEXITY
    ==================
    O(2^N * K) where 2^N is no of subsets and k is avg length of each subset
    O(N) where N is for recursion stack.
 */
class Solution {
    public List<List<Integer>> compute(int[] a, int ind, List<Integer> l){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(l));
        if(ind == a.length){
            return list;
        }
        for(int i = ind; i < a.length; i++){
            if(i == ind || a[i] != a[i - 1]){
                l.add(a[i]);
                list.addAll(compute(a, i + 1, l));
                l.remove(l.size() - 1);
            }
        }
        return list;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return compute(nums, 0, new ArrayList<>());
    }
}