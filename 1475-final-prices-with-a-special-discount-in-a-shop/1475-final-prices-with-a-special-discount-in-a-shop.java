class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                prices[index] -= prices[i];
            }

            stack.push(i);
        }

        return prices;
    }
}