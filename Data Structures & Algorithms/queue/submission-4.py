class Node:
    def __init__(self, val, next=None, prev=None):
        self.prev = prev
        self.next = next
        self.val = val
class Deque:
    
    def __init__(self):
        self.head, self.tail = Node(-1), Node(-1)
        (self.head).next = self.tail
        (self.tail).prev = self.head

    def isEmpty(self) -> bool:
        return self.head.next is self.tail

    def append(self, value: int) -> None:
        # create a new node
        # load it with the directions
        newNode = Node(value, self.tail, (self.tail).prev)

        # the next of tails prev to new node
        previous = (self.tail).prev
        previous.next = newNode

        # finish by changing the prev to the new node
        (self.tail).prev = newNode
        

    def appendleft(self, value: int) -> None:
        # create a new node
        # load it with the directions
        newNode = Node(value, (self.head).next, self.head)

        # the prev of heads next to new node
        former = (self.head).next
        former.prev = newNode

        # finish by changing the next to the new node
        (self.head).next = newNode
        

    def pop(self) -> int:
        # Run is Empty at start and return -1 if so
        if self.isEmpty():
            return -1

        eliminate = (self.tail).prev
        # After simply replace the prev of tail with that of target nodes prev
        (self.tail).prev = eliminate.prev
        # finally use that very same prev to reference next to tail
        (eliminate.prev).next = self.tail

        return eliminate.val

    def popleft(self) -> int:
        # Run is Empty at start and return -1 if so
        if self.isEmpty():
            return -1

        eliminate = (self.head).next
        # After simply replace the next of head with that of target nodes next
        (self.head).next = eliminate.next
        # finally use that very same nect to reference prev to head
        (eliminate.next).prev = self.head

        return eliminate.val
        
