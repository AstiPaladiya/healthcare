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
@Named(value = "contactUsBean")
@SessionScoped
public class contactUsBean implements Serializable {

    @EJB
    userViewLocal uViewLocal;
    /**
     * Creates a new instance of contactUsBean
     */
    String name;
    String email;
    String message;

    public contactUsBean() {
    }

    public String addFeedback() {
        uViewLocal.addFeedBack(name, email, message);
        name = "";
        email = "";
        message = "";
        return "contactUs.xhtml?faces-redirect=true";
    }

    public userViewLocal getuViewLocal() {
        return uViewLocal;
    }

    public void setuViewLocal(userViewLocal uViewLocal) {
        this.uViewLocal = uViewLocal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
