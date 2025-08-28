// Task.java
public class Task {
    public String longRunningTask(){
        try{ Thread.sleep(3000);}catch(Exception e){}
        return "done";
    }
}
