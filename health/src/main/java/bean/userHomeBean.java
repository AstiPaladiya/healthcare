/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.userViewLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author palad
 */
@Named(value = "userHomeBean")
@SessionScoped
public class userHomeBean implements Serializable {

    @EJB
    userViewLocal ulocal;
    Long activeDoctors;
Long activeUsers;
Long totalUsers;
Long totalSubscription;
    public userHomeBean() {
    }

    public userViewLocal getUlocal() {
        return ulocal;
    }

    public void setUlocal(userViewLocal ulocal) {
        this.ulocal = ulocal;
    }

    public Long getActiveDoctors() {
                activeDoctors = ulocal.countActiveDoctors();

        return activeDoctors;
    }

    public void setActiveDoctors(Long activeDoctors) {
        this.activeDoctors = activeDoctors;
    }

    public Long countActiveDoctor() {
        return activeDoctors;
    }

    public Long getActiveUsers() {
          activeUsers= ulocal.countActiveUsers();
        return activeUsers;
    }

    public void setActiveUsers(Long activeUsers) {
        this.activeUsers = activeUsers;
    }

    public Long getTotalUsers() {
            totalUsers= ulocal.countTotalUsers();
        return totalUsers;
    }

    public void setTotalUsers(Long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Long getTotalSubscription() {
        totalSubscription= ulocal.totalSubscription();
        return totalSubscription;
    }

    public void setTotalSubscription(Long totalSubscription) {
        this.totalSubscription = totalSubscription;
    }
    
    
}
