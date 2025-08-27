/*class User {
    String username;
    String password;

    void login() {
        // generic login steps
        // verify username + password
    }
}

class Student extends User {
    boolean isRegistered;
    boolean isEnrolled;

    @Override
    void login() {
        // check username + password
        // check isRegistered && isEnrolled
        // if valid → show exams
        // else → deny access
    }
}

class Admin extends User {
    boolean hasAdminPrivileges;

    @Override
    void login() {
        // check username + password
        // check hasAdminPrivileges
        // if valid → show exam management tools
        // else → deny access
    }
}

// Example usage
User u1 = new Student();
u1.login();

User u2 = new Admin();
u2.login();
*/
