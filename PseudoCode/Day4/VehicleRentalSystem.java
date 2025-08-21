/* 
INTERFACE Rentable
    METHOD rent()
    METHOD returnVehicle()

ABSTRACT CLASS Vehicle IMPLEMENTS Rentable
    VARIABLES: model, rentPrice

CLASS Car EXTENDS Vehicle
    METHOD rent()
        PRINT "Car rented"
    METHOD returnVehicle()
        PRINT "Car returned"

CLASS Bike EXTENDS Vehicle
    METHOD rent()
        PRINT "Bike rented"
    METHOD returnVehicle()
        PRINT "Bike returned"

CLASS VehicleFactory
    METHOD getVehicle(type)
        IF type == "Car" RETURN new Car
        IF type == "Bike" RETURN new Bike

MAIN
    CREATE Vehicle using VehicleFactory
    CALL rent()
    CALL returnVehicle()
    */
