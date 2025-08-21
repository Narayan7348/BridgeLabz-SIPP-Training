/*
CLASS Customer
    FIELDS
        id, name, address, phoneNumber
    
    METHODS
        placeOrder(Restaurant, List<MenuItem>)
        trackOrder(Order)

CLASS Restaurant
    FIELDS
        id, name, menu, rating
    
    METHODS
        acceptOrder(Order)
        updateOrderStatus(Order)

CLASS DeliveryBoy
    FIELDS
        id, name, currentLocation, status
    
    METHODS
        acceptDelivery(Order)
        updateLocation(Location)
        completeDelivery(Order)

CLASS Order
    FIELDS
        Customer customer
        Restaurant restaurant
        DeliveryBoy deliveryBoy
        List<MenuItem> items
        OrderStatus status
        
    METHODS
        calculateTotal()
        updateStatus(OrderStatus)
        assignDeliveryBoy(DeliveryBoy)
*/