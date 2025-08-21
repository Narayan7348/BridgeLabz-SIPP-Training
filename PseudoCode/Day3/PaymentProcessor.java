/*
CLASS Transaction<T extends Payment>
    FIELDS
        id
        amount
        T paymentMethod
        status
    
    METHODS
        process()
        validate()
        getReceipt()

CLASS UPIPayment implements Payment
    FIELDS
        upiId, bankAccount
    
    METHODS
        validateUPI()
        processPayment()

CLASS CardPayment implements Payment
    FIELDS
        cardNumber, expiryDate, cvv
    
    METHODS
        validateCard()
        processPayment()

CLASS NetBankingPayment implements Payment
    FIELDS
        bankId, accountNumber
    
    METHODS
        validateAccount()
        processPayment()
*/