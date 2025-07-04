package linked_list_package;

//Node Class
class TextState {
 String content;
 TextState prev, next;
 
//Constructor
 TextState(String content) {
     this.content = content;
 }
}

//Doubly Linked List 
class TextEditor {
 TextState head = null, current = null;
 int maxHistory = 10;
 int size = 0;

 // Add new text state at the end
 void addState(String content) {
     TextState newState = new TextState(content);
     
     if (current != null) current.next = null;
     if (head == null) {
         head = current = newState;
     } else {
         current.next = newState;
         newState.prev = current;
         current = newState;
     }
     size++;
     if (size > maxHistory) {
         head = head.next;
         head.prev = null;
         size--;
     }
 }

 //Method undo
 public void undo() {
     if (current != null && current.prev != null) {
         current = current.prev;
         System.out.println("Undo successful");
     } else {
         System.out.println("Nothing to undo");
     }
 }

 //Redo
 public void redo() {
     if (current != null && current.next != null) {
         current = current.next;
         System.out.println("Redo successful");
     } else {
         System.out.println("Nothing to redo");
     }
 }

 // Display current text
 public void showCurrent() {
     if (current != null)
         System.out.println("Current Text: " + current.content);
     else
         System.out.println("No text available.");
 }
}

//Main class
public class UndoRedo {
 public static void main(String[] args) {
     TextEditor editor = new TextEditor();
     
     editor.addState("Hello");
     editor.addState("Hello World");
     editor.addState("Hello World!");
     editor.showCurrent();

     editor.undo();         
     editor.showCurrent();  

     editor.undo();         
     editor.showCurrent();  

     editor.redo();         
     editor.showCurrent();  

     editor.addState("Hello Java"); 
     editor.showCurrent();         

     editor.undo(); 
     editor.undo(); 
     editor.undo(); 

     editor.redo();
     editor.redo(); 
     editor.redo(); 
 }
}

