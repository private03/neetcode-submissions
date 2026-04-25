class Pair {
    int key;
    int value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class HashTable {
    Pair[] map;
    int size;
    int capacity;

    public HashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new Pair[capacity];
    }

    public void insert(int key, int value) {
        int index = key % this.capacity;

        while(true) {
            if(this.map[index] == null) {
                this.map[index] = new Pair(key, value);
                this.size += 1;
                if(this.size == (this.capacity / 2))
                {
                    this.resize();
                }
                return;
            } else if (this.map[index].key == key) {
                this.map[index].value = value;
                return;
            }
            index += 1;
            index = index % this.capacity;
        }
        
    }

    public int get(int key) {
        int index = key % this.capacity;
        while(this.map[index] != null) {
            if(this.map[index].key == key) {
                return this.map[index].value;
            }
            index += 1;
            index = index % this.capacity;
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = key % this.capacity;
        while(this.map[index] != null)
        {
            if(this.map[index].key == key)
            {
                this.map[index] = null;
                this.size -= 1;
                return true;
            }
            index += 1;
            index = index % this.capacity;
        }

        return false;
    }

    public int getSize() {
        return this.size;

    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        this.capacity = 2 * this.capacity;
        Pair[] newMap = new Pair[this.capacity];

        Pair[] oldMap = this.map;
        this.map = newMap;
        this.size = 0;
        for (Pair p: oldMap) {
            if (p != null) {
                this.insert(p.key, p.value);
            }
        }
    }
}
