/*
CLASS Member
    PRIVATE FIELDS
        name, id, membershipDate
        CONSTANT validityPeriod = 365 days
    
    CONSTRUCTOR(name, id)
        initialize name, id
        set membershipDate to current date
    
    METHOD checkValidity()
        GET current date
        CALCULATE days between membershipDate and current date
        IF days > validityPeriod
            RETURN false
        ELSE
            RETURN true
    
    METHOD renewMembership()
        SET membershipDate to current date

MAIN CLASS
    CREATE member objects
    CHECK their membership validity
    RENEW if expired
*/