// Base class
/*class User {
    String username
    String password

    method login() {
        print("Generic login validation")
    }
}

// Student subclass
class Student extends User {
    boolean isRegistered
    boolean isEnrolled

    override method login() {
        if (credentialsValid(username, password) AND isRegistered AND isEnrolled) {
            print("Student logged in → show available exams")
        } else {
            print("Student login failed")
        }
    }
}

// Admin subclass
class Admin extends User {
    boolean hasAdminPrivileges

    override method login() {
        if (credentialsValid(username, password) AND hasAdminPrivileges) {
            print("Admin logged in → show exam management tools")
        } else {
            print("Admin login failed")
        }
    }
}

// Example run
main() {
    Student s = new Student("john123", "pass", true, true)
    s.login()

    Admin a = new Admin("admin01", "adminpass", true)
    a.login()
}
*/