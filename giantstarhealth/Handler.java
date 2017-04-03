/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giantstarhealth;

import giantstarhealth.beans.*;
import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Galen, jasmine_5376
 */
public class Handler {

    Connection conn = null;

    public final String QUERY_TEMPLATE
            = "select provider_id, facility_id, specialty_id, first_name, last_name,specialty_name, "
            + "facility_name, state, city, street_address, unit_number, zip_code, phone "
            + "from provider "
            + "inner join specializes_in on si_provider_id = provider_id "
            + "inner join specialty on specialty_id = si_specialty_id "
            + "inner join works_at on wa_provider_id = provider_id "
            + "inner join facility on facility_id = wa_facility_id ";

    public Handler() {
        try {
            // create our mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/GiantStarHealth";
            Class.forName(myDriver).newInstance();
            conn = DriverManager.getConnection(myUrl, "root", "2ondowned");

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public List<Provider_Result> getProviders(String firstName, String lastName, String specialtyName, String facilityName) throws Exception {
        // our SQL SELECT query
        String query = QUERY_TEMPLATE;
        if (firstName != null && lastName != null) {
            query += "where first_name = '" + firstName + "' and last_name = '" + lastName + "' ";
        } else if (firstName != null) {
            query += "where first_name = '" + firstName + "' ";
        } else if (lastName != null) {
            query += "where last_name = '" + lastName + "' ";
        } else if (specialtyName != null) {
            query += "where specialty_name = '" + specialtyName + "' ";
        } else if (facilityName != null) {
            query += "where facility_name = '" + facilityName + "' ";
        } else {
            // something went wrong
            throw new Exception();
        }
        query += "order by provider_id;"; // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java, resultset
        List<Provider_Result> provider_result_list = new LinkedList<>();
        List<Facility> facility_list = new LinkedList<>();
        List<Specialty> specialty_list = new LinkedList<>();
        Set<Integer> facilitySet = new HashSet<>();
        Set<Integer> specialtySet = new HashSet<>();

        Provider_Result currentProvider_result = null;
        Provider provider = null;
        int last_provider_id = -1;

        while (rs.next()) {
            // if new provider, add last provider_result to list and make new provider
            int current_provider_id = rs.getInt("provider_id");
            if (current_provider_id != last_provider_id) {
                last_provider_id = current_provider_id;
                
                // new provider encountered - add previously built one to the list and 
                // this is adding provider to provider_result after round 1
                if (currentProvider_result != null) {
                    currentProvider_result.setFacilities(facility_list);
                    currentProvider_result.setSpecialties(specialty_list);
                    provider_result_list.add(currentProvider_result);
                }

                // start building new provider
                currentProvider_result = new Provider_Result();
                facility_list = new LinkedList<>();
                specialty_list = new LinkedList<>();
                facilitySet = new HashSet<>();
                specialtySet = new HashSet<>();

                // set Provider object
                provider = new Provider();
                provider.setProviderID(rs.getInt("provider_id"));
                provider.setFirstName(rs.getString("first_name"));
                provider.setLastName(rs.getString("last_name"));
                currentProvider_result.setProvider(provider);  // add Provider object to Provider_Result object

                // add facility
                Integer facilityId = new Integer(rs.getInt("facility_id"));
                if (!facilitySet.contains(facilityId)) {
                    Facility newFacility = addNewFacility(rs);
                    facility_list.add(newFacility);
                    // add facility id to set
                    facilitySet.add(facilityId);
                }

                // add specialty
                Integer specialtyId = new Integer(rs.getInt("specialty_id"));
                if (!specialtySet.contains(specialtyId)) {
                    Specialty newSpecialty = addNewSpecialtyId(rs);
                    specialty_list.add(newSpecialty);
                    // add specialty id to set
                    specialtySet.add(specialtyId);
                }
            } else {
               Integer facilityId = new Integer(rs.getInt("facility_id"));
                if (!facilitySet.contains(facilityId)) {
                    Facility newFacility = addNewFacility(rs);
                    facility_list.add(newFacility);
                    // add facility id to set
                    facilitySet.add(facilityId);
                }

                Integer specialtyId = new Integer(rs.getInt("specialty_id"));
                if (!specialtySet.contains(specialtyId)) {
                    Specialty newSpecialty = addNewSpecialtyId(rs);
                    specialty_list.add(newSpecialty);
                    // add specialty id to set
                    specialtySet.add(specialtyId);
                }

            }
        }
        // fencepost problem - add the last provider to provider result list
        currentProvider_result.setFacilities(facility_list);
        currentProvider_result.setSpecialties(specialty_list);
        provider_result_list.add(currentProvider_result);

        st.close();
        return provider_result_list;
    }

    private Facility addNewFacility(ResultSet rs) throws SQLException {
        // set new Facility and add to specialty list
        Facility facility = new Facility();
        facility.setFacilityName(rs.getString("facility_name"));
        facility.setState(rs.getString("state"));
        facility.setCity(rs.getString("city"));
        facility.setStreetAddress(rs.getString("street_address"));
        facility.setUnitNumber(rs.getString("unit_number"));
        facility.setZip(rs.getString("zip_code"));
        facility.setPhone(rs.getString("phone"));

        return facility;
    }

    private Specialty addNewSpecialtyId(ResultSet rs) throws SQLException {
        // set new Specialty and add to specialty list
        Specialty specialty = new Specialty();
        specialty.setSpecialtyName(rs.getString("specialty_name"));
        return specialty;
    }

}
