class DynamicArray:
    def __init__(self, capacity=1):
        self.data = [None] * capacity
        self.size = 0
        self.capacity = capacity

    def get(self, index):
        if index < 0 or index > self.size-1:
            return None
        return self.data[index]

    def push(self, item):
        if self.size == self.capacity:
            self.resize()

        self.data[self.size] = item
        self.size += 1

        return self.size
    
    def resize(self):
        self.capacity *= 2
        new_data = [None] * self.capacity
        for i in range(self.size):
            new_data[i] = self.data[i]
        self.data = new_data

    def pop(self):
        if self.size == 0:
            return None
        
        popped_item = self.data[self.size-1]
        self.data[self.size-1] = None
        self.size -= 1
        
        return popped_item
    
    def insert(self, index, item):
        if index < 0 or index > self.size:
            return None
        
        if self.size == self.capacity:
            self.resize()
        
        for x in range(self.size, index -1, -1):
            self.data[x] = self.data[x-1]
        
        self.data[index] = item
        self.size += 1

        return self.data
        
    def remove(self, index):
        if self.size == 0 or index < 0 or index > self.size-1:
            return None
        
        removed_item = self.data[index]

        for x in range(index, self.size-1):
            self.data[x] = self.data[x+1]

        self.size -= 1
        self.data[self.size] = None

        return removed_item
    
    def print_array(self):
        for x in range(self.size):
            print(self.data[x], end=' ')
        print()



if __name__ == "__main__":
    dynamic_array = DynamicArray()
    dynamic_array.push(1)
    dynamic_array.push(2)
    dynamic_array.push(3)
    print('Get 1st index: ', dynamic_array.get(1))
    print('Data: ', dynamic_array.data)
    print('Length: ', dynamic_array.size)
    print('Pop: ', dynamic_array.pop())
    print('Data: ', dynamic_array.data)
    print('size: ', dynamic_array.size)
    print('Insert: ', dynamic_array.insert(1, 4))
    print('Data: ', dynamic_array.data)
    print('size: ', dynamic_array.size)
    print('Remove: ', dynamic_array.remove(1)) 
    print('Data: ', dynamic_array.data)
    print('size: ', dynamic_array.size)
    dynamic_array.print_array()
    print('Insert: ', dynamic_array.insert(2, 4))
    print('Data: ', dynamic_array.data)
    print('size: ', dynamic_array.size)
    dynamic_array.print_array()

