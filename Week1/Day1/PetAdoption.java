/*
CLASS Pet
    PRIVATE FIELDS
        name, age, breed
    
    CONSTRUCTOR(name, age, breed)
        initialize fields
    
    GETTERS AND SETTERS

CLASS Dog EXTENDS Pet
    PRIVATE FIELD
        vaccinated
    
    CONSTRUCTOR(name, age, breed, vaccinated)
        call super(name, age, breed)
        initialize vaccinated

CLASS Cat EXTENDS Pet
    PRIVATE FIELD
        indoor
    
    CONSTRUCTOR(name, age, breed, indoor)
        call super(name, age, breed)
        initialize indoor

CLASS Bird EXTENDS Pet
    PRIVATE FIELD
        canFly
    
    CONSTRUCTOR(name, age, breed, canFly)
        call super(name, age, breed)
        initialize canFly

MAIN CLASS
    CREATE dog, cat, bird objects
    DISPLAY their details
*/