/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Flight;
import java.sql.ResultSet;

/**
 *
 * @author zack
 */
public class CompanyController {
    
    
    public void addbookedflight(int id_client , String numberofFlight ,double nbrofperson, double price) throws Exception
    {
     
    String sql = " INSERT INTO `bookedflight` (`Number`, `id_client`, `Flight NO.`,`NumberofPerson` ,`Price`) VALUES (NULL, '"+id_client+"', '"+numberofFlight +"','"+nbrofperson+"','"+price+"') "; 
        
    new ConnexionSQL().requeteInsert(sql);
        
        
    }
    
     
    public ResultSet getBookedFlightuser(double id_customer) throws Exception
    {
        
     String sql = "SELECT `FLIGHT NO.`,`DEPART`,`DESTINATION`,`PRICE` FROM flights  WHERE `Flight NO.` = ANY  ( SELECT `FLIGHT NO.` FROM bookedflight WHERE `id_client` = "+ id_customer + " )"; 
     
     ResultSet rset = new ConnexionSQL().requetetoflights(sql);
     
     return rset ; 
        
        
    }
    
    
    
    
    public void deleteFlights(double id_customer , String numberofFly) throws Exception{
        
        String sql = " DELETE FROM `bookedflight` WHERE `bookedflight`.`id_client` = " + id_customer+ " AND `bookedflight`.`FLIGHT NO.` = '" + numberofFly +"'  " ; 
        
        new ConnexionSQL().requeteInsert(sql);
        
    }
    
    public void deleteFlights(String numberofFly) throws Exception{
        
        String sql = "DELETE FROM `flights` WHERE `flights`.`FLIGHT NO.` =  '"+ numberofFly +"' ;" ; 
        ////ici ajouter une requete pour supprimer de la table de booked ; 
        
        new ConnexionSQL().requeteInsert(sql);
        
    }
    public ResultSet getFlights() throws Exception{
        
        String sql =  " SELECT * FROM `flights` " ;
        ResultSet rset = new ConnexionSQL().requetetoflights(sql); 
        
        return rset ; 
             
    }
    
     public Flight getSelectedFlights(String numberflight) throws Exception{
        
        Flight selected ; 
        
        String sql =  " SELECT * FROM `flights` WHERE `FLIGHT NO.` = '"+ numberflight +"'  " ;
        
        
        return  new ConnexionSQL().getselectedfligh(sql); 
                  
    }
     
    public void addFlight(String depart , String destination , String Time ,String number,String date, double price ) throws Exception, Exception
    {
        
    String sql = " INSERT INTO `flights` (`FLIGHT NO.`, `TIME`, `DEPART`, `DESTINATION`, `PRICE`, `DATE`) VALUES ('"+number+ "', '"+Time +"', '"+depart+"', '"+destination+"', '"+price+"', '"+date+"') ; " ;
            
    new ConnexionSQL().requeteInsert(sql);
        
    }
    
    public void uptadeFlight(String depart , String destination , String Time ,String number,String date, double price ,String id_flights ) throws Exception, Exception
    {
        
   
    String sql = " UPDATE `flights` SET `FLIGHT NO.` = '"+ number +"', `TIME` = '"+ Time +" ', `DEPART` = '"+depart+"', `DESTINATION` = '"+destination+"', `PRICE` = '"+price+"', `DATE` = '"+date+"' WHERE `flights`.`FLIGHT NO.` = '"+id_flights+"' ";
    new ConnexionSQL().requeteInsert(sql);
    System.out.print(sql);
    
        
    }
    
    
    public ResultSet getCustomer() throws Exception {
        
        String sql = "SELECT * FROM `customer`";
        ResultSet rset = new ConnexionSQL().requetetoflights(sql); 
        
        return rset ; 
            
    }
    
    
     public ResultSet getBookedFlight(int id_customer) throws Exception{
        
        String sql =  " SELECT * FROM `bookedflight` WHERE `id_client` = '"+id_customer+"' ";
        ResultSet rset = new ConnexionSQL().requetetoflights(sql); 
        
        return rset ; 
             
    }
    
     public ResultSet getBookedFlight() throws Exception{
        
        String sql = "SELECT * FROM `bookedflight` ; " ; 
        ResultSet rset = new ConnexionSQL().requetetoflights(sql); 
        
        return rset ; 
             
    }
    
 
    public void deleteCustomer(int id_customer) throws Exception{
        
        String sql = " DELETE FROM `customer` WHERE `customer`.`ID` = '"+id_customer+"' ";
        new ConnexionSQL().requeteInsert(sql);
        
    }
    
}
