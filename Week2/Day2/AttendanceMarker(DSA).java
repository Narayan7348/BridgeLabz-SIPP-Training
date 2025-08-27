/*// 2D Array [students][days]
int attendance[30][30]

// Mark attendance
method markAttendance(studentId, day, present) {
    attendance[studentId][day] = present ? 1 : 0
}

// Daily summary
method dailySummary(day) {
    count = sum(attendance[i][day] for i=0..29)
    print("Students present on day " + day + " = " + count)
}

// Monthly summary
method monthlySummary(studentId) {
    count = sum(attendance[studentId][j] for j=0..29)
    return count
}

// Defaulter list
method defaulterList() {
    for each student in 0..29:
        daysPresent = monthlySummary(student)
        if (daysPresent < 22) print("Student " + student + " is defaulter")
}

// Example run
main() {
    markAttendance(1, 1, true)
    markAttendance(3, 1, false)
    dailySummary(10)
    print(monthlySummary(5))
    defaulterList()
}
*/