class MedianFinder {
    Queue<Integer> pqLeft;
    Queue<Integer> pqRight;

    public MedianFinder() {
        pqLeft = new PriorityQueue<>((a,b) -> b - a); //maxHeap
        pqRight = new PriorityQueue<>(); //minHeap
        
    }
    
    public void addNum(int num) {
        pqLeft.add(num);
        pqRight.add(pqLeft.poll());
        
        if (pqRight.size() > pqLeft.size()) {
            pqLeft.add(pqRight.poll());
        }
    }
    
    public double findMedian() {
        if (pqLeft.size() > pqRight.size()) {
            return pqLeft.peek();
        }

        return ((double) (pqLeft.peek() + pqRight.peek())) / 2;
    }
}
