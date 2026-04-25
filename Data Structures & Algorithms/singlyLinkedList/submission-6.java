class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this(value, null);
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
class LinkedList {
    ListNode head;
    ListNode tail;

    public LinkedList() {
        head = new ListNode(-1);
        tail = head;
    }

    public int get(int index) {
        ListNode traverse = head.next;
        if(traverse == null) return -1;
        int iter = 0;
        while(traverse != null && iter++ != index) traverse = traverse.next;
        return (traverse != null) ?  traverse.value : -1;
    }

    public void insertHead(int val) {
        // create new node;
        ListNode newNode = new ListNode(val, head.next);
        // check if the head is the same as the tail;
        // if so then place the tail as the new (non dummy head)
        if(head == tail) tail = newNode;
        // finally connect the (dummy) head to the actual head
        head.next = newNode;
    }

    public void insertTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        ListNode traverse = head;
        if(traverse.next == null) return false;
        int iter = 0;
        while(traverse != null && iter++ < index) traverse = traverse.next;
        if(traverse == null || traverse.next == null) return false;
        ListNode removal = traverse.next;
        if(removal == tail) tail = traverse;
        traverse.next = removal.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode traverse = head.next;
        while(traverse != null) { 
            res.add(traverse.value);
            traverse = traverse.next;
        }
        return res;
    }
}
