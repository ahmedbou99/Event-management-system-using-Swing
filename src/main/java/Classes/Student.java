
package Classes;
import java.util.ArrayList;


public class Student extends Person {
    public String level;
   public  String department;
    public ArrayList<Event> registeredEvents;
    
    public Student(int id , String name , String email , String level , String department){
        super(id,name,email);
        this.level = level;
        this.department = department;
        this.registeredEvents = new ArrayList<Event>();
    }
    
    boolean registerToEvent(Event e){
        //to register the student in event ,the event shouldnt be full
        if (e.isFull()) {
            System.out.println("the event " +  e.title + " is full , can't register "+ this.name);    
            return false;
        }
        //to register the student in event , he shouldnt be already registered , and the event shouldnt conflict with other events
        for (Event event: this.registeredEvents){
            if (event.code.equals(e.code)) {
                System.out.println(e.title + " is already in " + this.name + "'s events list");
                return false;   
            }
            else if (event.hasConflict(e)){
                System.out.println(e.title + "event conflicts " + this.name + "'s event list");
                return false;
            }
        }
        
        this.registeredEvents.add(e);  
        System.out.println(e.title + " added successfully to " + this.name + " registered events list ");
        return true;       
    }
    
    
    void displayMyEvents(){
        System.out.println(this.name + " is participating in : ");
        for (Event e : this.registeredEvents){
           System.out.println("Event : " + e.title + "    Code : " + e.code);
            System.out.println("-----------");
        } 
    }
    
    
    @Override void displayInfo(){
        super.displayInfo();
        System.out.println("Level : " + this.level);
        System.out.println("Department : " + this.department);
        this.displayMyEvents();
    }
    
    public static void main(String[] args){
        
        Room room1 = new Room("A01","prep cycle" , 40);
        Organizer org = new Organizer(21,"Schmeichel","bestGk@gmail.com","Ingeniums");
        Event evt1 = new Event("HKT01","Hackathon","02/04/2026",14,17,30);
          Event evt2 = new Event("CTF01","Catch the Flag competition","06/04/2026",13,15,20);
       Event evt3 = new Event("RBTX02","Robotics & IoT Workshop","12/04/2026",11,13,16);
           Event evt4 = new Event("RBTX02","Robotics & IoT Workshop","12/04/2026",11,13,16);
           
           evt1.assignRoom(room1);
           evt2.assignRoom(room1);
           evt3.assignRoom(room1);
           evt4.assignRoom(room1);
           
           
        Student std1 = new Student(99,"Ahmed" , "gattusoTheBest@gmail.com","2CP","Preparatory Cycle" );
         Student std2 = new Student(2,"Carlos" , "carlosRM@gmail.com","3CS","Superior Cycle" );
         
         std1.registerToEvent(evt1);
         std1.registerToEvent(evt2);
         std1.registerToEvent(evt1);
         
         std2.registerToEvent(evt2);
         std2.registerToEvent(evt3);
         std2.registerToEvent(evt4);
         
         std1.displayInfo();
         System.out.println("***********");
         std2.displayInfo();
         
         
         
         
         
          
          
         
        
        
    }
    
    
    
}
