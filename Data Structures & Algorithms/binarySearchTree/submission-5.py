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
        # If statement to check if root is empty
        if self.root is None:
            # change the key and value of root
            self.root = Node(key, val)
            # return to not hit the rest of function
            return

        # use a reference to traverese
        reference = self.root

        parent = None

        # use a loop to traverse to a empty node
        while reference is not None:
            # if equal then overwite
            if key == reference.key:
                reference.val = val
                return
            # save parent before moving
            parent = reference
            # use if else to check if insert is less than or more than root (prev node)
            if key < reference.key:
                reference = reference.left
            elif key > reference.key:
                reference = reference.right

        # Now parent points to the last valid node
        if key < parent.key:
            parent.left = Node(key, val)
        else:
            parent.right = Node(key, val)

    def get(self, key: int) -> int:
        # If statement to check if root is empty
        if self.root is None:
            return -1
        # use a reference to traverese
        reference = self.root
        # simarly to insert traverse the map
        while reference is not None:
            # if key is equal then return value
            if key == reference.key:
                return reference.val
            # use less and greater key comparisons
            if key < reference.key:
                reference = reference.left
            elif key > reference.key:
                reference = reference.right
        # if we reach none then return -1
        return -1

    def findMin(self, root: Node) -> Node:
        # If statement to check if root is empty
        if root is None:
            return None
        # Use a reference to traverese
        reference = root
        # similar to the get() logic
        while reference.left is not None:
            # although we instead check the left node each time to see if its empty
            reference = reference.left
        # when reach the last non empty left we then return it
        return reference

    def getMin(self) -> int:
        res = self.findMin(self.root)
        return res.val if res is not None else -1

    def getMax(self) -> int:
        # If statement to check if root is empty
        if self.root is None:
            return -1
        # Use a reference to traverese
        reference = self.root
        # similar to the get() logic
        while reference.right is not None:
            # although we instead check the left node each time to see if its empty
            reference = reference.right
        # when reach the last non empty left we then return it
        return reference.val

    def removeHelper(self, key: int, node: Node) -> Node:
        if node is None:
            return None
        # recursive traversal to the target
        if node.key > key:
            node.left = self.removeHelper(key, node.left)
        elif node.key < key:
            node.right = self.removeHelper(key, node.right)
        else:
            # if statment checking if left is empty then return right
            if node.left is None:
                return node.right
            # elif statement checking if right is empty then return left
            elif node.right is None:
                return node.left
            # else both are present meaning we need to use getMin()
            else:
                minNode = self.findMin(node.right)
                node.key = minNode.key
                node.val = minNode.val
                node.right = self.removeHelper(minNode.key, node.right)
        return node

    def remove(self, key: int) -> None:
        # If statement to check if root is empty
        if self.root is None:
            return
        self.root = self.removeHelper(key, self.root)

    def recursiveHelper(self, node, res: List[int]) -> List[int]:
        # if the current node is empty return List as is
        if node is None:
            return res

        # dig deeper down the left
        # make res equal result of left recursive dive
        res = self.recursiveHelper(node.left, res)

        # add the current value to the res list
        res.append(node.key)

        # dig deeper down the right
        # make res equal result of right recursive dive
        res = self.recursiveHelper(node.right, res)

        # return
        return res

    def getInorderKeys(self) -> List[int]:
        # If statement to check if root is empty
        if self.root is None:
            return []
        # empty list
        res = []
        # need a recursive function
        res = self.recursiveHelper(self.root, res)

        return res
