/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *Class Flight 
 * use to represente all the data for a flight 
 * 
 * 
 * 
 * @author zack
 */
public class Flight {

    protected String number;
    protected String depart;
    protected String date;
    protected String destination;
    protected String Time;
    protected double price;

    public Flight(String depart, String destination, String Time, String number, String date, double price) {
        
        this.number = number;
        this.depart = depart;
        this.destination = destination;
        this.Time = Time;
        this.price = price;
        this.date = date;

    }

    ///////////////////GET////////////////////////
    
    public String getNumber() {
        return number;
    }

    public String getdepart() {
        return depart;
    }

    public String getdestination() {
        return destination;
    }

    public String getTime() {
        return Time;
    }

    public double getPrice() {
        return price;

    }

    public String getDate() {
        return date;

    }

}
