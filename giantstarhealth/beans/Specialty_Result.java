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
 * @author jasmine_5376
 */
public class Specialty_Result {
    Specialty specialty = null;
    List<Provider_Result> providers = new LinkedList<>();
    
    public Specialty getSpecialty() {
        return specialty;
    }
    
    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
    
    public List<Provider_Result> getProviderResults() {
        return providers;
    }
    
    public void setProviderResults(List<Provider_Result> providers) {
        this.providers = providers;
    }
}
