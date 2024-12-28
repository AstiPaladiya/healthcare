/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import client.adminClient;
import entity.Category;
import entity.Product;
import entity.Subscription;
import entity.User;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
/**
 *
 * @author palad
 */
@Named(value = "productBean")
@SessionScoped
public class productBean implements Serializable {
    adminClient adclient;
    int id;
    Category categoryId;
    User userId;
    String company_name;
    String prescription;
    String medicine_name;
    String description;
    String img1;
    String img2;
    String img3;
    String img4;
    String status;
    int quantity;
    int available_quantity;
    float price;
    float offer;
    Product current;
    Response rs;
    private Collection<Product> dataSCollection;
    private GenericType<Collection<Product>> genricCollection;    
    public productBean() {
          adclient = new adminClient();
        dataSCollection = new ArrayList<>();
        genricCollection = new GenericType<Collection<Product>>() {
        };
        current = new Product();
                categoryId = new Category();
                userId=new User();

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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }


    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getOffer() {
        return offer;
    }

    public void setOffer(float offer) {
        this.offer = offer;
    }

    public Product getCurrent() {
        return current;
    }

    public void setCurrent(Product current) {
        this.current = current;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Collection<Product> getDataSCollection() {
         rs = adclient.getAllProducts(Response.class);
        dataSCollection = rs.readEntity(genricCollection);
        return dataSCollection;
    }

    public void setDataSCollection(Collection<Product> dataSCollection) {
        this.dataSCollection = dataSCollection;
    }

    public GenericType<Collection<Product>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<Product>> genricCollection) {
        this.genricCollection = genricCollection;
    }
    
}
