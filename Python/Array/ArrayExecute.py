from Array import *

arr = DynamicArray(16)
arr.append(1)
arr.append(2)
arr.append(1)

print('Array size: ', len(arr))
print('Print Array: ', arr)
print('Delete item at given(0) index: ', arr.removeAt(0))
print('Delete last item from Array: ', arr.delete())
print('Print Array: ', arr)
print('Insert element at given(0) index: ', arr.insertAt(0, 67))
print('Get element at given(0) index: ', arr.__getitem__(0))
print('Print Array: ', arr)
print('Array contains element (67): ', arr.contains(67))
print('Index of element (67): ', arr.indexOf(67))
