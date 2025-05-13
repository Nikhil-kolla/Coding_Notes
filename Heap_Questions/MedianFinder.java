/*
LC 295 - https://leetcode.com/problems/find-median-from-data-stream/description/
TC - O(log N)
SC - O(N)
 */
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || num < leftMaxHeap.peek())
            leftMaxHeap.offer(num);
        else
            rightMinHeap.offer(num);

        if(Math.abs(leftMaxHeap.size()-rightMinHeap.size()) > 1)
            rightMinHeap.offer(leftMaxHeap.poll());
        else if(leftMaxHeap.size() < rightMinHeap.size())
            leftMaxHeap.offer(rightMinHeap.poll());
    }

    public double findMedian() {
        if((leftMaxHeap.size() + rightMinHeap.size()) % 2 == 0)
            return (double) ((leftMaxHeap.peek() + rightMinHeap.peek())/2);

        return leftMaxHeap.peek();
    }
}
