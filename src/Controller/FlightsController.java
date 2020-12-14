/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.mainPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use for the DAO class 
 * @author zack
 */
public class FlightsController {

    /// Get a flight  who correspond to the research 
    public ResultSet GetFlight(String dep, String arv, String datedep) throws SQLException {

        ResultSet rset = null;

        String sql = "SELECT * FROM `flights` WHERE `DEPART` LIKE '" + dep + "' AND `DESTINATION` LIKE "
                + "'" + arv + "' AND `DATE` = '" + datedep + "' "; // The requete that send all the flight who correspond to the reserch

        try {

            return new ConnexionSQL().requetetoflights(sql);

        } catch (Exception ex) {
            Logger.getLogger(mainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    
    // Get a flight by the number of flight (primary key ) 
    public ResultSet GetFlight(String numberOfFlight) throws SQLException {

        ResultSet rset = null;

        String sql = "SELECT * FROM `flights` WHERE `FLIGHT NO.` = '" + numberOfFlight + "' ";

        try {

            return new ConnexionSQL().requetetoflights(sql);

        } catch (Exception ex) {
            Logger.getLogger(mainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}
