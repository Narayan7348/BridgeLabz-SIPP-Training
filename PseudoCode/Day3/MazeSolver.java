/*
CLASS MazeSolver
    PRIVATE FIELDS
        int[][] maze
        boolean[][] visited
        
    METHOD solveMaze(int[][] maze)
        INITIALIZE visited array
        RETURN solveRecursive(0, 0)
    
    METHOD solveRecursive(int row, int col)
        IF reached destination
            RETURN true
            
        IF invalid position OR wall OR visited
            RETURN false
            
        MARK current position as visited
        
        FOR each direction (up, right, down, left)
            IF solveRecursive(next position)
                RETURN true
                
        UNMARK current position (backtrack)
        RETURN false
*/
