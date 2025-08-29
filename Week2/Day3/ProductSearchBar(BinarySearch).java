/*Function binarySearch(array, target)
    left = 0, right = array.length-1
    while left <= right
        mid = (left + right) / 2
        if array[mid] == target → return true
        else if array[mid] < target → left = mid+1
        else → right = mid-1
    return false

Main
    products = ["AirPods","Backpack","Camera","Laptop","Shoes","Smartphone","Watch"]
    Search "Laptop" → found
    Search "Headphones" → not found
*/