/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait.dao.cars;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author A00261481
 */

@XmlRootElement(name="cars")
@XmlType(propOrder = {"id", "make", "model", "mileage", "fuel", "transmission"})
public class Cars {
    
    
    private int id;
    private String make;
    private String model;
    private String mileage;
    private String fuel;
    private String transmission;

    public Cars(int id, String make, String model, String mileage, String fuel, String transmission) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.fuel = fuel;
        this.transmission = transmission;
    }
    
    public Cars(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    
    
}
