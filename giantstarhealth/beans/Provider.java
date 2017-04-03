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
public class Provider {
    int provider_id;
    String last_name = "";
    String first_name = "";
    String middle_name = "";
    String credentials = "";
    
    public int getProviderID() {
        return provider_id;
    }
    
    public void setProviderID(int provider_id) {
        this.provider_id = provider_id;
    }
    
    public String getLastName() {
        return last_name;
    }
    
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
       
    public String getFirstName() {
        return first_name;
    }
    
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    
    public String getMiddleName() {
        return middle_name;
    }
    
    public void setMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }
    
    public String getCredentials() {
        return credentials;
    }
    
    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
    
}
