class DynamicArray {
    int size;
    int capacity;
    int[] arr;

    public DynamicArray(int capacity) {
        size = 0;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int get(int i) {
        // if the array is empty
        if(size == 0) return -1;
        // if it goes over the current size
        if(i >= size) return -1;
        return arr[i];
    }

    public void set(int i, int n) {
         // if the array is empty
        if(size == 0) return;
        // if it goes over the current size
        if(i >= size) return;
        arr[i] = n;
    }

    public void pushback(int n) {
        // check if the array has hit capacity then run resize;
        if(size == capacity) this.resize();
        // use the size to dicate where in the array to place element and increase size
        arr[size++] = n;
    }

    public int popback() {
        if(size == 0) return -1;
        return arr[--size];
    }

    private void resize() {
        capacity = capacity * 2;

        // create 2 arrays: New and Old
        int[] oldArray = arr;
        // copy current arr into old and then intialize new with the new capacity
        int[] newArray = new int[capacity];
        // loop olds elements into new
        for(int i = 0; i < oldArray.length; i++) newArray[i] = oldArray[i];
        // reference new with current arr
        arr = newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
