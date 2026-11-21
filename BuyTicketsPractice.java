import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BuyTicketsPractice {

    /**
     * Your class to complete for LeetCode 2073: Time Needed to Buy Tickets.
     * - tickets[i] is how many tickets person i wants to buy.
     * - Each person takes 1 second to buy 1 ticket.
     * - If a person still needs tickets after buying 1, they go to the back of the line.
     * - Return the total time (in seconds) until person at index 'k' has all their tickets.
     */
    static class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            @SuppressWarnings("unused")
            Queue<Integer> queue = new ArrayDeque<>();

            // TODO: Implement your queue simulation logic here:
            // Hint: Store person indices (0 to tickets.length - 1) in the queue.
            // Each second:
            //   1. Poll the person at the front of the line and increment elapsed time.
            //   2. Decrement that person's remaining tickets.
            //   3. If it's person k and they now have 0 tickets left, return the elapsed time.
            //   4. Otherwise, if they still have tickets left (> 0), offer their index back to the queue.
            throw new UnsupportedOperationException("Implement timeRequiredToBuy(int[], int) first!");
        }
    }

    /**
     * Helper class to verify test outputs cleanly.
     */
    static class TestRunner {
        private int passed = 0;
        private int failed = 0;

        void check(String testName, int actual, int expected) {
            if (actual == expected) {
                passed++;
                System.out.println("[PASS] " + testName + " -> got " + actual);
            } else {
                failed++;
                System.out.println("[FAIL] " + testName + " -> expected " + expected + ", but got " + actual);
            }
        }

        void printSummary() {
            System.out.println("\nResults: " + passed + " passed, " + failed + " failed.");
        }
    }

    /**
     * Helper class for inspecting queue indices and remaining tickets during debugging.
     */
    static class QueueInspector {
        static void printStep(int second, Queue<Integer> q, int[] remainingTickets) {
            System.out.printf("  [sec=%2d] queueIndices=%s | remaining=%s%n",
                    second, q, Arrays.toString(remainingTickets));
        }
    }

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        Solution sol = new Solution();

        // LeetCode Example 1: tickets = [2, 3, 2], k = 2 -> expected 6
        runner.check("Example 1: [2, 3, 2], k=2",
                sol.timeRequiredToBuy(new int[]{2, 3, 2}, 2), 6);

        // LeetCode Example 2: tickets = [5, 1, 1, 1], k = 0 -> expected 8
        runner.check("Example 2: [5, 1, 1, 1], k=0",
                sol.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0), 8);

        // Single person edge case: tickets = [4], k = 0 -> expected 4
        runner.check("Single person: [4], k=0",
                sol.timeRequiredToBuy(new int[]{4}, 0), 4);

        runner.printSummary();
    }
}