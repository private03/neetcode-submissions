class DynamicArray:
    
    def __init__(self, capacity: int):
        self.size = 0
        self.capacity = capacity
        self.array = [0] * self.capacity


    def get(self, i: int) -> int:
        # check that the int is less than the size
        if i >= self.size:
            # if so then return -1
            return -1
        # standard return of accessed array
        return self.array[i]


    def set(self, i: int, n: int) -> None:
        # check that the int is less than the size
        if i >= self.size:
            # if so then return -1
            return -1
        # change the element in index space
        self.array[i] = n


    def pushback(self, n: int) -> None:
        # check if the size has hit the capacity
        if self.size == self.capacity:
            # if so the resize()
            self.resize()

        # place the element in index using size
        self.array[self.size] = n
        
        # increase size 
        self.size += 1


    def popback(self) -> int:
        # place the element in index using size
        res = self.array[self.size - 1]
        # decrease size 
        self.size -= 1

        return res
 

    def resize(self) -> None:
        self.capacity  = (self.capacity * 2)
        newArray = [0] * self.capacity
        for i in range(self.size):
            newArray[i] = self.array[i]
        self.array = newArray


    def getSize(self) -> int:
        return self.size
        
    
    def getCapacity(self) -> int:
        return self.capacity
