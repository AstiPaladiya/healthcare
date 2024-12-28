/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.adminClient;
import ejb.adminLocal;
import entity.Category;
import entity.Role;
import entity.Blog;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author palad
 */
@Named(value = "blogBean")
@SessionScoped
public class blogBean implements Serializable {

    adminClient adclient;
    
    @EJB 
            adminLocal al;
    int id;
    User userId;
    String name;
    String description;
    String image;
    String status;
    Response rs;
    Blog current;
   String statusMessage;
    String statusColor;
    private Collection<Blog> dataSCollection;
    private GenericType<Collection<Blog>> genricCollection;
    private Blog selectedBlog;
    public blogBean() {
        adclient = new adminClient();
        genricCollection = new GenericType<Collection<Blog>>() {
        };
       
         current = new Blog();

        userId = new User();
        status="Active";

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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public adminLocal getAl() {
        return al;
    }

    public void setAl(adminLocal al) {
        this.al = al;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

  
  // Toggle role status
    public void toggleBlogStatus() {
        if (selectedBlog != null) {
            try {
                // Call the API to toggle the status
                Response response = adclient.toggleBlogStatus(String.valueOf(selectedBlog.getId()));

                if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                    // Toggle the role's status locally
                    if ("Active".equals(selectedBlog.getStatus())) {
                        selectedBlog.setStatus("Block");
                    } else {
                        selectedBlog.setStatus("Active");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Log the error for debugging purposes
            }
        }
    }
    public Collection<Blog> getDataSCollection() {
        rs = adclient.getAllBlogs(Response.class);
        dataSCollection = rs.readEntity(genricCollection);
//      dataSCollection = al.getAllBlogs();

        return dataSCollection;
    }

    public Object getSelectedBlog() {
        return selectedBlog;
    }

    public void setSelectedBlog(Blog selectedBlog) {
        this.selectedBlog = selectedBlog;
    }

    public void setDataSCollection(Collection<Blog> dataSCollection) {
        this.dataSCollection = dataSCollection;
    }

    public GenericType<Collection<Blog>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<Blog>> genricCollection) {
        this.genricCollection = genricCollection;
    }

    public Blog getCurrent() {
        return current;
    }

    public void setCurrent(Blog current) {
        this.current = current;
    }
    
 public String redirectToEdit() {
        return "blogView.xhtml?faces-redirect=true";
    }
}
