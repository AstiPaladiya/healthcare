/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.doctorClient;
import ejb.doctorLocal;
import entity.CheckupBooking;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import record.KeepRecord;

/**
 *
 * @author palad
 */
@Named(value = "checkupBookingBean")
@SessionScoped
public class checkupBookingBean implements Serializable {

    @EJB
    doctorLocal dtLocal;
    doctorClient dtclient;
    int id;
    int categoryId;
    int checkupId;
//    int bussinessId;
    User bussinessCId;
    String schedule;
    float price;
    String status;
    String username;
    CheckupBooking current;
    Response rs;
    String responseMessage;
    private CheckupBooking selectedRole;

    private Collection<CheckupBooking> dataSCollection;
    private GenericType<Collection<CheckupBooking>> genricCollection;

    public checkupBookingBean() {
        dtclient = new doctorClient();
        dataSCollection = new ArrayList<>();
        genricCollection = new GenericType<Collection<CheckupBooking>>() {
        };
        current = new CheckupBooking();
        bussinessCId = new User();
        status = "Active";
    }

    public String addCheckupbooking() {
        // Set a static username directly
//        KeepRecord.setUsername("asti@gmail.com");
        // Fetch the userId based on username or email
        username = KeepRecord.getUsername();
        System.out.println("Username retrieved from KeepRecord: " + username);  // Debugging line

        // Fetch the User object based on username
        User user = dtLocal.getUserIdByUsername(username);

        if (user != null) {
            try {
                // Use the userId (assuming user has a method getId()) and pass it to addCheckupBooking
                dtclient.addCheckupBooking(String.valueOf(user.getId()), schedule, String.valueOf(price), status);
                return "checkupBooking.xhtml?faces-redirect=true"; // Navigate to the checkup booking page
            } catch (Exception e) {
                e.printStackTrace();
                return "failure"; // Return failure if there's an error
            }
        } else {
            // Handle the case when no user is found
            System.out.println("User not found for username: " + username);
            return "failure"; // You can redirect to a different page or handle the error
        }
    }
    // Toggle role status

    public void toggleCheckupBookingStatus() {
        if (selectedRole != null) {
            try {
                // Call the API to toggle the status
                Response response = dtclient.toggleCheckupBookingStatus(String.valueOf(selectedRole.getId()));

                if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                    // Toggle the role's status locally
                    if ("Active".equals(selectedRole.getStatus())) {
                        selectedRole.setStatus("Block");
                    } else {
                        selectedRole.setStatus("Active");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Log the error for debugging purposes
            }
        }
    }
 public String updateCheckupBooking() {
        schedule = current.getSchedule();
        price = current.getPrice();
        status = current.getStatus();
        checkupId = current.getId();
        dtclient.updateCheckupBooking(String.valueOf(checkupId), schedule, String.valueOf(price), status);
        current = new CheckupBooking();
        return "checkupBooking.xhtml?faces-redirect=true";
    }
    // Method to fetch checkup bookings based on static username
    public List<CheckupBooking> getCheckupBookingsByUsername() {
//                KeepRecord.setUsername("asti@gmail.com");

        // Retrieve username from KeepRecord (already set statically)
        username = KeepRecord.getUsername();
        System.out.println("Username retrieved from KeepRecord: " + username);

        // Fetch the User object based on username
        User user = dtLocal.getUserIdByUsername(username);

        if (user != null) {
            try {
                // Fetch CheckupBookings for the user
                return dtLocal.getCheckupBookingsByUsername(username); // Use the EJB to fetch bookings for the user
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<>();  // Return an empty list in case of an error
            }
        } else {
            System.out.println("No user found for username: " + username);
            return new ArrayList<>();  // Return empty list if no user is found
        }
    }

    public CheckupBooking getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(CheckupBooking selectedRole) {
        this.selectedRole = selectedRole;
    }

    public doctorLocal getDtLocal() {
        return dtLocal;
    }

    public void setDtLocal(doctorLocal dtLocal) {
        this.dtLocal = dtLocal;
    }

    public int getCheckupId() {
        return checkupId;
    }

    public void setCheckupId(int checkupId) {
        this.checkupId = checkupId;
    }

    public User getBussinessCId() {
        return bussinessCId;
    }

    public void setBussinessCId(User bussinessCId) {
        this.bussinessCId = bussinessCId;
    }

    public doctorClient getDtclient() {
        return dtclient;
    }

    public void setDtclient(doctorClient dtclient) {
        this.dtclient = dtclient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CheckupBooking getCurrent() {
        return current;
    }

    public void setCurrent(CheckupBooking current) {
        this.current = current;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Collection<CheckupBooking> getDataSCollection() {
        // Call method to get checkup bookings based on username
        dataSCollection = getCheckupBookingsByUsername();
        return dataSCollection;
    }

    public void setDataSCollection(Collection<CheckupBooking> dataSCollection) {
        this.dataSCollection = dataSCollection;
    }

    public GenericType<Collection<CheckupBooking>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<CheckupBooking>> genricCollection) {
        this.genricCollection = genricCollection;
    }

    public String redirectToEdit() {
//            return "edit.jsf";
//             FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("id", 20);
//            System.out.println("Static ID set in request: 20");
        return "checkupBookingEdit.xhtml?faces-redirect=true";
    }
      public String redirectToAppointment() {
//            return "edit.jsf";
//             FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("id", 20);
//            System.out.println("Static ID set in request: 20");
        return "viewAppointment.xhtml?faces-redirect=true&checkupBookingId="+current.getId();
    }
}
