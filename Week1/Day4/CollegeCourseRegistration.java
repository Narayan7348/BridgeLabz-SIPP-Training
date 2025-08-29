/* 
CLASS Course
    VARIABLE: courseId, courseName

CLASS Student
    VARIABLE: studentId, studentName

MAIN
    CREATE Map<Course, List<Student>> courseMap

    METHOD registerStudent(course, student)
        IF course NOT in courseMap
            ADD course with empty student list
        ADD student to courseMap.get(course)

    METHOD displayStudentsPerCourse()
        FOR each course in courseMap
            PRINT courseName
            FOR each student in courseMap.get(course)
                PRINT studentName

    TEST:
        CREATE some courses
        CREATE some students
        REGISTER students to courses
        DISPLAY all students per course
*/