import java.util.Arrays;

public class Day_30_Coin_Problem {

    // Method to find the minimum number of coins to make up the given amount
    public static int coinChange(int[] coins, int amount) {
        // Array to store the minimum number of coins for each amount from 0 to the target amount
        int[] dp = new int[amount + 1];

        // Initialize the dp array with a value higher than any possible solution
        Arrays.fill(dp, amount + 1);

        // Base case: To make up an amount of 0, 0 coins are needed
        dp[0] = 0;

        // Loop over each amount from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            // Try every coin and update the dp array if using that coin results in fewer coins
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If the dp[amount] is still greater than the amount, return -1, meaning it's not possible to make the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Test cases
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Minimum coins needed: " + coinChange(coins1, amount1)); // Output: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Minimum coins needed: " + coinChange(coins2, amount2)); // Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Minimum coins needed: " + coinChange(coins3, amount3)); // Output: 0
    }
}
