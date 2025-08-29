/* Abstract Class Room
    Fields: roomNumber, customerName, daysStayed
    Constructor(roomNumber, customerName, daysStayed)
    Abstract Method calculateBill()
    Method printInvoice(type)
        print room type, customer, nights, bill

Class DeluxeRoom extends Room
    rate = 3000
    calculateBill() = rate * daysStayed

Class SuiteRoom extends Room
    rate = 5000
    calculateBill() = rate * daysStayed

Main
    Customer Ravi books Deluxe 3 nights
    Print invoice
    Customer Anita books Suite 2 nights
    Print invoice
*/
