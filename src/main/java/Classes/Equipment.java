/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Equipment {
   public int id;
   public String name;
  public  int quantityAvailable;
    
   public  Equipment(int id , String name , int quantityAvailable){
        this.id = id;
        this.name = name;
        this.quantityAvailable = quantityAvailable;
    }
    
    boolean isAvailable(int quantity){
        quantity = this.quantityAvailable;
    if (this.quantityAvailable > 0) return true;
    return false;
    }
    
    void displayInfo(){
        System.out.println("ID : " + this.id);
        System.out.println("Name : " + this.name);
        System.out.println("Quantity Available : " + this.quantityAvailable);
    }
    
    
    public static void main(String[] args){
        Equipment camera = new Equipment(1,"Canon EOS R6",3);
        Equipment ringLight = new Equipment(2,"Ring Light 6000 W",0);
        
        camera.displayInfo();
        ringLight.displayInfo();
        int qtt = 1;
    
        System.out.println(camera.isAvailable(qtt));
        System.out.println(ringLight.isAvailable(qtt));
        
    }
}
