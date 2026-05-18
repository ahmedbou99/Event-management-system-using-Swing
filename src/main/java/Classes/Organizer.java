
package Classes;
import java.util.ArrayList;

public class Organizer extends Person {
   public String clubName;
  public  ArrayList<Event> managedEvents;
    
   public  Organizer(int id , String name ,String email , String clubName){
        super(id,name,email);
        this.clubName = clubName;
        this.managedEvents = new ArrayList<Event>();
    }
    
    public void addEvent(Event e){
       boolean f  =false;
       for (Event event : this.managedEvents){
        if (event.code.equals(e.code)) {
            f = true;
            System.out.println(this.name + " already is managing the event " + e.title );
            break;
        }    
       }
       
       if (!f) {
           this.managedEvents.add(e);
           e.organizer = this;
           System.out.println(e.title + " added successfully to " + this.name + "'s managed events list");
       }   
    }
    
    void displayManagedEvents(){
    for ( Event e : this.managedEvents){
        System.out.println("Event : " + e.title + "    Code : " + e.code);
        System.out.println("--------------------");
    }
    }
    
  @Override  void displayInfo(){
      super.displayInfo();
      System.out.println("Club Name : " + this.clubName);
      this.displayManagedEvents();
    }
  
  
  public static void main(String[] args){
      Organizer org = new Organizer(9,"Samuel Eto'o","EtoFCB@gmail.com","Alphabit");
      Room room = new Room("B02","Superior Cycle" , 32);
       Event evt1 = new Event("CTF01","Catch the Flag competition","06/04/2026",13,15,20);
       Event evt2 = new Event("RBTX02","Robotics & IoT Workshop","12/04/2026",11,13,16);
       
       evt1.assignRoom(room);
       evt2.assignRoom(room);
       
      org.addEvent(evt1);
      org.addEvent(evt2);
      org.addEvent(evt1);
       
      org.displayInfo();
       
       
      
  }
    
    
    
    
}
