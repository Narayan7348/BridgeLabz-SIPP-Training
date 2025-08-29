/*Class Student
    Fields: name, marks
    Constructor(name, marks)

Function mergeSort(list)
    if size < 2 → return
    mid = size/2
    left = sublist(0, mid)
    right = sublist(mid, size)
    mergeSort(left), mergeSort(right)
    merge(list, left, right)

Function merge(list, left, right)
    compare first by marks (desc)
    if marks equal → compare name (asc)

Main
    students = [("Amit",92),("Bhavna",92),("Kiran",85),("Dinesh",78),("Charu",92)]
    mergeSort(students)
    print sorted list
*/