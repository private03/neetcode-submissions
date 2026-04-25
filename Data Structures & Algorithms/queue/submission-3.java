class ListNode {
    int val;
    ListNode next; 
    ListNode prev;
    public ListNode(int val) 
    {
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
        if(head == tail) {
            return true;
        }
        return false;
    }

    public void append(int value) {
       ListNode newNode = new ListNode(value, null, tail);
       tail.next = newNode;

       tail = newNode;
    }

    public void appendleft(int value) {
        // new node already has connection to the head and the previous nearest node to head 
        ListNode newNode = new ListNode(value, head.next, head);
        // check if it is empty
        if(this.isEmpty()) {
            // if it is empty the newNode is a tail and head needs to connect
            tail = newNode;
        } else {
            // previous nearest node to the newNode
            head.next.prev = newNode;           
        }
        head.next = newNode;
    }

    public int pop() {
        // check if empty
        if(this.isEmpty()) return -1;
        // if not then reference the removal by the tail
        //ListNode removal = tail;
        int res = tail.val;
        // move the tail to prev ndoe
        tail = tail.prev;
        // null the tails next node 
        tail.next = null;
        // return
        return res;
    }

    public int popleft() {
        // check if empty
        if(this.isEmpty()) return -1;
        // if not then reference the removal by the tail
        ListNode removal = head.next;
        // check if the tail is the next of the head
        if(removal == tail) {
            head.next = null;
            tail = head;
        } else {
            head.next = removal.next;
            removal.next.prev = head;
        }

        return removal.val;
        
    }
}
