/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giantstarhealth.beans;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Galen
 */
public class Provider_Result {
    Provider provider = null;
    List<Specialty> specialties = new LinkedList<>();
    List<Facility> facilities = new LinkedList<>();
    
    public Provider getProvider() {
        return provider;
    }
    
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    public List<Specialty> getSpecialties() {
        return specialties;
    }
    
    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }
    
    public List<Facility> getFacilities() {
        return facilities;
    }
    
    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
