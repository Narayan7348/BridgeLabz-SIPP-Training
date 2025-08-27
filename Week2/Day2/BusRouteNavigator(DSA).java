/*// Node class for LinkedList
class BusStop {
    String name
    BusStop next
}

// LinkedList for route
class BusRoute {
    BusStop head

    method insertAfter(targetStop, newStop) {
        find targetStop
        link newStop after targetStop
    }

    method delete(stopName) {
        find stopName and remove it
    }

    method search(stopName) {
        traverse list
        if found → return true
        else → return false
    }

    method displayRoute() {
        print all stops in order
    }
}

// Example run
main() {
    route = new BusRoute()
    route.add("Depot")
    route.add("Main Street")
    route.add("City Mall")
    route.add("Hospital")
    route.add("Airport")

    route.insertAfter("City Mall", "University Stop")
    route.delete("Hospital")
    print(route.search("Airport")) // true
    route.displayRoute()
}
*/
