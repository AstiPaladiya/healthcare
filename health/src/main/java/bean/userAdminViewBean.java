/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.adminClient;
import ejb.adminLocal;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author palad
 */
@Named(value = "userAdminViewBean")
@SessionScoped
public class userAdminViewBean implements Serializable {

    @EJB
    adminLocal adLocal;
    adminClient adclient;
    int id;
    private int roleId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private BigInteger phoneNo;
    private Date birthOfDate;
    private String gender;
    private String address;
    private BigInteger emergencyNo;
    private String profile;
    private int pincode;
    private String state;
    private String city;
    private String specialization;
    private String medicalLicence;
    private String yearOfExperience;
    private String degree;
    private String certificate;
    private String affilicateHospital;
    private String currentPosition;
    private String workSchedule;
    private Date registrationDate;
    private String bio;
    private String hospitalName;
    private String website;
    private Date expiryDate;
    private String macAddress;
    private String status;
    private int subscriptionId;
    User selectedUser;
    private int selectedUserId; // Store the selected user's ID

    private List<User> getUsers;

    public userAdminViewBean() {
        adclient = new adminClient();

    }

    public adminLocal getAdLocal() {
        return adLocal;
    }

    public void setAdLocal(adminLocal adLocal) {
        this.adLocal = adLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getEmergencyNo() {
        return emergencyNo;
    }

    public void setEmergencyNo(BigInteger emergencyNo) {
        this.emergencyNo = emergencyNo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMedicalLicence() {
        return medicalLicence;
    }

    public void setMedicalLicence(String medicalLicence) {
        this.medicalLicence = medicalLicence;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getAffilicateHospital() {
        return affilicateHospital;
    }

    public void setAffilicateHospital(String affilicateHospital) {
        this.affilicateHospital = affilicateHospital;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public adminClient getAdclient() {
        return adclient;
    }

    public void setAdclient(adminClient adclient) {
        this.adclient = adclient;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public int getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(int selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    // Toggle role status
    public void toggleUserStatus() {
        if (selectedUser != null) {
            try {
                // Call the API to toggle the status
                Response response = adclient.toggleUserStatus(String.valueOf(selectedUser.getId()));

                if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                    // Toggle the role's status locally
                    if ("Active".equals(selectedUser.getStatus())) {
                        selectedUser.setStatus("Block");
                    } else {
                        selectedUser.setStatus("Active");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Log the error for debugging purposes
            }
        }
    }

    public List<User> getUsers() {
        if (getUsers == null) {
            getUsers = adLocal.getAllUsers();
        }
        return getUsers;
    }

    public void setGetUsers(List<User> getUsers) {
        this.getUsers = getUsers;
    }

 public String redirectToEdit(User getUsers) {
    if (getUsers != null) {
        this.selectedUserId = getUsers.getId(); // Set the user ID
        this.selectedUser = adLocal.findUserById(selectedUserId); // Fetch user details
        return "userAdminSingleView.xhtml?faces-redirect=true"; // Redirect to userSingleViewPage
    }
    return null; // Return null if no user is selected
}


}
