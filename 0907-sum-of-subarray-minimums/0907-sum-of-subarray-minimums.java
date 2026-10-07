class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Previous strictly smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Next smaller or equal element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}