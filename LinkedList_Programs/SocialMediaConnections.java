package linked_list_package;

import java.util.*;

//Node class
class User {
 int id, age;
 String name;
 List<Integer> friendIds; 
 User next;
 
//Constructor
 User(int id, String name, int age) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.friendIds = new ArrayList<>();
 }
}

//Singly Linked List
class SocialMedia {
 User head = null;

 // Add user to the end 
 public void addUser(int id, String name, int age) {
     User newUser = new User(id, name, age);
     if (head == null) {
         head = newUser;
         return;
     }
     User temp = head;
     while (temp.next != null) temp = temp.next;
     temp.next = newUser;
 }

 //Friend connection between two users
 public void addFriend(int id1, int id2) {
     User u1 = findUserById(id1);
     User u2 = findUserById(id2);
     if (u1 != null && u2 != null && id1 != id2) {
         if (!u1.friendIds.contains(id2)) u1.friendIds.add(id2);
         if (!u2.friendIds.contains(id1)) u2.friendIds.add(id1);
     }
 }

 // Remove friend connection
 void removeFriend(int id1, int id2) {
     User u1 = findUserById(id1);
     User u2 = findUserById(id2);
     if (u1 != null && u2 != null) {
         u1.friendIds.remove((Integer) id2);
         u2.friendIds.remove((Integer) id1);
     }
 }

 //Method findMutualFriends
 public void findMutualFriends(int id1, int id2) {
     User u1 = findUserById(id1);
     User u2 = findUserById(id2);
     if (u1 != null && u2 != null) {
         System.out.print("Mutual Friends of " + id1 + " and " + id2 + ": ");
         for (int f1 : u1.friendIds) {
             if (u2.friendIds.contains(f1))
                 System.out.print(f1 + " ");
         }
         System.out.println();
     }
 }

 //Method displayFriends
 public void displayFriends(int id) {
     User user = findUserById(id);
     if (user != null) {
         System.out.println("Friends of " + user.name + " (ID: " + id + "): " + user.friendIds);
     }
 }

 //Method searchUser
 public void searchUser(String name, Integer id) {
     User temp = head;
     while (temp != null) {
         if ((id != null && temp.id == id) || (name != null && temp.name.equalsIgnoreCase(name))) {
             System.out.println("Found: ID: " + temp.id + " Name: " + temp.name + " Age: " + temp.age);
             return;
         }
         temp = temp.next;
     }
     System.out.println("User not found");
 }

 //Method countFriends
 public void countFriends() {
     User temp = head;
     while (temp != null) {
         System.out.println(temp.name + " (ID: " + temp.id + ") has " + temp.friendIds.size() + " friend(s).");
         temp = temp.next;
     }
 }

 //method findUserById
 User findUserById(int id) {
     User temp = head;
     while (temp != null) {
         if (temp.id == id) return temp;
         temp = temp.next;
     }
     return null;
 }

 //Method displayAllUsers
 public void displayAllUsers() {
     User temp = head;
     while (temp != null) {
         System.out.println("ID: " + temp.id + " Name: " + temp.name + " Age: " + temp.age);
         temp = temp.next;
     }
 }
}

//Main Method
public class SocialMediaConnections {
 public static void main(String[] args) {
     SocialMedia sm = new SocialMedia();

     // Add users
     sm.addUser(1, "Rohit", 25);
     sm.addUser(2, "Rahul", 30);
     sm.addUser(3, "Ram", 28);
     sm.addUser(4, "Ravi", 22);

     sm.addFriend(1, 2);
     sm.addFriend(1, 3);
     sm.addFriend(2, 3);
     sm.addFriend(3, 4);

     System.out.println("\nAll Users:");
     sm.displayAllUsers();

     System.out.println("\nFriend List:");
     sm.displayFriends(1);
     sm.displayFriends(3);

     System.out.println("\nMutual Friends:");
     sm.findMutualFriends(1, 3);

     System.out.println("\nSearch:");
     sm.searchUser("Ravi", null);  
     sm.searchUser(null, 2);          

     System.out.println("\nFriend Counts:");
     sm.countFriends();

     sm.removeFriend(1, 3);
     System.out.println("\nAfter removing friend connection between 1 and 3:");
     sm.displayFriends(1);
     sm.displayFriends(3);
 }
}
