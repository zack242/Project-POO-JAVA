/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author zack
 */
public class CompanyController {
    
    
    public void addbookedflight(int id_client , String numberofFlight , double price) throws Exception
    {
     
    String sql = " INSERT INTO `bookedflight` (`Number`, `id_client`, `Flight NO.`, `Price`) VALUES (NULL, '"+id_client+"', '"+numberofFlight +"', '"+price+"') "; 
        
    new ConnexionSQL().requeteInsert(sql);
        
        
    }
    
    
}
