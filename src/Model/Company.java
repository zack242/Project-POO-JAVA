/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CompanyController;
import Controller.Connexion;
import Model.Person;
import java.util.ArrayList;

/**
 *
 * @author zack
 */
public class Company {
   
    public Person user;
    public Connexion conn ; 
    public boolean oneway ; 
    public double subTotal ; 
    public double Total ; 
    public int numberofperson;
    
    
    protected String selectedFlightdep ; 
    protected String selectedFlightarv ; 
    protected double pricedep ; 
    protected double pricearv ; 
    
    
    
   
    public Company()
    {
    user = new Person("Guest","","");   
    conn = new Connexion();
    oneway = true ; 
    numberofperson = 1 ;
    subTotal=0;
    pricedep = 0; 
    pricearv = 0; 
    Total =0; 
    
    }
        
  public String getNameuser()
  {    
      return user.getName() ;       
  }  
  
  public void setuser()
  {
     if(conn.connected==true)
       this.user = conn.user ;  
  }
  
  public void addFlight(String selectedFlightdep,int oneway)
  {  
      if(oneway==0)
      this.selectedFlightdep = selectedFlightdep ; 
      if(oneway==1){
          this.selectedFlightarv= selectedFlightdep; 
          this.oneway=false;
  }
      
      
      
  }
  
  public String getFlightdep()
  {
      return selectedFlightdep;
  }
  
  public String getFlightarv()
  { 
      return selectedFlightarv;   
  }
  
public void reset()
{
    oneway = true ; 
    numberofperson = 1 ;
    subTotal=0;
    Total=0;
    selectedFlightdep = null;
    selectedFlightarv=null;
    pricedep = 0; 
    pricearv = 0; 
      
}

public void buy() throws Exception{
    
       
  if(user instanceof Customer )
    {
    Customer A = (Customer) user ; 
   
    Total = A.buy(subTotal);
   
    for(int i = 0 ; i < numberofperson ; i++) {
        
    new CompanyController().addbookedflight(A.getId(),selectedFlightdep,pricedep);
    if(oneway==false)
    new CompanyController().addbookedflight(A.getId(),selectedFlightarv,pricearv); 
        
        
    }
    
        
    }
  else
    {
     for(int i = 0 ; i < numberofperson ; i++) 
    {    
    new CompanyController().addbookedflight(999,selectedFlightdep,pricedep);
    if(oneway==false)
    new CompanyController().addbookedflight(999,selectedFlightarv,pricearv);  
    }
    Total = subTotal ;  
    }
     
}

public void setpriceofFlight(double pricedep  , double pricearv)
  {
    
   this.pricedep =  pricedep; 
   this.pricearv =  pricearv; 
    
    
}
  
    
    
}
