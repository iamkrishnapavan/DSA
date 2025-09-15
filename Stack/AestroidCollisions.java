/*
    TIME COMPLEXITY : O(N)
    SPACE COMPLEXITY : O(N)
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if(!s.isEmpty() && s.peek() > 0 && asteroids[i] < 0){
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < -asteroids[i]) s.pop();
                if(!s.isEmpty() && s.peek() + asteroids[i] == 0) s.pop();
                else if(s.isEmpty() || s.peek() < 0) s.push(asteroids[i]);
            } else {
                s.push(asteroids[i]);
            }
        }
        int[] res = new int[s.size()];
        int n = s.size();
        for(int i = 0; i < n; i++){
            res[n - i - 1] = s.pop();
        }
        return res;
    }
}