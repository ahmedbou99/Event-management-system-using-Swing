/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Person {
    public int id;
    public String name;
   public  String email;
    
    Person(int id , String name , String email){
    this.id = id;
    this.name = name;
    this.email  = email;
    }
    
    void displayInfo(){
        System.out.println("ID : " + this.id );
        System.out.println("Name : " + this.name);
        System.out.println("Email : " + this.email);
    }
    
    public static void main(String[] args){
    Person person = new Person(1,"Ahmed","gattusoThebest@gmail.com");
    
   person.displayInfo();
    }
    
}
