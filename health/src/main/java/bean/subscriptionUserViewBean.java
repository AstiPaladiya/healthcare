///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
// */
//package bean;
//
//import ejb.adminLocal;
//import entity.SubscriptionUser;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
//import java.io.Serializable;
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.List;
//import javax.ejb.EJB;
//
///**
// *
// * @author palad
// */
//@Named(value = "subscriptionUserViewBean")
//@SessionScoped
//public class subscriptionUserViewBean implements Serializable {
//
//    @EJB
//    adminLocal adLocal;
//
//    private int subscriptionId;
//
//    private int id;
//    private Date expiryDate;
//    private String paymentMode;
//    private int userId;
//    SubscriptionUser subscriptionUser;
//
//    public adminLocal getAdLocal() {
//        return adLocal;
//    }
//
//    public void setAdLocal(adminLocal adLocal) {
//        this.adLocal = adLocal;
//    }
//
//    public int getSubscriptionId() {
//        return subscriptionId;
//    }
//
//    public void setSubscriptionId(int subscriptionId) {
//        this.subscriptionId = subscriptionId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPaymentMode() {
//        return paymentMode;
//    }
//
//    public void setPaymentMode(String paymentMode) {
//        this.paymentMode = paymentMode;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public Date getExpiryDate() {
//        return expiryDate;
//    }
//
//    public void setExpiryDate(Date expiryDate) {
//        this.expiryDate = expiryDate;
//    }
//
//    public SubscriptionUser getSubscriptionUser() {
//        return subscriptionUser;
//    }
//
//    public void setSubscriptionUser(SubscriptionUser subscriptionUser) {
//        this.subscriptionUser = subscriptionUser;
//    }
//
//    public subscriptionUserViewBean() {
//    }
//    // Method to load SubscriptionUser data based on subscriptionId
//
//    public void loadSubscriptionUser() {
//        if (subscriptionId > 0) {
//            subscriptionUser = adLocal.findSubscriptionUserById(subscriptionId);
//            if (subscriptionUser != null) {
//                this.id = subscriptionUser.getId();
//                this.expiryDate = subscriptionUser.getExpiaryDate();
//                this.paymentMode = subscriptionUser.getPaymentMode();
//                this.userId = subscriptionUser.getUserId();
//            }
//        }
//    }
//
//}
