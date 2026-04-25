class DynamicArray:
    
    def __init__(self, capacity: int):
        self.size = 0
        self.capacity = capacity
        self.array = [0] * capacity

    def get(self, i: int) -> int:
        return self.array[i]

    def set(self, i: int, n: int) -> None:
        self.array[i] = n


    def pushback(self, n: int) -> None:
        if self.size >= self.capacity:
            self.resize()
        
        self.array[self.size] = n
        self.size += 1

    def popback(self) -> int:
        res = self.array[self.size - 1]
        self.size -= 1
        return res
 

    def resize(self) -> None:
        self.capacity = (self.capacity * 2)
        tempArray = [0] * self.capacity
        for i in range(self.size):
            tempArray[i] = self.array[i]
        self.array = tempArray

    def getSize(self) -> int:
        return self.size
    
    def getCapacity(self) -> int:
        return self.capacity
