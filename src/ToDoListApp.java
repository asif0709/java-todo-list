import java.util.*;
public class ToDoListApp{
 private static final Scanner SC=new Scanner(System.in);private static final Map<Integer,Task> tasks=new HashMap<>();private static int nextId=1;
 public static void main(String[]args){while(true){System.out.println("\n1 Add  2 List  3 Complete  4 Delete  5 Update  0 Exit");switch(SC.nextLine()){case"1"->add();case"2"->list();case"3"->complete();case"4"->delete();case"5"->update();case"0"->{System.out.println("Goodbye.");return;}default->System.out.println("Invalid choice.");}}}
 static void add(){System.out.print("Task: ");String t=SC.nextLine().trim();if(t.isEmpty()){System.out.println("Task cannot be empty.");return;}tasks.put(nextId,new Task(nextId,t,false));System.out.println("Added task #"+nextId++);}
 static void list(){if(tasks.isEmpty()){System.out.println("No tasks.");return;}tasks.values().stream().sorted(Comparator.comparingInt(t->t.id)).forEach(t->System.out.printf("#%d [%s] %s%n",t.id,t.done?"x":" ",t.title));}
 static void complete(){int id=id();Task t=tasks.get(id);if(t!=null){t.done=true;System.out.println("Completed.");}else System.out.println("Task not found.");}
 static void delete(){int id=id();if(tasks.remove(id)!=null)System.out.println("Deleted.");else System.out.println("Task not found.");}
 static void update(){int id=id();Task t=tasks.get(id);if(t==null){System.out.println("Task not found.");return;}System.out.print("New title: ");String s=SC.nextLine().trim();if(!s.isEmpty())t.title=s;System.out.println("Updated.");}
 static int id(){System.out.print("Task ID: ");try{return Integer.parseInt(SC.nextLine());}catch(NumberFormatException e){System.out.println("Enter a number.");return-1;}}
 static class Task{int id;String title;boolean done;Task(int i,String t,boolean d){id=i;title=t;done=d;}}
}