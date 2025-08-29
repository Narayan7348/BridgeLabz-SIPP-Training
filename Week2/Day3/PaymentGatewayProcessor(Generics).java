/*Class Transaction<T>
    Field: payment
    Constructor(payment)
    Method processPayment()
        if payment is UPI → print details
        if payment is Card → print details
        if payment is NetBanking → print details

Class UPI
    Fields: upiId, amount, merchantName

Class Card
    Fields: cardNumber, cvv, expiryDate, amount, merchantName

Class NetBanking
    Fields: bankName, accountNumber, amount

Main
    Transaction<UPI> → process
    Transaction<Card> → process
    Transaction<NetBanking> → process
*/