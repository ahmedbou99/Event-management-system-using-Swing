
package Classes;
import java.util.ArrayList;

public class Event {
  public  String code;
 public  String title;
  public String date;
  public int startHour;
 public  int endHour;
  public int maxParticipants;
  public Room room;
   public Organizer organizer;
  public ArrayList<Student> students = new ArrayList<Student>();
  public ArrayList<Equipment> equipments = new ArrayList<Equipment>();
   
 public Event(String code , String title , String date , int startHour , int endHour , int maxParticipants){
     this.code = code;
     this.title = title;
     this.date = date;
     this.startHour = startHour;
     this.endHour = endHour;
     
     if (this.startHour<8) this.startHour = 8;
     if (this.startHour > 18) this.startHour = 18;
     
     if (this.endHour<9) this.endHour = 9;
     if (this.endHour > 19) this.endHour = 19;
     
     if (this.startHour > this.endHour){
      int temp = this.startHour;
      this.startHour = this.endHour;
      this.endHour = temp;
     }
     
     this.maxParticipants = maxParticipants;
     
     
    
     
     this.students = new ArrayList<Student>();
     this.equipments = new ArrayList<Equipment>();
     
     
     
 }

 boolean addStudent(Student s){
     //to add a student to an events studebts list the events shouldnt be full
     if (this.isFull()) {
     System.out.println(s.name + " can't be added to " + this.title + "'s students list since the event is full");
     return false;
 }
     
     //to add a student into an event's students list , the student shouldnt be already registered
  for (Student student : this.students){
      if (s.id == student.id) {
          System.out.println(s.name + " is already in  " + this.title + "'s students list");
          return false;
      }
  }
  
  //to add a student into an event's students list , the event should not conflict with the student's registered events
  for (Event event : s.registeredEvents){
      if (event.hasConflict(this)){
          System.out.println(s.name + " can't be added into the event " + this.title + "'s students list due to a conflict");
          return false;
      }
  }
  
 this.students.add(s);
 System.out.println(s.name + " is added  successfully to the event " + this.title + "'s students list");
 return true;
  
 }
 
 
 
 
void addEquipment(Equipment e){   
     System.out.println(e.name + "added successfully to " + this.title + "'s event equipment list");
     this.equipments.add(e);
 }

boolean isFull(){
    if (this.students.size() == this.maxParticipants) return true;
    return false;
}
   
    public boolean hasConflict(Event other){
        if (this.date.equals(other.date) && ((this.startHour >= other.startHour && this.startHour < other.endHour) || (other.startHour >= this.startHour && other.startHour < this.endHour))) {
            System.out.println(this.title + " conflicts " + other.title);
            return true;
        }
        return false;
    }
    
    
    void displayDetails(){
        System.out.println("Code : "+  this.code);
        System.out.println("Title : " + this.title);
        System.out.println("Date : " + this.date);
        System.out.println("Starting Hour : " + this.startHour);
        System.out.println("Ending Hour : " + this.endHour);
        System.out.println("Maximum Number of Participants : " + this.maxParticipants);
        System.out.println("Room : " + this.room.roomNumber + " in " + this.room.building);
        System.out.println("Organizier : " + this.organizer.name); 
        System.out.print("Participants : ");
        for (Student s : this.students){
            System.out.print(s.name + " ");
        }
    }
    
   public  boolean assignRoom(Room room){
     if (this.maxParticipants <= room.capacity){
         this.room = room;
         System.out.println("Room " + room.roomNumber + " - " + room.building + " assigned successfully to the event " + this.title );
         return true;
     }
        System.out.println("Room " + room.roomNumber + " - " + room.building + " is insufficient to host the event " + this.title); 
        return false;
    }
    
    
    
    public static void main(String[] args){
        
                  Room room1 = new Room("A01","prep cycle" , 40);

        
        Event evt1 = new Event("HKT01","Hackathon","02/04/2026",14,17,30);
        Event evt2  = new Event("HKT01","Hackathon","02/04/2026",13,18,30);
        
        evt1.assignRoom(room1);
        evt2.assignRoom(room1);
        
         Student std1 = new Student(99,"Ahmed" , "gattusoTheBest@gmail.com","2CP","Preparatory Cycle" );
          Student std2 = new Student(2,"Carlos" , "carlosRM@gmail.com","3CS","Superior Cycle" );
          Student std3 = new Student(2,"Carlos" , "carlosRM@gmail.com","3CS","Superior Cycle" );
          Organizer org = new Organizer(21,"Schmeichel","bestGk@gmail.com","Ingeniums");
          
          
        org.addEvent(evt1);
          
        evt1.addStudent(std1);
         evt1.addStudent(std2);
         evt1.addStudent(std3);
       
       
        
      
      
      evt1.displayDetails();
      
      
          
          
          
          

         
        
    }
    
}
