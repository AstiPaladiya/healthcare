
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Role;
import entity.Subscription;
import javax.ejb.Local;
import entity.User;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
/**
 *
 * @author palad
 */
@Local
public interface registrationLocal {
        int addUser(int roleId,int subscriptionId,String email,String firstName,String lastName,String password,BigInteger phoneNo,Date birthOfDate,String gender,String address,BigInteger emergency_no,String profile,int pincode,String state,String city,String specialization,String medicalLicence,String yearOfExperience,String degree,String certificate,String affilicateHospital,String currentPosition,String workShecdule,Date registrationDate,String bio,String hospitalName,String website,Date expiaryDate,String macAddress,String status);
 boolean isEmailUnique(String email);
     public List<Subscription> getAllSubscriptions();

   int getSubscriptionPeriodById(int subscriptionId);
   void addSubscriptionUser(int userId, int subscriptionId, Date expiryDate, String paymentMode);
// public List<Role> getRolesExcludingAdmin();
}
