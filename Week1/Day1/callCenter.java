/*
CLASS Customer
    FIELDS
        name, priority (emergency/normal)
    
    CONSTRUCTOR(name, priority)
        initialize fields

CLASS CallCenter
    PRIVATE FIELDS
        Queue<Customer> emergencyQueue
        Queue<Customer> normalQueue
    
    METHOD addCustomer(Customer)
        IF customer.priority is emergency
            ADD to emergencyQueue
        ELSE
            ADD to normalQueue
    
    METHOD serveNextCustomer()
        IF emergencyQueue not empty
            SERVE from emergencyQueue
        ELSE IF normalQueue not empty
            SERVE from normalQueue
        ELSE
            DISPLAY "No customers waiting"

MAIN CLASS
    CREATE CallCenter object
    ADD customers with different priorities
    TEST serving sequence
*/