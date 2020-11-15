/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CompanyController;
import java.sql.ResultSet;
import java.util.Arrays;

/**
 *
 * @author zack
 */
public class Customer extends Person  implements discount{
    
    private final int id_customer ; 
    private double amount ; 
  
    
   public Customer(String first_name , String last_name , String birthday,int id_customer) {
       super(first_name,last_name,birthday);
       this.id_customer=id_customer;
       
             
   }

   public int  getId(){
       
       return id_customer;
       
   }
 
 public double buy(double subtotal)
   {

     
     double years = Double.parseDouble(birthday) ;
     double age = 2020-years ; 
     
    
     if(age < 12)
         amount  = subtotal*(1-DSC_CHILDREN);
   
     else if(age > 62)
         amount  = subtotal*(1-DSC_SENIOR);
       
     else 
         amount  = subtotal*(1-DSC_REGULAR);
  
     
  return amount ; 
       
   }
   
   public double getAmount(){
       return amount ; 
             
   }
   
   public ResultSet getBookedFlight() throws Exception{
       
     return  new CompanyController().getBookedFlightuser(id_customer);
        
   }
   
   public void deleteFlights(String numberofFly) throws Exception
   {
    
     new CompanyController().deleteFlights(id_customer, numberofFly);   
         
       
   }
   
   
    
}
