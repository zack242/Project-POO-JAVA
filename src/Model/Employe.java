/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CompanyController;
import java.sql.ResultSet;

/**
 *
 * @author zack
 */
public class Employe extends Person{
    
    private int id_employe ; 
    public Flight selectedFlights ; 
    
    public Employe(String first_name , String last_name , String birthday,int id_employe)
       {
           
       super(first_name,last_name,birthday);
       this.id_employe=id_employe;
        
     }
    
    
     public ResultSet getFlights() throws Exception{
      
      return new CompanyController().getFlights() ;       
  }  
     
    public void  setFlights(String number) throws Exception{
        
        selectedFlights = new CompanyController().getSelectedFlights(number) ;
        
    } 
    
    public void addFlights(Flight flight) throws Exception{
       
        new CompanyController().addFlight(flight.getdepart(),flight.destination,flight.Time,flight.number,flight.date,flight.price);
                
    }
    
    public void UpdateFlights(Flight flight) throws Exception{
       
        new CompanyController().uptadeFlight(flight.getdepart(),flight.destination,flight.Time,flight.number,flight.date,flight.price,selectedFlights.getNumber());
                
    }
    
    public void DeleteFlights() throws Exception{
        
        new CompanyController().deleteFlights(selectedFlights.getNumber());
            
    }
    
    
    
    
}
