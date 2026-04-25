class DynamicArray {
    // Requires: 3 Attributes
        // One to manage Size
        // One to manage Capacity
        // One to keep up with a array;
        int size;
        int capacity;
        int[] arr;

    public DynamicArray(int capacity) {
        // Initialize the attributes
        size = 0;
        this.capacity = capacity;
        arr = new int [capacity]; 
    }

    public int get(int i) {
        // Two situations:
            // Array is empty
            // looking for position beyond the size
        if (size == 0) return -1;
        if (i >= size) return -1;
        return arr[i];
        // Other wise simply grab it from the static array amd return

    }

    public void set(int i, int n) {
         // Two situations:
            // Array is empty
            // looking for position beyond the size
        if (size == 0) return;
        if (i >= size) return;

        arr[i] = n;
        // Other wise simply grab it from the static array amd return
    }

    public void pushback(int n) {
        // Check if the size is equal to the capcity/
            // if it is then we resize()
        if(size == capacity) this.resize();
        // else we use the place n and iterate size
        arr[size++] = n;
    }

    public int popback() {
        // Two situations:
            // Array is empty
        if (size == 0) return -1;
        return arr[--size];
    }

    private void resize() {
        // double capacity
        capacity = capacity * 2;
        // Create one old arr
        // make the old arr reference the class arr;
        int[] oldArr = arr;
        // Create one new arr
        int[] newArr = new int[capacity];
        // for loop the old arr to fill the new
        for(int i = 0; i < size; i++) newArr[i] = oldArr[i];
        arr = newArr;
        // finally make the class arr refence the new arr
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
