/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Company;

/**
 *
 * @author zack
 */
public class CheckoutController {

    
    ///This method allows to calculate the sum with or without reductions for each user
    
    public void calculTotal(Company mycompany) throws Exception {

        double price1 = 0, price2 = 0,total = 0;
        String dep, arv;

        dep = mycompany.getFlightdep(); 

        
        String sql = "SELECT * FROM `flights` WHERE `FLIGHT NO.` = '" + dep + "' ";

        price1 = Double.parseDouble(new ConnexionSQL().requetetoString(sql, "price"));

        if (mycompany.oneway == false) {

            arv = mycompany.getFlightarv();

            sql = "SELECT * FROM `flights` WHERE `FLIGHT NO.` = '" + arv + "' ";

            price2 = Double.parseDouble(new ConnexionSQL().requetetoString(sql, "price"));

        }

        mycompany.subTotal = mycompany.numberofperson * (price1 + price2);
        mycompany.setpriceofFlight(price1, price2);

    }

}
