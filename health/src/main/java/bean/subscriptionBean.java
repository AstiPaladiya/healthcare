/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.adminClient;
import entity.Category;
import entity.Role;
import entity.Subscription;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author palad
 */
@Named(value = "subscriptionBean")
@SessionScoped
public class subscriptionBean implements Serializable {

    adminClient adclient;
    /**
     * Creates a new instance of subscriptionBean
     */
    int id;
    int subscriptionId;
    String plan_name;
    String plan_detail;
    String status;
    int time_period;
    float price;
    Subscription current;
    Response rs;
    private Collection<Subscription> dataSCollection;
    private GenericType<Collection<Subscription>> genricCollection;

    public subscriptionBean() {
        adclient = new adminClient();
        dataSCollection = new ArrayList<>();
        genricCollection = new GenericType<Collection<Subscription>>() {
        };
        current = new Subscription();
    }

    public String addSubscription() {
        try {
            adclient.addSubscription(plan_name, plan_detail, String.valueOf(price), String.valueOf(time_period), status);
            return "subscription.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

    public String deleteSubscription() {
        adclient.deleteSubscription(String.valueOf(subscriptionId));
        return "subscription.xhtml?faces-redirect=true";
    }

//    public String updateSubscription() {
//        plan_name = current.getPlanName();
//        plan_detail = current.getPlanDetail();
//        price = current.getPrice();
//        time_period = current.getTimePeriod();
//        status = current.getStatus();
//        subscriptionId = current.getId();
//        adclient.updateSubscription(String.valueOf(subscriptionId), plan_name, plan_detail, String.valueOf(price), String.valueOf(time_period), status);
//        current = new Subscription();
//        return "subscription.xhtml?faces-redirect=true";
//    }

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

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPlan_detail() {
        return plan_detail;
    }

    public void setPlan_detail(String plan_detail) {
        this.plan_detail = plan_detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTime_period() {
        return time_period;
    }

    public void setTime_period(int time_period) {
        this.time_period = time_period;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Subscription getCurrent() {
        return current;
    }

    public void setCurrent(Subscription current) {
        this.current = current;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Collection<Subscription> getDataSCollection() {
        rs = adclient.getAllSubscriptions(Response.class);
        dataSCollection = rs.readEntity(genricCollection);
        return dataSCollection;
    }

    public void setDataSCollection(Collection<Subscription> dataSCollection) {
        this.dataSCollection = dataSCollection;
    }

    public GenericType<Collection<Subscription>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<Subscription>> genricCollection) {
        this.genricCollection = genricCollection;
    }

    public String redirectToEdit() {
//            return "edit.jsf";
//             FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("id", 20);
//            System.out.println("Static ID set in request: 20");
        return "subscriptionUserView.xhtml?faces-redirect=true";
    }

}
