/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.doctorLocal;
import entity.HealthRecord;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author palad
 */
@Named(value = "adminAppointmentBean")
@SessionScoped
public class adminAppointmentBean implements Serializable {

    @EJB
    doctorLocal dlocal;

     private String checkupBookingId;
    private List<HealthRecord> appointments;

    public adminAppointmentBean() {
    }

    public doctorLocal getDlocal() {
        return dlocal;
    }

    public void setDlocal(doctorLocal dlocal) {
        this.dlocal = dlocal;
    }

    public String getCheckupBookingId() {
        return checkupBookingId;
    }

    public void setCheckupBookingId(String checkupBookingId) {
        this.checkupBookingId = checkupBookingId;
    }

    public List<HealthRecord> getAppointments() {
        checkupBookingId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("checkupBookingId");
        appointments=dlocal.findAppointmentsByCheckupBookingId(Integer.valueOf(checkupBookingId));
        return appointments;
    }

    public void setAppointments(List<HealthRecord> appointments) {
        this.appointments = appointments;
    }

}
