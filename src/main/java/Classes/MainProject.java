
package Classes;


public class MainProject {
public static void main(String[] args){
    System.out.println("****Partial Tests*****");
    Student stdTest = new Student(1,"Zinedine" ,"zinedine@univ.dz","1CS","Computer Science Dep" );
    stdTest.displayInfo();
    
    System.out.println("");
    
    Organizer orgTest = new Organizer(1,"Hatem", "hatem@univ.dz","Ingeniums");
    orgTest.displayInfo();
    
    System.out.println("");
    System.out.println("******Global Tests*******");
    
     Organizer org1 = new Organizer(100, "Andres", "andres@univ.dz", "Quantum Club");
    Room r1 = new Room("A101", "Main Building", 25);
    Room r2 = new Room("B202", "Science Building", 30);
    Equipment projector = new Equipment(1, "Projector", 2);
    Equipment laptop = new Equipment(2, "Laptop", 5);
    
    Event e1 = new Event("E01", "Datathon", "10/04/2026", 9, 11, 20);
    Event e2 = new Event("E02", "Cybersecurity CTF", "10/04/2026", 10, 12, 25);
    Event e3 = new Event("E03", "Robotics Workshop", "11/04/2026", 14, 16, 30);
    
    
    org1.addEvent(e1);
    org1.addEvent(e2);
    org1.addEvent(e3);
    
     e1.assignRoom(r1);
     e2.assignRoom(r2);
     e3.assignRoom(r2);
     
      e1.addEquipment(projector);
       e2.addEquipment(laptop);
       
       
       Student s1 = new Student(201, "Lamine", "lamine@univ.dz", "L3", "Computer Science");
        Student s2 = new Student(202, "Rayan", "rayan@univ.dz", "L2", "Mathematics");
        Student s3 = new Student(203, "Jamal", "jamal@univ.dz", "L1", "Physics");

        Registration reg1 = new Registration(1, "23/03/2026", "Pending", s1, e1);
        Registration reg2 = new Registration(2, "23/03/2026", "Pending", s2, e1);
        Registration reg3 = new Registration(3, "23/03/2026", "Pending", s3, e1);
        
        
        System.out.println("****** Register students in Datathon******");
        reg1.confirmRegistration();
        reg2.confirmRegistration();
        reg3.confirmRegistration();
        
        
        
          System.out.println("******Trying conflicting registration for Lamine******");
        Registration reg4 = new Registration(4, "23/03/2026", "Pending", s1, e2);
        reg4.confirmRegistration();
        
        
        System.out.println("********Register Lamine in non-conflicting event*******");
        Registration reg5 = new Registration(5, "23/03/2026", "Pending", s1, e3);
        reg5.confirmRegistration();
        
        
        System.out.println("\n===== EVENT DETAILS =====");
        e1.displayDetails();
     

        System.out.println();
        e2.displayDetails();

        System.out.println();
        e3.displayDetails();
        

        System.out.println("\n===== ORGANIZER EVENTS =====");
        org1.displayManagedEvents();

        System.out.println("\n===== STUDENT EVENTS =====");
        s1.displayMyEvents();
        System.out.println();
        s2.displayMyEvents();
        System.out.println();
        s3.displayMyEvents();

        System.out.println("\n===== REGISTRATION STATUS =====");
        reg1.displayDetails();
        System.out.println();
        reg4.displayDetails();
        System.out.println();
        reg5.displayDetails();

        System.out.println("\n===== CANCELLATION TEST =====");
        reg2.cancelRegistration();
        reg2.displayDetails();

        System.out.println();
        e1.displayDetails();
      

        
    
   
    
    
    
    
}

    
}
