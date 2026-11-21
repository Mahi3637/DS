public class UnableToEatLunchPractice {

    /**
     * LeetCode 1700: Number of Students Unable to Eat Lunch.
     * - students[i] is 0 (circular) or 1 (square) for student i in the line.
     * - sandwiches[j] is 0 (circular) or 1 (square) for sandwich j in the stack (index 0 is top).
     * - At each step:
     *     * If the student at the front of the line likes the top sandwich, they take it and leave,
     *       and the sandwich pointer moves to the next sandwich (sandwiches[topIdx]).
     *     * Otherwise, the student goes to the back of the line, and the top sandwich stays.
     * - Stop when no student currently in line wants the top sandwich; return how many students remain.
     */
    static class Solution {
        public int countStudents(int[] students, int[] sandwiches) {                               //1700
            //int n = students.length;

            // Custom circular array queue holding student preferences (0 or 1)
        //     @SuppressWarnings("unused")
        //     int[] queue = new int[n];
        //     @SuppressWarnings("unused")
        //     //int front = 0;
        //     @SuppressWarnings("unused")
        //   //  int rear = 0;
        //     @SuppressWarnings("unused")
        //    // int size = 0;

            // TODO:
            // 1. Copy each student's preference into `queue` using a for loop, updating `rear` and `size`.
            // 2. Track `topIdx = 0` for the current top sandwich in `sandwiches`.
            // 3. Track `rotations = 0` (how many consecutive students went to the back without taking topIdx).
            // 4. While size > 0 and rotations < size:
            //      - Dequeue from `front` (advance front with % n, decrement size).
            //      - If pref == sandwiches[topIdx]:
            //            advance topIdx++, reset rotations = 0.
            //        Else:
            //            enqueue `pref` at `rear` (advance rear with % n, increment size), increment rotations++.
            // 5. Return `size` (number of students unable to eat).

            int n = students.length;
            int m = sandwiches.length;
            int [] q = new int [n];
            int topIdx = 0;
            int rotation = 0;


            for(int i = 0; i< n; i++){
                students[i]= sandwiches[i];
            }

            int queueSize = 0;
            int stackSize = 0;
            int front = 0;
            int rear = 0;
            int idx1 = 0;
            int idx2 = 1;

            for(int j = 0; j<n; j++){
                students[rear] = j;
                rear = rear+1 % n;
                queueSize++;
            }

            while(queueSize >0 && rotation<queueSize){
                int pref = q[front];
                front = front +1 % n;
                queueSize--;
            }

            if(pref == sandwiches[topIdx]){
                topIdx++;
                rotation = 0;
            }
            else{
                q[rear] = pref;
                rear = rear+1 %n;
                queueSize++;
                rotation++;
            }


           // throw new UnsupportedOperationException("Implement countStudents(int[], int[]) first!");
        
        return queueSize;
    }
}

    /**
     * Helper class to verify test results cleanly without built-in assertions.
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
     * Helper class for inspecting queue contents in FIFO order, top sandwich, and rotations.
     */
    static class QueueInspector {
        static void printState(String label, int[] queue, int front, int size, int capacity,
                               int[] sandwiches, int topIdx, int rotations) {
            StringBuilder sb = new StringBuilder();
            sb.append("  [").append(label).append("] queue=[");
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % capacity;
                sb.append(queue[idx]);
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("] (size=").append(size)
              .append(", rotations=").append(rotations)
              .append(", topSandwich=").append(topIdx < sandwiches.length ? sandwiches[topIdx] : "NONE")
              .append(")");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        Solution sol = new Solution();

        // LeetCode Example 1: everyone can eat -> expected 0
        runner.check("Example 1: students=[1,1,0,0], sandwiches=[0,1,0,1]",
                sol.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}), 0);

        // LeetCode Example 2: 3 students left unable to eat -> expected 3
        runner.check("Example 2: students=[1,1,1,0,0,1], sandwiches=[1,0,0,0,1,1]",
                sol.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}), 3);

        // All match immediately -> expected 0
        runner.check("All match: students=[0,1,0], sandwiches=[0,1,0]",
                sol.countStudents(new int[]{0, 1, 0}, new int[]{0, 1, 0}), 0);

        runner.printSummary();
    }
}