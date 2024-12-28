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
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author palad
 */
@Named(value = "doctorViewBean")
@SessionScoped
public class doctorViewBean implements Serializable {

    @EJB
    private userViewLocal userLocal;
    int id;
    String firstName;
    String lastName;
    String specialization;
    String profile;
    private List<User> activeDoctors;

    public doctorViewBean() {
    }

    public userViewLocal getUserLocal() {
        return userLocal;
    }

    public void setUserLocal(userViewLocal userLocal) {
        this.userLocal = userLocal;
    }

    public List<User> getActiveDoctors() {
        if (activeDoctors == null) {
            activeDoctors = userLocal.getAllActiveDoctor();
        }
        return activeDoctors;
    }

    public void setActiveDoctors(List<User> activeDoctors) {
        this.activeDoctors = activeDoctors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
 public String goToDoctorDetails(int doctorId) {
        // Redirect to doctor-single.xhtml with the doctorId as a query parameter
        return "doctorSingle.xhtml?faces-redirect=true&id=" + doctorId;
    }
}
