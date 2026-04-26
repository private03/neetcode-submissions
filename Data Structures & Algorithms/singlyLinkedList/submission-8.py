class Node:
    def __init__(self, val, node_next=None):
        self.val = val
        self.node_next = node_next

class LinkedList:
    
    def __init__(self):
        self.head = Node(-1)
        self.tail = self.head 

    
    def get(self, index: int) -> int:
        if self.head == self.tail:
            return -1
        temp = self.head.node_next
        for i in range(index):
            temp = temp.node_next
            if temp is None:
                return -1
        return temp.val
        

    def insertHead(self, val: int) -> None:
        newHead = Node(val, self.head.node_next)
        self.head.node_next = newHead
        if self.head == self.tail:
            self.tail = newHead
        

    def insertTail(self, val: int) -> None:
        newTail = Node(val, self.tail.node_next)
        self.tail.node_next = newTail
        self.tail = newTail

        

    def remove(self, index: int) -> bool:
        if self.head == self.tail:
            return False
        
        # use a temp for traversal
        temp = self.head

        # dont make the temp the next node on instance
        for i in range(index):
            temp = temp.node_next
            if temp is None:
                return False

        # Index out of bounds
        if temp.node_next is None:  
            return False

        # make the node_next reference to targeted nodes node_next essentialy skipping
        temp.node_next = (temp.node_next).node_next

        # if the nodes_next is empty then we make this the new tail
        if temp.node_next is None:
            self.tail = temp

        return True

    def getValues(self) -> List[int]:
        if self.head == self.tail:
            return []
        # create a list pre traversal
        res = list()

        # continue using temp
        temp = self.head.node_next

        # standard traversal till empty node is hit
        while temp is not None:
            res.append(temp.val)
            temp = temp.node_next

        # return list
        return res

        
