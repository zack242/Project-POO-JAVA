/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.Employe;
import View.ConnexionPage;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author zack
 */
public class Connexion{
    
    public  Customer user ; 
    public boolean connected = false ; 
   
    
    public boolean Login(String email,String password) throws Exception{
        
        String sql,hash=""; 
        
        sql = "SELECT * FROM `customer` WHERE `email` LIKE '"+email+"' ;"; //The requete from to base to get the hash associated to the mail
         
       try {
           
       hash =  new ConnexionSQL().requetetoString(sql,"password_hash") ;   
       
       
       }catch (Exception ex){
         Logger.getLogger(ConnexionPage.class.getName()).log(Level.SEVERE, null, ex);
       }
              
       if(true == new Password().checkpassword(password, hash)){//Call the methode from Password to check 
            setuser(email);
            return true; 
           
       }
         
        
       else 
         return false ; 
          
    }
    
    
    public boolean LoginEmploye(String email,String password) throws Exception{
        
        String sql,hash=""; 
        
        sql = "SELECT * FROM `Employees` WHERE `email` LIKE '"+email+"' ;"; //The requete from to base to get the hash associated to the mail
         
       try {
           
       hash =  new ConnexionSQL().requetetoString(sql,"password_hash") ;   
       
       
       }catch (Exception ex){
         Logger.getLogger(ConnexionPage.class.getName()).log(Level.SEVERE, null, ex);
       }
      
       
       
       if(true == new Password().checkpassword(password, hash)){//Call the methode from Password to check 
            
           
           
           
           return true; 
           
       }
         
        
       else 
         return false ; 
          
    }
    
    
    public boolean Signup(String first,String last ,String birthday,String email,String password) throws Exception{
       
    
      //We hash the password  
     String hash = new  Password().hashpassword(password);
       
     //write the requete to insert into the customer table  
     String sql = " INSERT INTO `customer` (`first_name`, `last_name`, `birthday`, "
                + "`email`, `password_hash`) VALUES ('"+ first +  "', ' " + last + "  ', '"+ birthday + "',"
                + " '"+ email +"', '"+ hash +"');"; 
        
      
    try {
       new ConnexionSQL().requeteInsert(sql);   
       setuser(email);
       return true; 
       
    }catch (Exception e )
    {
        return false ; 
        
    }
           
       
   }
   
  public  void  setuser (String email) throws Exception{
        
        String sql ; 
        ResultSet rset ; 
        
        sql = "SELECT * FROM `customer` WHERE `email` LIKE '"+email+"' ;";
        
         
        user = (Customer) new ConnexionSQL().requetetoobject(sql) ; 
         
        connected = true ;   
    } 
      
  
   public  Employe  setEmploye (String email) throws Exception{
        
        String sql ; 
        ResultSet rset ; 
        
        sql = "SELECT * FROM `Employees` WHERE `email` LIKE '"+email+"' ;";
        
         
        return  (Employe) new ConnexionSQL().requetetoobject2(sql) ; 
         
         
    } 
      
  
  
  
  
  
 public String getuseremail(int id_customer) throws Exception
 {
     
  String sql = "SELECT * FROM `customer` WHERE `ID` LIKE '"+id_customer+"' ;";
     
   System.out.print(sql);
   
   return  new ConnexionSQL().requetetoString(sql,"email");
  
 
 } 
 
 
 public void Updateuser(String first , String last , String email , String password,double id_customer ) throws Exception{
     
     String sql = " UPDATE `customer` SET `first_name` = '"+ first  +"', `last_name` = '"+ last + "', `email` = '"+ email +"', `password_hash` = '"+ password + "' WHERE `customer`.`ID` = "+id_customer +"";
     
     new ConnexionSQL().requeteInsert(sql);
     
     
 }
 
  public void Updateuser(String first , String last , String email ,double id_customer ) throws Exception{
     
     String sql = " UPDATE `customer` SET `first_name` = '"+ first  +"', `last_name` = '"+ last + "', `email` = '"+ email +"' WHERE `customer`.`ID` = "+id_customer +"";
     
     new ConnexionSQL().requeteInsert(sql);
     
     
 }  
    
}
