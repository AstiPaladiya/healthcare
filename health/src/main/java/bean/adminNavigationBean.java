/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author palad
 */
@Named(value = "adminNavigationBean")
@SessionScoped
public class adminNavigationBean implements Serializable {
    String currentPage = "dashboard"; 
    /**
     * Creates a new instance of adminNavigationBean
     */
    public adminNavigationBean() {
    }
     // Navigation methods
    public String goToDashboard() {
//        currentPage = "dashboard";
        return "dashboard.xhtml"; // Stay on the same page while updating the content
    }

    public String goToRole() {
        currentPage = "role";
        return null; // Stay on the same page while updating the content
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }
    
}
