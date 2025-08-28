// ListManager.java
import java.util.*;
public class ListManager {
    public List<Integer> addElement(List<Integer> list,int e){ list.add(e); return list; }
    public List<Integer> removeElement(List<Integer> list,int e){ list.remove(Integer.valueOf(e)); return list; }
    public int getSize(List<Integer> list){ return list.size(); }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++) list.add(sc.nextInt());
        ListManager m=new ListManager();
        m.addElement(list,10);
        m.removeElement(list,2);
        System.out.println("Size: "+m.getSize(list));
    }
}
