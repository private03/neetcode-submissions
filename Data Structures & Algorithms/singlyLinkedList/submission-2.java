class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
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
        // Use a LN object to traverse the LL
        ListNode traverse = head.next;
        // if the head.next is empty then the List is entirely empty.
        if (traverse == null) return -1;
        // create a iter
        int iter = 0;
        // We are going to traverse until we reach the index or we find a empty node
        while (traverse != null) {
            if (iter++ == index) return traverse.val;
            traverse = traverse.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        // create new node
        ListNode newNode = new ListNode (val, head.next);
        // if the head node (dummy) still has the tail node on it then we need to designate the the addition as a tail
        if (head == tail) tail = newNode; 
        // finally connect (dummy) to new head
        head.next = newNode;
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode (val);
        tail.next = newNode;
        tail = tail.next;
    }

    public boolean remove(int index) {
        // Use a LN object to traverse the LL
        ListNode traverse = head;
        // if the head.next is empty then the List is entirely empty.
        if (traverse == null) return false;
        // check if index is valid by using get;
        if (this.get(index) == -1) return false;
        // create a iter
        int iter = 0;
        //loop through making sure the node isnt empty
        while(iter++ < index && traverse != null) {
             // search for the the index before the target
             traverse = traverse.next; 
        }     
        // make node from target
        ListNode removal = traverse.next;
        // check if it is a tail node;
        if(removal == tail) tail = traverse;
        // skip over the target to its next
        traverse.next = removal.next; 
        // return
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = this.head.next;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
