/*
    We can also generate power set using bit manipulation method.
 */
class Subset {
    public List<List<Integer>> generate(int[] nums, List<Integer> list, int ind){
        List<List<Integer>> l = new ArrayList<>();
        if(ind == nums.length){
            l.add(new ArrayList<Integer>(list));
            return l;
        }
        l.addAll(generate(nums, list, ind + 1));

        list.add(nums[ind]);
        l.addAll(generate(nums, list, ind + 1));
        list.remove(list.size() - 1);

        return l;

    }
    public List<List<Integer>> subsets(int[] nums) {
        return generate(nums, new ArrayList<>(), 0);
    }
}