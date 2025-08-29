/*
CLASS TextEditor
    PRIVATE FIELD
        Stack<String> undoStack
        currentText
    
    METHOD type(text)
        PUSH currentText to undoStack
        UPDATE currentText with new text
    
    METHOD undo()
        IF undoStack not empty
            SET currentText to POP from undoStack
        ELSE
            DISPLAY "Nothing to undo"
    
    METHOD display()
        SHOW currentText

MAIN CLASS
    CREATE TextEditor object
    PERFORM type operations
    TEST undo functionality
*/