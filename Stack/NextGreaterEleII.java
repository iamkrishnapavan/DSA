class NextGreaterEleII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        int n = 2 * nums.length - 1;
        for(int i = n; i >= 0; i--){
            while(!s.isEmpty() && s.peek() <= nums[i % nums.length]) s.pop();
            if(i < nums.length){
                if(!s.isEmpty()) res[i] = s.peek();
                else res[i] = -1;
            }
            s.push(nums[i % nums.length]);
        }
        return res;
    }
}