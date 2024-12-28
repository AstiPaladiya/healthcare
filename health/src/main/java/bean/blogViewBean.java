/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.userViewLocal;
import entity.Blog;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author palad
 */
@Named(value = "blogViewBean")
@SessionScoped
public class blogViewBean implements Serializable {

    @EJB
    private userViewLocal userLocal;
    String name;
    String description;
    String image;
    int id;
    String status;
    private List<Blog> activeBlogs;

    public blogViewBean() {
    }

    public userViewLocal getUserLocal() {
        return userLocal;
    }

    public void setUserLocal(userViewLocal userLocal) {
        this.userLocal = userLocal;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Blog> getActiveBlogs() {
        if (activeBlogs == null) {
            activeBlogs = userLocal.getAllActiveBlog();
        }
        return activeBlogs;
    }

    public void setActiveBlogs(List<Blog> activeBlogs) {
        this.activeBlogs = activeBlogs;
    }

}
