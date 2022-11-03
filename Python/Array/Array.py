import ctypes

class DynamicArray(object):
    '''
    DynamicArray or List
    '''

    def __init__(self):
        self._capacity = 1   # Default
        self.length = 0
        self.Array = self.make_array(self._capacity)
    
    def __init__(self, initial_size):
        self._capacity = initial_size   # Default
        self.length = 0
        self.Array = self.make_array(self._capacity)

    def __len__(self):
        '''
        Number of elements in Array
        '''
        return self.length

    def __getitem__(self, index):
        """Get item at index

        Args:
            index (_type_): _description_
        """
        if  index >= self.length or index < 0:
            raise IndexError()
        return self.Array[index]

    def contains(self, obj):
        for i in range(self.length):
            if self.Array[i] == obj:   return True
        return False

    def indexOf(self, obj):
        for i in range(self.length):
            if self.Array[i] == obj:   return i
        return -1

    def append(self, ele):
        """Add element at last

        Args:
            ele (_type_): _description_
        """
        if self.length+1 >= self._capacity:
            """
            Doubling the array _capacity
            """
            if self._capacity == 0:   self._resize(1)
            else:  self._resize(self._capacity * 2)
        
        self.Array[self.length] = ele
        self.length += 1

    def insertAt(self, index, item):
        """Insert an element at given index

        Args:
            item (_type_): _description_
            index (_type_): _description_
        """
        if  index >= self.length or index < 0:
            raise IndexError()

        if self.length+1 >= self._capacity:
            """
            Doubling the array _capacity
            """
            if self._capacity == 0:   self._resize(1)
            else:  self._resize(self._capacity * 2)

        for i in range(self.length, index, -1):
            self.Array[i] = self.Array[i-1]
        self.Array[index] = item
        self.length += 1

    def delete(self):
        if self.length == 0:
            raise Exception("Array Size is Zero")
        temp = self.Array[self.length-1]
        self.Array[self.length-1] = None
        self.length -= 1
        return temp

    def removeAt(self, rm_index):
        """Remove Element at index rm_index

        Args:
            rm_index (_type_): _description_
        """
        if  rm_index >= self.length or rm_index < 0:
            raise IndexError()

        if self.length == 0:
            raise Exception("Array Size is Zero")

        if rm_index == self.length-1:
            return self.delete()

        temp = self.Array[rm_index]

        for i in range(rm_index, self.length-1):
            self.Array[i] = self.Array[i+1]
        
        self.Array[self.length-1] = None
        self.length -= 1
        return temp

    def _resize(self, new__capacity):
        """Resize the array to twice the current _capacity

        Args:
            new__capacity (_type_): _description_
        """
        temp_arr = self.make_array(new__capacity)

        for x in range(self.length):
            temp_arr[x] = self.Array[x]

        self.Array = temp_arr
        self._capacity = new__capacity

    def make_array(self, cap):
        """Create an Array of given _capacity

        Args:
            cap (_type_): _description_
        """
        return (cap * ctypes.py_object)()

    def __repr__(self):
        if self.length == 0:
            return "[]"
        else:
            res = "["
            for i in range(self.length):
                if i != self.length-1:
                    res += (str(self.Array[i])+", ")
                else:   res += (str(self.Array[i])+"]")
            return res