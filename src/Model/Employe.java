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

//This classe containt all the action that can do an Employe delete / add // update flight / delete customer 
public class Employe extends Person {

    private int id_employe;
    public Flight selectedFlights;

    public Employe(String first_name, String last_name, String birthday, int id_employe) {

        super(first_name, last_name, birthday);
        this.id_employe = id_employe;

    }
    
    /////////////////GET /////////////////////////////
    
    public ResultSet getFlights() throws Exception {

        return new CompanyController().getFlights();
    }

     public ResultSet getCustomer() throws Exception {

        return new CompanyController().getCustomer();

    }

    public ResultSet getBookedFlight(int id_customer) throws Exception {

        return new CompanyController().getBookedFlight(id_customer);

    }

    public ResultSet getBookedFlight() throws Exception {

        return new CompanyController().getBookedFlight();

    }
    
    /////////////////SET////////////////////////////////
    public void setFlights(String number) throws Exception {

        selectedFlights = new CompanyController().getSelectedFlights(number);

    }

    public void addFlights(Flight flight) throws Exception {

        new CompanyController().addFlight(flight.getdepart(), flight.destination, flight.Time, flight.number, flight.date, flight.price);

    }

    
    //////////////////UPTADE///////////////////////////////
    
    public void UpdateFlights(Flight flight) throws Exception {

        new CompanyController().uptadeFlight(flight.getdepart(), flight.destination, flight.Time, flight.number, flight.date, flight.price, selectedFlights.getNumber());

    }

    
    /////////////////////DELETE//////////////////////////////////

    public void deleteCustomer(int id_customer) throws Exception {

        new CompanyController().deleteCustomer(id_customer);

    }

    public void deleteFlights(double id_customer, String numberofFly) throws Exception {

        new CompanyController().deleteFlights(id_customer, numberofFly);

    }
    
    
  public void DeleteFlights() throws Exception {

        new CompanyController().deleteFlights(selectedFlights.getNumber());
        new CompanyController().upttadeStatut(selectedFlights.getNumber());

    }


}
