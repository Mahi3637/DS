import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounterPractice {                                             //933

    /**
     * Your class to complete for LeetCode 933: Number of Recent Calls.
     * Window rule: count pings in the inclusive range [t - 3000, t].
     */
    static class RecentCounter {
        @SuppressWarnings("unused")
        private final Queue<Integer> queue = new ArrayDeque<>();

        public RecentCounter() {
            // Initialization if needed
        }

        public int ping(int t) {
            // TODO: Implement your queue logic here:
            // 1. Add timestamp t to the queue.
            // 2. Remove expired timestamps from the front (older than t - 3000).
            // 3. Return the count of recent calls.
            // 1. Add the new ping timestamp to the back of the queue
            queue.offer(t);

            // 2. Remove expired pings from the front (anything older than t - 3000)
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }

            // 3. Return how many pings remain in the [t - 3000, t] window
            return queue.size();
           // throw new UnsupportedOperationException("Implement ping(int t) first!");
        }
    }

    /**
     * Helper class to run test cases and check expected outputs cleanly.
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
     * Helper class for inspecting queue contents while debugging.
     */
    static class QueueInspector {
        static void printState(String label, Queue<Integer> q) {
            System.out.println("  [" + label + "] size=" + q.size() + ", front=" + q.peek() + ", items=" + q);
        }
    }

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        RecentCounter counter = new RecentCounter();

        // Standard LeetCode example: [1, 100, 3001, 3002]
        runner.check("ping(1) -> range [-2999, 1]", counter.ping(1), 1);
        runner.check("ping(100) -> range [-2900, 100]", counter.ping(100), 2);
        runner.check("ping(3001) -> range [1, 3001]", counter.ping(3001), 3);
        runner.check("ping(3002) -> range [2, 3002]", counter.ping(3002), 3);

        runner.printSummary();
    }
}