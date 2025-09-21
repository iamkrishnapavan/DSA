/*
    Method 1: Precompute PSE & NSE (Previous Smaller Element & Next Smaller Element)

    Steps:
    1. For each bar, find index of previous smaller element (pse[i]).
    2. For each bar, find index of next smaller element (nse[i]).
    3. Area = (nse[i] - pse[i] - 1) * heights[i].
    4. Track maximum area.

    Time Complexity: O(n) (each element pushed & popped at most once).
    Space Complexity: O(n) (for pse[], nse[], and stack).

    Method 2: Single Stack Scan (On-the-fly calculation)

    Steps:
    1. Traverse bars from left to right.
    2. Maintain stack of indices with increasing heights.
    3. When a smaller height is found, pop from stack and calculate area with popped height as smallest.
    4. After loop, process remaining bars in stack.

    Time Complexity: O(n) (each element pushed & popped once).
    Space Complexity: O(n) (stack only).
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] pse = new int[heights.length];
        int[] nse = new int[heights.length];
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            pse[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i = heights.length - 1; i >= 0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            nse[i] = s.isEmpty() ? heights.length : s.peek();
            s.push(i);
        }
        for(int i = 0; i < heights.length; i++){
            int area = (nse[i] - pse[i] - 1) * heights[i];
            res = Math.max(area, res);
        }
        return res;
    }

    public int largestRectangleAreaMethod2(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            while(!s.isEmpty() && heights[s.peek()] > heights[i]){
                int top = s.pop();
                int left = s.isEmpty() ? -1 : s.peek();
                int area = (i - left -1) * heights[top];
                res = Math.max(area, res);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int top = s.pop();
            int left = s.isEmpty() ? -1 : s.peek();
            int area = (heights.length - left - 1) * heights[top];
            res = Math.max(area, res);
        }
        return res;
    }
}