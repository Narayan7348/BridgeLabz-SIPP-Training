/* 
CLASS Transaction
    VARIABLE: id, merchantName, amount, date   // date includes month & year

MAIN
    CREATE List<Transaction> transactions

    METHOD generateReport()
        GROUP transactions BY merchantName AND month
        FOR each group
            CALCULATE totalAmount = SUM of all amounts in group
            COUNT totalTransactions
            PRINT merchantName, month, totalAmount, totalTransactions

    TEST:
        ADD sample transactions
        CALL generateReport()
        */
