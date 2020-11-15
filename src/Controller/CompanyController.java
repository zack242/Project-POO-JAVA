/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
        System.out.print(sql);
        new ConnexionSQL().requeteInsert(sql);
        
    }
    
    
    
}
