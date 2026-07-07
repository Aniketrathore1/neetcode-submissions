

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Available room numbers
        PriorityQueue<Integer> available = new PriorityQueue<>();

        // {endTime, roomNumber}
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        int[] count = new int[n];

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];

            // Free all rooms that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } else {
                long[] curr = busy.poll();

                long finishTime = curr[0];
                int room = (int) curr[1];

                count[room]++;

                long duration = end - start;
                busy.offer(new long[]{finishTime + duration, room});
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}