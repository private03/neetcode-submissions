class DynamicArray {
    int size; 
    int capacity;
    int[] arr;

    public DynamicArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public int get(int i) {
        if(this.size == 0) {
            return -1;
        }
        if(i >= this.size) {
            return -1;
        }
        return this.arr[i];

    }

    public void set(int i, int n) {
        if(this.size == 0) {
            return;
        }
        if(i >= this.size) {
            return;
        }

        this.arr[i] = n;

    }

    public void pushback(int n) {
        
        if(this.size == this.capacity) {
            this.resize();
        }
        this.size++;
        this.arr[size - 1] = n;
        
    }

    public int popback() {
        if(this.size == 0) {
            return -1;
        }
        int returning = this.arr[size - 1];
        this.arr[size - 1] = 0;
        this.size--;
        return returning; 

    }

    private void resize() {
        this.capacity = this.capacity * 2;
        int[] oldArr = this.arr;
        int[] newArr = new int[this.capacity];

        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }

        this.arr = newArr;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
