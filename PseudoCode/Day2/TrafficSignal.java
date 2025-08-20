/*
ENUM TrafficLight
    RED(30)
    YELLOW(5)
    GREEN(30)
    
    PRIVATE FIELD
        duration in seconds
    
    CONSTRUCTOR(duration)
        initialize duration

CLASS TrafficSignalController
    PRIVATE FIELDS
        currentLight
        timer
    
    METHOD switchLight()
        IF timer expired
            SWITCH to next light
            RESET timer
    
    METHOD displayStatus()
        SHOW current light and remaining time
*/