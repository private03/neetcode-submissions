class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0); // dummy to make it 1-indexed
    }

    public int size() {
        return heap.size() - 1; // exclude dummy
    }

    public int peek() {
        return heap.get(1);
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, tmp);
            i /= 2;
        }
    }

    public int pop() {
        if (size() == 0) return -1;
        if (size() == 1) return heap.remove(heap.size() - 1);

        int res = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));

        int i = 1;
        while (2 * i < heap.size()) {
            int left = 2 * i;
            int right = 2 * i + 1;

            int smallest = left;
            if (right < heap.size() && heap.get(right) < heap.get(left)) {
                smallest = right;
            }

            if (heap.get(i) <= heap.get(smallest)) break;

            int tmp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, tmp);

            i = smallest;
        }

        return res;
    }
}

class KthLargest {
    private final int k;
    private final MinHeap heapTree = new MinHeap();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) add(n);
    }

    public int add(int val) {
        heapTree.push(val);
        if (heapTree.size() > k) {
            heapTree.pop(); // drop smallest, keep only k largest
        }
        return heapTree.peek(); // kth largest
    }
}
