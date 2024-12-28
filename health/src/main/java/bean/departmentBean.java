/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.userViewLocal;
import entity.Category;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author palad
 */
@Named(value = "departmentBean")
@SessionScoped
public class departmentBean implements Serializable {

    /**
     * Creates a new instance of departmentBean
     */
    @EJB
    userViewLocal userlocal;
    private List<Category> doctorCategories; // To store the fetched categories
    int id;
    String name;
    String description;
    String image;

    public departmentBean() {
    }

    public userViewLocal getUserlocal() {
        return userlocal;
    }

    public void setUserlocal(userViewLocal userlocal) {
        this.userlocal = userlocal;
    }

 

    public List<Category> getDoctorCategories() {
        if (doctorCategories == null) {
            doctorCategories = userlocal.getAllCategoriesForDoctor();
        }
        System.out.println(doctorCategories);
        return doctorCategories;
    }

    public void setDoctorCategories(List<Category> doctorCategories) {
        this.doctorCategories = doctorCategories;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String goToCategoryDetails(int categoryId) {
        return "doctor.xhtml?faces-redirect=true&id=" + categoryId;
    }

}
