class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this(val, null, null);
    }

    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
class Deque {
    ListNode head;
    ListNode tail;

    public Deque() {
        head = new ListNode(-1);
        tail = head;
    }

    public boolean isEmpty() {
        if(head == tail) return true;
        return false;
    }

    public void append(int value) {
        ListNode newNode = new ListNode(value, null, tail);
        tail.next = newNode;
        tail = newNode;
    }

    public void appendleft(int value) {
        ListNode newNode = new ListNode(value, head.next , head);
        if (this.isEmpty()) {
            tail = newNode;
        } else {
            head.next.prev = newNode;
        }
        head.next = newNode;
    }

    public int pop() {
        if (this.isEmpty()) return -1;
        int res = tail.val;
        tail = tail.prev;
        tail.next = null;
        return res;
    }

    public int popleft() {
        if (this.isEmpty()) return -1;
        int res;
        ListNode removal = head.next;
        if(removal == tail) {
            res = removal.val;
            head.next = null;
            tail = head;
        } else {
            res = removal.val;
            head.next = removal.next;
            removal.next.prev = head;
        }
        return res;
    }
}