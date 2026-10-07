class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    // Sum of all subarray minimums
    private long sumMin(int[] nums) {
        int n = nums.length;
        long sum = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Previous smaller
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next smaller or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * left[i] * right[i];
        }

        return sum;
    }

    // Sum of all subarray maximums
    private long sumMax(int[] nums) {
        int n = nums.length;
        long sum = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Previous greater
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next greater or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * left[i] * right[i];
        }

        return sum;
    }
}