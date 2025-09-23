/*
    We maintain elements in descending order.
 */
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> d = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            if(!d.isEmpty() && d.peekFirst() <= i - k) d.removeFirst();
            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i])d.removeLast();
            d.addLast(i);
            if(i >= k - 1) res[i - k + 1] = nums[d.peekFirst()];
        }
        return res;
    }
}