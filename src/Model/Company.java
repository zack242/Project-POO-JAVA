/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CompanyController;
import Controller.Connexion;

/**
 * Class company 
 * This classe is used to set the main user of the app
 * user can be i client 
 * user can be i employee 
 * 
 * @author zack
 */

//This classe is used to set the main user of the application 
public class Company {

    public Person user;
    public Connexion conn;
    public boolean oneway;
    public double subTotal;
    public double Total;
    public int numberofperson;

    protected String selectedFlightdep;
    protected String selectedFlightarv;
    protected double pricedep;
    protected double pricearv;

    public Company() {
        
        user = new Person("Guest", "", "");
        conn = new Connexion();
        oneway = true;
        numberofperson = 1;
        subTotal = 0;
        pricedep = 0;
        pricearv = 0;
        Total = 0;

    }
    ///////////////////GET /////////////////////////
    
    public String getNameuser() {
        return user.getName();
    }

    public String getFlightdep() {
        return selectedFlightdep;
    }

    public String getFlightarv() {
        return selectedFlightarv;
    }

    ////////////////SET////////////////////////////
    public void setuser() {
        if (conn.connected == true) {
            this.user = conn.user;
        }
    }

    public void setpriceofFlight(double pricedep, double pricearv) {

        this.pricedep = pricedep;
        this.pricearv = pricearv;

    }

    
    // To add the flight that select the user in the check out 
    public void addFlight(String selectedFlightdep, int oneway) {
        if (oneway == 0) {
            this.selectedFlightdep = selectedFlightdep;
        }
        if (oneway == 1) {
            this.selectedFlightarv = selectedFlightdep;
            this.oneway = false;
        }

    }

    //Use to reset all the attribute when the user click to the homepage
    public void reset() {
        
        oneway = true;
        numberofperson = 1;
        subTotal = 0;
        Total = 0;
        selectedFlightdep = null;
        selectedFlightarv = null;
        pricedep = 0;
        pricearv = 0;

    }

    ///Use to assigne the user to buy flights 
    public void buy() throws Exception {

        if (user instanceof Customer) {
            Customer A = (Customer) user;

            Total = A.buy(subTotal);

            new CompanyController().addbookedflight(A.getId(), selectedFlightdep, numberofperson, pricedep);
            if (oneway == false) {
                new CompanyController().addbookedflight(A.getId(), selectedFlightarv, numberofperson, pricearv);
            }

        } else {

            new CompanyController().addbookedflight(999, selectedFlightdep, numberofperson, pricedep);
            if (oneway == false) {
                new CompanyController().addbookedflight(999, selectedFlightarv, numberofperson, pricearv);
            }

            Total = subTotal;
        }

    }

}
