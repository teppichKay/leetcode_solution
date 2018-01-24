// Time complexity: O(logn)  Space: O(n)

class MedianFinder {
  private PriorityQueue<Integer> maxHeap;
  private PriorityQueue<Integer> minHeap;

  /** Initialize your data structure here. **/
  public MedianFinder() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {
    // guarantee the size of two heaps differs at most 1
    maxHeap.offer(num);
    minHeap.offer(maxHeap.poll());
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

  public double findMedian() {
    return maxHeap.size() == minHeap.size() ? (double) (maxHeap.peek() +
      minHeap.peek()) / 2 : maxHeap.peek();
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
