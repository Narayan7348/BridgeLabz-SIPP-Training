 /*CLASS Account
    VARIABLES: accountNumber, balance
    METHOD deposit(amount)
        balance = balance + amount
    METHOD withdraw(amount)
        PRINT "Default withdrawal rule"

CLASS Saving EXTENDS Account
    METHOD withdraw(amount)
        IF balance - amount >= 500
            balance = balance - amount
        ELSE
            PRINT "Insufficient balance"

CLASS Current EXTENDS Account
    METHOD withdraw(amount)
        IF balance - amount >= 0
            balance = balance - amount
        ELSE
            PRINT "Overdraft not allowed"

MAIN
    CREATE Saving account
    CALL deposit(), withdraw()
    CREATE Current account
    CALL deposit(), withdraw()
*/