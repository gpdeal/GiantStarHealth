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
public class Specialty {
    int specialty_id;
    String specialty_name = "";
    
    public int getSpecialtyID() {
        return specialty_id;
    }
    
    public void setSpecialtyID(int specialty_id) {
        this.specialty_id = specialty_id;
    }
    
    public String getSpecialtyName() {
        return specialty_name;
    }
    
    public void setSpecialtyName(String specialty_name) {
        this.specialty_name = specialty_name;
    }
}
