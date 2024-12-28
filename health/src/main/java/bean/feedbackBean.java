/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.adminClient;
import entity.Blog;
import entity.Feedback;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author palad
 */
@Named(value = "feedbackBean")
@SessionScoped
public class feedbackBean implements Serializable {

     adminClient adclient;
    
 
    int id;
    String name;
    String feedback;
    String email;
    Response rs;
  
    private Collection<Feedback> dataSCollection;
    private GenericType<Collection<Feedback>> genricCollection;
    public feedbackBean() {
         adclient = new adminClient();
                 dataSCollection = new ArrayList<>();

        genricCollection = new GenericType<Collection<Feedback>>() {
        };
    }

    public adminClient getAdclient() {
        return adclient;
    }

    public void setAdclient(adminClient adclient) {
        this.adclient = adclient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Collection<Feedback> getDataSCollection() {
        rs = adclient.getAllFeedbacks(Response.class);
        dataSCollection = rs.readEntity(genricCollection);
        return dataSCollection;
    }

    public void setDataSCollection(Collection<Feedback> dataSCollection) {
        this.dataSCollection = dataSCollection;
    }

    public GenericType<Collection<Feedback>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<Feedback>> genricCollection) {
        this.genricCollection = genricCollection;
    }
    
    
}
