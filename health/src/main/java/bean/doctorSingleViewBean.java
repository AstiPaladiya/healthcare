/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.userViewLocal;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author palad
 */
@Named(value = "doctorSingleViewBean")
@SessionScoped
public class doctorSingleViewBean implements Serializable {

    @EJB
    private userViewLocal userLocal;

    private int id; // Holds the doctor ID from the URL
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
    private User selectedDoctor; // Holds the details of the selected doctor

    public doctorSingleViewBean() {
    }

    public userViewLocal getUserLocal() {
        return userLocal;
    }

    public void setUserLocal(userViewLocal userLocal) {
        this.userLocal = userLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(User selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    public void loadDoctorDetails() {
        System.out.println("Loading doctor details for ID: " + id);
        if (id > 0) {
            selectedDoctor = userLocal.getDoctorById(id); // Fetch the doctor by ID
            if (selectedDoctor != null) {
                System.out.println("Doctor loaded: " + selectedDoctor.getFirstName());
            } else {
                System.out.println("No doctor found for ID: " + id);
            }
        } else {
            System.out.println("Invalid ID: " + id);
        }
    }
}
