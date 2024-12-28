/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.userViewLocal;
import entity.CheckupBooking;
import entity.HealthRecord;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import record.KeepRecord;

/**
 *
 * @author palad
 */
@Named(value = "userAppointment")
@SessionScoped
public class userAppointment implements Serializable {

    @EJB
    userViewLocal uViewLocal;
    /**
     * Creates a new instance of userAppointment
     */
    int id;
    String email;
    String name;
    Date appointmentDate;
    Time apointmentTime;
    String message;
    int selectedSchedule;
    BigInteger phoneNo;
    String userId;
    String firstName;
    String lastName;
    String schedule;
    private String status;
    int bussinessId;

    User uid;
    int patientId;
    String username;
    private List<User> activeDoctors;
    private String selectedDoctor;
    private List<CheckupBooking> availableSchedules;  // List of schedules for the selected doctor
//    private List<HealthRecord> healthRecords;

    public userAppointment() {
        uid = new User();
        status = "Pending";
    }

    public userViewLocal getuViewLocal() {
        return uViewLocal;
    }

    public void setuViewLocal(userViewLocal uViewLocal) {
        this.uViewLocal = uViewLocal;
    }

    public List<User> getActiveDoctors() {
        if (activeDoctors == null) {
            activeDoctors = uViewLocal.getAllActiveDoctor();
        }
        return activeDoctors;
    }

    public void setActiveDoctors(List<User> activeDoctors) {
        this.activeDoctors = activeDoctors;
    }

    public String getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(String selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//method
    public List<User> activeDoctors() {
        if (activeDoctors == null) {
            activeDoctors = uViewLocal.getAllActiveDoctor();
        }
        return activeDoctors;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getApointmentTime() {
        return apointmentTime;
    }

    public void setApointmentTime(Time apointmentTime) {
        this.apointmentTime = apointmentTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSelectedSchedule() {
        return selectedSchedule;
    }

    public void setSelectedSchedule(int selectedSchedule) {
        this.selectedSchedule = selectedSchedule;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getBussinessId() {
        return bussinessId;
    }

    public void setBussinessId(int bussinessId) {
        this.bussinessId = bussinessId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    // Method to fetch available schedules for the selected doctor

    public List<CheckupBooking> getAvailableSchedules() {
        // Fetch schedules from EJB or business logic layer
        // Example: availableSchedules = uViewLocal.getSchedulesForDoctor(selectedDoctor);
        availableSchedules = uViewLocal.fetchDoctorSchedule();  // Modify this method as per your logic

        return availableSchedules;
    }

    public void setAvailableSchedules(List<CheckupBooking> availableSchedules) {
        this.availableSchedules = availableSchedules;
    }

    public User getUid() {
        return uid;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String addRecord() {
        // Check if the user is logged in
        username = KeepRecord.getUsername();
        if (username == null || username.isEmpty()) {
            // Redirect to login page if not logged in
            return "/login.xhtml?faces-redirect=true";
        } else {

            System.out.println("Username retrieved from KeepRecord: " + username); // Debugging line

            // Fetch the User object based on username
            User user = uViewLocal.getUserIdByUsername(username);

            // Proceed with adding the record
            uViewLocal.addHealthrecord(selectedSchedule, user.getId(), appointmentDate, name, phoneNo, email, message, status);
            name = "";              // Reset name to an empty string
            email = "";             // Reset email to an empty string
            message = "";           // Reset message to an empty string
            appointmentDate = null; // Reset date to null to represent no date selected

            return "appointment.xhtml?faces-redirect=true";
        }
    }

//    public List<HealthRecord> getHealthRecords() {
//        username = KeepRecord.getUsername();
//
//        System.out.println("Username retrieved from KeepRecord: " + username); // Debugging line
//
//        if (username != null && !username.isEmpty()) {
//
//            // Fetch the User object based on username
//            User user = uViewLocal.getUserIdByUsername(username);
//            healthRecords = uViewLocal.getUserByRecord(user.getId());
//        }
//        return healthRecords;
//
//    }

//    public void setHealthRecords(List<HealthRecord> healthRecords) {
//        this.healthRecords = healthRecords;
//    }

}
