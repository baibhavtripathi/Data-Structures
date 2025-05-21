class DynamicArray:
    def __init__(self):
        self.data = {}
        self.length = 0
    
    def get(self, index):
        return self.data[index]
    
    def push(self, item):
        self.data[self.length] = item
        self.length += 1

        return self.length

    def pop(self):
        if self.length == 0:
            return None

        popped_item = self.data[self.length -1]
        self.data[self.length-1] = None
        self.length -= 1

        return popped_item
    
    def insert(self, index, item):
        if index < 0 or index > self.length:
            return None

        self.length += 1

        for i in range(self.length-1, index-1, -1):
            self.data[i] = self.data[i-1]

        self.data[index] = item

        return self.data

    def remove(self, index):
        if self.length == 0 or index < 0 or index > self.length-1:
            return  None

        deleted_item = self.data[index]

        for i in range(index, self.length-1):
            self.data[i] = self.data[i+1]

        self.data[self.length-1] = None
        self.length -= 1

        return deleted_item

    def print_array(self):
        for value in self.data.values():
            print(value, end = ' ')

if __name__ == "__main__":
    dynamic_array = DynamicArray()
    dynamic_array.push(1)
    dynamic_array.push(2)
    dynamic_array.push(3)
    print('Get 1st index: ', dynamic_array.get(1))
    print('Data: ', dynamic_array.data)
    print('Length: ', dynamic_array.length)
    print('Pop: ', dynamic_array.pop())
    print('Data: ', dynamic_array.data)
    print('Length: ', dynamic_array.length)
    print('Insert: ', dynamic_array.insert(1, 4))
    print('Data: ', dynamic_array.data)
    print('Length: ', dynamic_array.length)
    print('Remove: ', dynamic_array.remove(1)) 
    print('Data: ', dynamic_array.data)
    print('Length: ', dynamic_array.length)
    
    print('Insert: ', dynamic_array.insert(2, 4))
    print('Data: ', dynamic_array.data)
    print('size: ', dynamic_array.length)
    dynamic_array.print_array()
