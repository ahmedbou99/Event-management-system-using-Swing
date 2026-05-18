
package Classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Registration {
   public int registrationId;
    public String registrationDate;
   public  String status;
    public Student student;
    public Event event;
    
    public Registration(int registrationId,String registrationDate, String status , Student student , Event event){
       this.registrationId = registrationId;
       this.registrationDate = registrationDate;
       this.status = status;
       this.student = student;
       this.event = event;
    }
    
  public void confirmRegistration(){
      DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate regDate = LocalDate.parse(this.registrationDate, f);
      LocalDate evtDate = LocalDate.parse(this.event.date, f);
      
      if (regDate.isAfter(evtDate)) {
          System.out.println(this.student.name + "'s Registration to the event " + this.event.title + " failed due to it being after the event started");
          JOptionPane.showMessageDialog(null, "Too late to register :)", "Registration Date Error", JOptionPane.ERROR_MESSAGE);
          this.status = "Declined";
          return;
      }
      
      if (this.event.addStudent(this.student) && this.student.registerToEvent(this.event)){
          System.out.println(this.student.name + " registered to the event " + this.event.title + " successfully");
          this.status = "Accepted";
          return;
      }
      JOptionPane.showMessageDialog(null, "Invalid Registration", "Registration Error", JOptionPane.ERROR_MESSAGE);
      this.status = "Declined";
      return;    
  }  
  
 public void cancelRegistration(){
     if (!this.status.equals("Declined")){
         if (this.student.registeredEvents.contains(this.event)){
             this.student.registeredEvents.remove(this.event);
             this.status = "Canceled";
             
         }
         
         if (this.event.students.contains(this.student)){
             this.event.students.remove(this.student);
             this.status = "Canceled";
             System.out.println(this.student.name + "'s registration to the event " + this.event.title +  " has been canceled  ");
         }
     return;
     }
     System.out.println("can't cancel a declined registration");
 }
 
 
 void displayDetails(){
     System.out.println("Registration ID : " + this.registrationId);
     System.out.println("Registration Date : " + this.registrationDate);
     System.out.println("Student Name : " + this.student.name + " Student ID : " + this.student.id );
     System.out.println("Event Title : " + this.event.title + "Event Code : " + this.event.code);
     System.out.println("Status : " + this.status);
 }
 
 
 public static void main(String[] args){
       Room room = new Room("B02","Superior Cycle" , 32);
      Student std1 = new Student(99,"Ahmed" , "gattusoTheBest@gmail.com","2CP","Preparatory Cycle" );
      Event evt1 = new Event("HKT01","Hackathon","02/04/2026",14,17,30);
      Event evt2 = new Event("RBTX02","Robotics & IoT Workshop","02/04/2026",14,16,16);
      evt1.assignRoom(room);
      evt2.assignRoom(room);
      
        Registration reg1 = new Registration(1,"01/04/2026","Pending",std1,evt1);
         Registration reg2 = new Registration(2,"01/04/2026","Pending",std1,evt2);
         
         reg1.confirmRegistration();
         reg2.confirmRegistration();
           
           reg1.displayDetails();
           System.out.println("");
           reg2.displayDetails();
           
           reg1.cancelRegistration();
           
        
           
           
          System.out.printf("%b",evt2.students.isEmpty());
          System.out.printf("%b",std1.registeredEvents.isEmpty()); 
          
           
           
           
           
     
 }
  
  
  
    
}
