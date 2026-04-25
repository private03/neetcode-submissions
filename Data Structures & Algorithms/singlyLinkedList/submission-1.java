class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
class LinkedList {
    ListNode head;
    ListNode tail;
    int size;
    public LinkedList() {
        head = new ListNode(-1);
        tail = head;
        size = 0;
    }

    public int get(int index) {
        if(size == 0) {
            return -1;
        }
        if(index >= size) {
            return -1;
        }
        ListNode traverse = head;
        for (int i = 0; i < index + 1; i++) {
            traverse = traverse.next;
        }
        return traverse.val;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val, head.next);
        if(head == tail) {
            tail = newNode;
        }
        head.next = newNode;
        size++;
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public boolean remove(int index) {
         if(size == 0) {
            return false;
        }
        if(index >= size) {
            return false;
        }
        ListNode traverse = head;
        for(int i = 0; i < index + 1; i++) { 
            if(i + 1 == index + 1) {
                ListNode removeState = traverse.next;
                if(removeState == tail) {
                    tail = traverse;
                }
                traverse.next = traverse.next.next;
                removeState.next = null;
                size--;
                break;
            }
            traverse = traverse.next;
        }
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        ListNode traverse = head.next;
        
        while(traverse != tail)
        {
            res.add(traverse.val);
            traverse = traverse.next;
        }
        res.add(tail.val);
        return res;
    }
}
