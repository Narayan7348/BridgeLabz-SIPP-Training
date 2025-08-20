/*
CLASS QuizTimer
    PRIVATE FIELDS
        CircularArray<Integer> timeSlots
        currentQuestion
        warningThreshold
    
    METHOD startTimer()
        INITIALIZE timer for current slot
        
    METHOD checkTimeRemaining()
        IF time < warningThreshold
            TRIGGER warning
        
    METHOD moveToNextQuestion()
        INCREMENT currentQuestion
        RESET timer
*/