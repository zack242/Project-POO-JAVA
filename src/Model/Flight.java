/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author zack
 */
public class Flight {
    
   protected String number ; 
   protected String depart ; 
   protected String destination ; 
   protected String Time ; 
   protected double price ; 
   
    
   public Flight(String depart , String destination , String Time ,String number, double price )
   {
       this.number = number ; 
       this.depart = depart ; 
       this.destination = destination ; 
       this.Time = Time ; 
       this.price = price ; 
       
       
   }
   
   
   
   
   
    
}
