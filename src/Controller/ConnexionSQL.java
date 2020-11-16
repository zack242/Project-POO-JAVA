/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * 
 * Librairies importées
 */
import Model.Customer;
import Model.Employe;
import Model.Flight;
import java.sql.*;


/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */

public final class ConnexionSQL {

  
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    private Connection conn ; 
    private Statement stmt = null ;
    
   
   
    public Connection getConnexion() throws SQLException, ClassNotFoundException{
      
       
        try {
           
       //  String urlDatabase = "jdbc:mysql://db4free.net:3306/bd_zakaria?verifyServerCertificate=false&useSSL=true";
        String urlDatabase = "jdbc:mysql://localhost:8889/" + "projet_ing3?verifyServerCertificate=false&useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
      
        conn =  DriverManager.getConnection(urlDatabase,"root","root");
       // System.out.print("Connexion reussi ");
        stmt = conn.createStatement();
        return conn ; 
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
       
        return null ; 
  
   
    }
    
     public  ConnexionSQL() throws Exception{
       
       conn = getConnexion(); 
       String sql = "SELECT * FROM `customer` ; ";   
       stmt = conn.createStatement() ;
       rset = stmt.executeQuery(sql) ;
            
         while (rset.next()) {
             
          //  System.out.println(rset.getString("first_name")) ;
         }
       
   }
     
     
     public void requeteInsert(String sql) throws SQLException{
          
       PreparedStatement preparedStmt = conn.prepareStatement(sql);
       preparedStmt.execute();
           
     }
     
     
    String requetetoString(String sql,String name_values) throws SQLException{
         
        rset = stmt.executeQuery(sql);
        String tmp=" " ; 
        
        
        while (rset.next()){
           tmp = rset.getString(name_values);
         
         }
        
        return tmp ;  
         
     }
    
   Customer requetetoobject(String sql) throws SQLException{
         
        rset = stmt.executeQuery(sql);
        rset.next();
         
        return  new Customer(rset.getString("first_name"),rset.getString("last_name"),rset.getString("birthday"),rset.getInt("ID") );
          
           
     }
   
   public Employe requetetoobject2(String sql) throws SQLException{
         
        rset = stmt.executeQuery(sql);
        rset.next();
       
  
        return  new Employe(rset.getString("first_name"),rset.getString("last_name"),rset.getString("birthday"),rset.getInt("ID") );
                  
     }
   
   
     
   public ResultSet requetetoflights(String sql) throws SQLException{
       
       rset = stmt.executeQuery(sql);
       return  rset; 
       
   }
   
   public Flight getselectedfligh(String sql ) throws SQLException{
        
       rset = stmt.executeQuery(sql);
       rset.next();
       System.out.print(rset.getString("DEPART"));
       
       return new Flight(rset.getString("DEPART"),rset.getString("DESTINATION"), rset.getString("TIME") , rset.getString("FLIGHT NO."),rset.getString("DATE"), Double.parseDouble(rset.getString("PRICE"))) ; 
   
       
   }
     
                 
          
  }

