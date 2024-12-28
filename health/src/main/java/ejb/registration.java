/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Role;
import entity.Subscription;
import entity.SubscriptionUser;
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author palad
 */
@Stateless
public class registration implements registrationLocal {

    @PersistenceContext(unitName = "health")
    EntityManager em;

    @Override
    public boolean isEmailUnique(String email) {
        // Query to check if an email already exists in the database
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class);
        query.setParameter("email", email);
        long count = query.getSingleResult();
        return count == 0; // If count is 0, the email is unique
    }

    @Override
    public int addUser(int roleId, int subscriptionId, String email, String firstName, String lastName, String password, BigInteger phoneNo, Date birthOfDate, String gender, String address, BigInteger emergency_no, String profile, int pincode, String state, String city, String specialization, String medicalLicence, String yearOfExperience, String degree, String certificate, String affilicateHospital, String currentPosition, String workShecdule, Date registrationDate, String bio, String hospitalName, String website, Date expiaryDate, String macAddress, String status) {
        try {
            Role role = em.find(Role.class, roleId);
            if (role == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + roleId);
            }
            Subscription sub = em.find(Subscription.class, subscriptionId);
            if (sub == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + subscriptionId);
            }
            User c = new User();
            c.setRoleId(role);
            c.setSubscriptionId(sub);
            c.setEmail(email);
            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setPassword(password);
            c.setPhoneNo(phoneNo);
            c.setDateOfBirth(birthOfDate);
            c.setGender(gender);
            c.setAddress(address);
            c.setEmergencyNo(emergency_no);
            c.setProfile(profile);
            c.setPincode(pincode);
            c.setState(state);
            c.setCity(city);
            c.setSpecialization(specialization);
            c.setMedicalLicense(medicalLicence);
            c.setYearOfExpirence(yearOfExperience);
            c.setDegree(degree);
            c.setCertification(certificate);
            c.setAffiliateHospital(affilicateHospital);
            c.setCurrentPosition(currentPosition);
            c.setWorkSchedule(workShecdule);
            c.setRegistrationDate(registrationDate);
            c.setBio(bio);
            c.setHospitalName(hospitalName);
            c.setWebsite(website);
            c.setExpiaryDate(expiaryDate);
            c.setMacAddress(macAddress);
            c.setStatus(status);
            Date currentDate = new Date();
            c.setCreatedAt(currentDate);
            c.setUpdatedAt(currentDate);
            em.persist(c);
            // After persisting, retrieve the generated userId
            em.flush();  // Make sure the entity is written to the database
            em.refresh(c);  // Refresh the entity to get the updated state
            System.out.println("Added successfully with User ID: " + c.getId());

            return c.getId(); // Return the generated user ID
        } catch (Exception eq) {
            eq.printStackTrace();
            System.out.println("Failed insertion");
            return 0; // Return 0 or handle the exception based on your needs
        }
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        // Use the named query with Role.class to return a list of Role entities
        return em.createNamedQuery("Subscription.findAll", Subscription.class).getResultList();
    }

    @Override
    public int getSubscriptionPeriodById(int subscriptionId) {
        // Fetch the subscription entity by ID
        Subscription subscription = em.find(Subscription.class, subscriptionId);

        if (subscription != null) {
            // Return the time period in days (assuming it's stored in months)
            return subscription.getTimePeriod(); // Convert months to days if needed
        } else {
            throw new IllegalArgumentException("Subscription ID not found: " + subscriptionId);
        }
    }

    @Override
    public void addSubscriptionUser(int userId, int subscriptionId, Date expiryDate, String paymentMode) {
        try {
            User uid = em.find(User.class, userId);
            if (uid == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + userId);
            }
            Subscription sub = em.find(Subscription.class, subscriptionId);
            if (sub == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + subscriptionId);
            }
            // Create a new SubscriptionUser object
            SubscriptionUser subscriptionUser = new SubscriptionUser();
            subscriptionUser.setUserId(uid);
            subscriptionUser.setSubscriptionId(sub);
            subscriptionUser.setExpiaryDate(expiryDate);
            subscriptionUser.setPaymentMode(paymentMode);
            Date currentDate = new Date();
            subscriptionUser.setCreatedAt(currentDate);
            subscriptionUser.setUpdatedAt(currentDate);
            em.persist(subscriptionUser);

            System.out.println("Subscription user added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding subscription user: " + e.getMessage());
        }
    }

    // Method to get roles excluding "Admin"
//    @Override
//    public List<Role> getRolesExcludingAdmin() {
//        try {
//            List<Role> roles = em.createQuery("SELECT r FROM Role r WHERE r.name != :adminRole", Role.class)
//                    .setParameter("adminRole", "Admin")
//                    .getResultList();
//            return roles;
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the error for debugging
//            return new ArrayList<>(); // Return an empty list if there's an error
//        }
//
//    }

}
