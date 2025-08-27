/*// Base class
class Vehicle {
    String vehicleNumber
    Time entryTime

    method calculateFee(exitTime) {
        return 0   // default
    }
}

// Subclass for Car
class Car extends Vehicle {
    override method calculateFee(exitTime) {
        hours = roundUp(exitTime - entryTime)
        fee = 50 + (hours - 1) * 30
        return fee
    }
}

// Subclass for Bike
class Bike extends Vehicle {
    override method calculateFee(exitTime) {
        hours = roundUp(exitTime - entryTime)
        fee = 20 + (hours - 1) * 10
        return fee
    }
}

// Subclass for Truck
class Truck extends Vehicle {
    override method calculateFee(exitTime) {
        hours = roundUp(exitTime - entryTime)
        fee = 100 + (hours - 1) * 50
        return fee
    }
}

// Example run
main() {
    Car car = new Car("KA05AB1234", 10:00 AM)
    Bike bike = new Bike("KA05XY7890", 11:15 AM)
    Truck truck = new Truck("KA09TR5566", 9:30 AM)

    print(car.calculateFee(1:30 PM))   // 125
    print(bike.calculateFee(12:00 PM)) // 30
    print(truck.calculateFee(2:00 PM)) // 325
}
*/