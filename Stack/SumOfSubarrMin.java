/*
    INTUTION
    ===========
    For each element arr[i], find:
    PSE (Previous Smaller Element): Nearest index to the left with a smaller element.
    NSE (Next Smaller Element): Nearest index to the right with a smaller element.
    Contribution of arr[i] = arr[i] * (distance to PSE) * (distance to NSE).
    Add contributions of all elements.
    Use modulo 1e9+7 to handle large numbers.

    TIME COMPLEXITY: O(N)
    =====================
    Each element pushed/popped once in stack (for PSE + NSE).

    SPACE COMPLEXITY: O(N)
    =======================
    For PSE, NSE arrays, and stack.

    EDGE CASES:
    ===============
    Single element array → answer = that element.
        Example: [5] → 5
    All increasing array → each element contributes to multiple subarrays.
        Example: [1,2,3] → 1 + 1+2 + 1+2+3 = 10
    All equal elements → each element is valid min for multiple subarrays.
        Example: [2,2] → (2 + 2 + 2) = 6
    Large input size (up to 1e5) → must use O(n) stack solution.
    Large numbers in array → need modulo + long for intermediate multiplication.

 */
class SumOfSubarrMin {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n]; // Previous Smaller Element indices
        int[] nse = new int[n]; // Next Smaller Element indices
        Stack<Integer> s = new Stack<>();
        long mod = 1000000007L; // use long to avoid overflow
        long ans = 0;

        // Step 1: Compute Previous Smaller Element (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            pse[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();

        // Step 2: Compute Next Smaller Element (smaller or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nse[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        // Step 3: Calculate contributions
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];   // choices on left
            long right = nse[i] - i;  // choices on right
            ans = (ans + (arr[i] * left % mod * right % mod)) % mod;
        }

        return (int) ans; // safe cast since result < mod
    }
}
