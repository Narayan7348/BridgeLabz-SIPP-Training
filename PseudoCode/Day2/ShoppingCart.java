/*
CLASS Item<T>
    FIELDS
        id, name, price, quantity
    
    GENERIC METHOD calculateTotal()
        RETURN price * quantity

CLASS ShoppingCart<T extends Item>
    PRIVATE FIELD
        List<T> items
    
    METHOD addItem(T item)
        ADD to list
    
    METHOD removeItem(T item)
        REMOVE from list
    
    METHOD calculateTotalPrice()
        USE stream to sum all item totals
*/