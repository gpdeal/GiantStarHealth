/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giantstarhealth.beans;

/**
 *
 * @author jasmine_5376
 */
public class Facility {
    int facility_id;
    String facility_name = "";
    String state = "";
    String city = "";
    String street_address = "";
    String unit_number = "";
    String zip = "";
    String phone = "";
    
    public int getFacilityID() {
        return facility_id;
    }
    
    public void setFacilityID(int facility_id) {
        this.facility_id = facility_id;
    }
    
    public String getFacilityName() {
        return facility_name;
    }
    
    public void setFacilityName(String facility_name) {
        this.facility_name = facility_name;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStreetAddress() {
        return street_address;
    }
    
    public void setStreetAddress(String street_address) {
        this.street_address = street_address;
    }
    
    public String getUnitNumber() {
        return unit_number;
    }
    
    public void setUnitNumber(String unit_number) {
        this.unit_number = unit_number;
    }
    
    public String getZip() {
        return zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
