class Node:
    def __init__(self, key, val, left=None, right=None):
        self.key = key
        self.val = val
        self.left = left
        self.right = right

class TreeMap:
    
    def __init__(self):
        self.root = None

    def insert(self, key: int, val: int) -> None:
        # if the root is None
        if self.root is None:
            # make the root the key and val then return
            self.root = Node(key, val)
            return 
        
        # create the new node
        newNode = Node(key, val)

        # create a reference of root
        reference = self.root

        # learn from previous mistake and create previous
        previous = 0

        # traverse using a while loop  
        while reference is not None:
            # if reference equal then make changes then return 
            if reference.key == key:
                reference.val = val
                return
            # update previous
            previous = reference
            # if reference greater than head left
            if reference.key > key:
                reference = reference.left
            # else if reference less than head right
            elif reference.key < key:
                reference = reference.right

        if previous.key > key:
            previous.left = newNode
        else:
            previous.right = newNode

    def get(self, key: int) -> int:
        # check if the root is empty
        if self.root is None:
            return -1
            # if the root is then return -1

        reference = self.root
        # standard loop traversal till we hit none or key
        while reference is not None:
            if reference.key == key:
                return reference.val

            # if reference greater than head left
            if reference.key > key:
                reference = reference.left
            # else if reference less than head right
            elif reference.key < key:
                reference = reference.right

        # return -1 
        return -1

    def findMin(self, node: Node):
        # check if the root is empty
        if node is None:
            return None
            # if the root is then return none

        # simple traversal all the way down left
        while node.left is not None:
            node = node.left
        
        return node
            
    def getMin(self) -> int:
        theNode = self.findMin(self.root)
        return theNode.val if theNode is not None else -1

    def getMax(self) -> int:
        # check if the root is empty
        if self.root is None:
            return -1
            # if the root is then return none

        reference = self.root
        # simple traversal all the way down left
        while reference.right is not None:
            reference = reference.right
        
        return reference.val


    def removeHelper(self, node: Node, key: int) -> Node:
        # check if we are in a empty node
        if node is None:
            # return none
            return None

        # standard recursive traversal part
        # reference is greater = head left
        if node.key > key:
           node.left = self.removeHelper(node.left, key)
        # reference is less = head right
        elif node.key < key:
           node.right = self.removeHelper(node.right, key)
        # if equal then start deletion process
        else:
            # check if left empty then return right
            if node.left is None:
                return node.right
            # check if right empty then return left
            elif node.right is None:
                return node.left
            # both empty then use findMin to fix up 
            else:
                # we need to findMin
                minNode = self.findMin(node.right)
                # replace current nodes details (key, val)
                node.key, node.val = minNode.key, minNode.val
                # we then use remove function on right node
                node.right = self.removeHelper(node.right, minNode.key)
            
        
        # end by returning the node
        return node




    def remove(self, key: int) -> None:
        # check if it is empty
        if self.root is None:
            # return none
            return None

        # run the recursive helper function 
        self.root = self.removeHelper(self.root, key)

    def inorderHelper(self, node: Node, res: List[int]) -> List[int]:
        # check if the current node is empty
        if node is None:
            # if so then return the current list
            return res
            
        # run the helper method on left node
        res = self.inorderHelper(node.left, res)

        # append to current key to the list
        res.append(node.key)

        # run the helper method on right node
        res = self.inorderHelper(node.right, res)

        # return list
        return res

    def getInorderKeys(self) -> List[int]:
        if self.root is None:
            return []

        res = []

        return self.inorderHelper(self.root, res)