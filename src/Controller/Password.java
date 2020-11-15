
package Controller; 

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    
  public String hashpassword(String input){
      
       StringBuilder sb ; 
       try{
       MessageDigest md  = MessageDigest.getInstance("SHA-512");
       byte[] data  = md.digest(input.getBytes()); 
        sb = new StringBuilder();
       for(int i = 0 ; i < data.length ; i++){
           sb.append(String.format("%02x",data[i]));
           
       }
      
       return sb.toString() ; 
          
       }catch(NoSuchAlgorithmException e)
       {
           
        System.out.print(e.getMessage());   
           
       }
       
       return " "; 
       
          
   }
   
   boolean checkpassword(String input , String hash_database){
       
      String tmp= hashpassword(input) ; 
     
       if( hash_database == null ? tmp == null : hash_database.equals(tmp) ){
                  
          return true ; 
           
       }  
          
       else    
           return false ; 
             
   }
   
   
   
   
    
    
}