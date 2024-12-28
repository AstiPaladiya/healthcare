/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.secureUserClient;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palad
 */
@Named(value = "userHelloBean")
@RequestScoped
public class userHelloBean {

      secureUserClient cl;
    String secureHello;
    String message="";

    
    public String getMessage() {
        return message;
       
    }

    /**
     * Creates a new instance of HelloBean
     */
    public void setMessage(String message) {    
        this.message = message;
    }
    public userHelloBean() {
    }
    
    public String getSecureHello() {
        try{
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      //String username = request.getSession().getAttribute("username").toString();
        //String password = request.getSession().getAttribute("password").toString();
       
        // String username = KeepRecord.getUsername();
      // String password = KeepRecord.getPassword();
        cl = new secureUserClient();
         message="";
        return cl.sayHello();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            message="You are Forbidden to access";
        }
        return null;
     }

    public void setSecureHello(String secureHello) {
        this.secureHello = secureHello;
    }
  
}
