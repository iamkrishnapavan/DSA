class Solution {
    public long subArrayRanges(int[] nums) {
        int[] nse = new int[nums.length];
        int[] pse = new int[nums.length];
        int[] nge = new int[nums.length];
        int[] pge = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        long ans = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            while(!s.isEmpty() && nums[s.peek()] > nums[i]) s.pop();
            pse[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]) s.pop();
            nse[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i = 0; i < nums.length; i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i]) s.pop();
            pge[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]) s.pop();
            nge[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        for(int i = 0; i < nums.length; i++){
            long left = i - pge[i];
            long right = nge[i] - i;
            long sum = 0;
            sum = nums[i] * left * right;

            left = i - pse[i];
            right = nse[i] - i;
            sum = sum - (nums[i] * left * right);
            ans += sum;
        }
        return ans;
    }
}