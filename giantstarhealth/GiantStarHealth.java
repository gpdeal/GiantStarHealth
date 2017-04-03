
package giantstarhealth;

//import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import giantstarhealth.beans.*;
import java.util.List;


public class GiantStarHealth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Handler handler = new Handler();
        
        try {
            List<Provider_Result> pResultList = handler.getProviders(null, "McGonigle", null, null);
            
            for (Provider_Result pr : pResultList) {
                Provider provider = pr.getProvider();
                System.out.println("Provider name: " + provider.getFirstName() + " " + provider.getLastName());
                System.out.println("Specialties:");
                for (Specialty s : pr.getSpecialties()) {
                    System.out.println("\t" + s.getSpecialtyName());
                }
                System.out.println("Facilities:");
                for (Facility f : pr.getFacilities()) {
                    System.out.println("\t" + f.getFacilityName());
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(GiantStarHealth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
