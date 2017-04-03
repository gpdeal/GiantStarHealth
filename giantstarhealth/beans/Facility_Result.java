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
public class Facility_Result {
    Facility facility = null;
    List<Provider_Result> providerResult = new LinkedList<>();
    
    public Facility getFacility() {
        return facility;
    }
    
    public void setFacility(Facility facility) {
        this.facility = facility;
    }
    
    public List<Provider_Result> getProviderResult() {
        return providerResult;
    }
    
    public void setProviderResult(List<Provider_Result> providerResult) {
        this.providerResult = providerResult;
    }
}
