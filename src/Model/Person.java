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
public  class Person {
    
    protected String first_name ; 
    protected String last_name ; 
    protected String birthday;
    protected double amount ; 
    

  
  
   
    
    public Person(String first_name , String last_name , String birthday)
    {
     this.first_name = first_name ; 
     this.last_name = last_name ; 
     this.birthday = birthday;
     amount = 0 ; 
  
       
        
    }
    
   public String getName(){
       
        return first_name;
        
    }
    
   public String getLastName(){
       
        return last_name;
        
    }
    
   public  String getBirtday(){
       
        return birthday ;
        
    }
    
    
    
  void addAmount(double priceoffly){
      
      amount+= priceoffly ; 
      
      
  }
  
      
   
    
}
