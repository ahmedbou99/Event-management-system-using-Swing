/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
public class Room {
    public String roomNumber;
    public String building;
    public int capacity;
    
    public Room(String roomNumber , String building , int capacity ){
        this.roomNumber = roomNumber;
        this.building = building;
        this.capacity = capacity;
    }
    
    boolean canHost(int numParticipants){
       if (numParticipants <= this.capacity) return true;
       return false;
    }
    
    void displayInfo(){
        System.out.println("Room Number : " + this.roomNumber);
        System.out.println("Building : " + this.building);
        System.out.println("Capacity : " + this.capacity);
    }
    
    
    public static void main(String[] args){
     Room room1 = new Room("A01" , "Superior Cycle" , 26);
     
     Room room2 = new Room("A02" , "Preparatory Cycle" , 35);
     
     
     room1.displayInfo();
     room2.displayInfo();
      
        System.out.println(room1.canHost(21));
        System.out.println(room2.canHost(40));


              
    }
    
}
