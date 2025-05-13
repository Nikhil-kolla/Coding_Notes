/*
LC 1962 - https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
TC - O(log N)
SC - O(N)
 */

public class MinStoneSum {

    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n:piles)
            pq.offer(n);

        while(!pq.isEmpty() && k > 0){
            int curr = pq.poll();
            int remove = (int) Math.ceil(curr/2);
            pq.offer(curr - remove);
            k--;
        }

        int sum = 0;
        while(!pq.isEmpty())
            sum += pq.poll();

        return sum;
    }
}
