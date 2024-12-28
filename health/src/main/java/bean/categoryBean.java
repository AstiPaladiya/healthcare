/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.adminClient;
import entity.Category;
import entity.Role;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author palad
 */
@Named(value = "categoryBean")
@SessionScoped
public class categoryBean implements Serializable {

    adminClient adclient;
    int id;
    int categoryId;
    int roleId;
    Role roleCId;
    String name;
    String description;
    String image;
    String status;
    Category current;
    private Part photofile;
    Response rs;
    String responseMessage;
    private Collection<Category> dataSCollection;
    private GenericType<Collection<Category>> genricCollection;

    public categoryBean() {
        adclient = new adminClient();
        dataSCollection = new ArrayList<>();
        genricCollection = new GenericType<Collection<Category>>() {
        };
        current = new Category();
        roleCId = new Role();
        status="Active";
    }

    public String addCategory() {
        try {

            // Image upload logic
            if (photofile != null) {
                InputStream input = photofile.getInputStream();
                String path = "D:\\Fymca\\practical\\health\\src\\main\\webapp\\userimages";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

//                // Generate random file name
//                sb.append(random.nextInt(9) + 1);
//                for (int i = 0; i < 11; i++) {
//                    sb.append(random.nextInt(10));
//                }
//                String temp = sb.toString();

                // Final image name
                image = "IMG_" + System.currentTimeMillis() + photofile.getSubmittedFileName().replaceAll(" ", "_").replaceAll("[<>:\"/\\\\|?*]", "_");
                Files.copy(input, new File(path, image).toPath());
            } else {
                image = ""; // Default to an empty string if no file is uploaded
            }

            // Add category logic
            adclient.addCategory(String.valueOf(roleId), name, description, image, status);

            responseMessage = "Category added successfully with photo!";
            return "category.xhtml?faces-redirect=true";
        } catch (IOException e) {
            e.printStackTrace();
            responseMessage = "Error uploading photo!";
            return "failure";
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage = "Error adding category!";
            return "failure";
        }
    }

    public String deleteCategory() {
        adclient.deleteCategory(String.valueOf(categoryId));
        return "category.xhtml?faces-redirect=true";
    }

    public Part getPhotofile() {
        return photofile;
    }

//    public String updateCategory() {
//        name = current.getName();
//        description = current.getDescription();
//        image = current.getImage();
//        roleCId = current.getRoleId(); // Converts String to int
//        status = current.getStatus();
//        categoryId = current.getId();
//        adclient.updateCategory(String.valueOf(categoryId), String.valueOf(roleCId), name, description, image, status);
//        current = new Category();
//        return "category.xhtml?faces-redirect=true";
//    }
//public String updateCategory() {
//    name = current.getName();
//    description = current.getDescription();
//    status = current.getStatus();
//    roleCId = current.getRoleId(); // Converts String to int
//    categoryId = current.getId();
//
//    try {
//        // Image upload logic
//        if (photofile != null) {
//            InputStream input = photofile.getInputStream();
//            String path = "D:\\Fymca\\practical\\health\\src\\main\\webapp\\userimages";
//            String imageName = "IMG_" + System.currentTimeMillis() + photofile.getSubmittedFileName()
//                .replaceAll(" ", "_") // Replace spaces
//                .replaceAll("[<>:\"/\\\\|?*]", "_"); // Sanitize filename
//            image = imageName;
//            Files.copy(input, new File(path, image).toPath());
//        } else {
//            // Retain the existing image if no new file is uploaded
//            image = current.getImage();
//        }
//
//        // Update category details
//      adclient.updateCategory(String.valueOf(categoryId), String.valueOf(roleCId), name, description, image, status);
//
//        // Reset current category object
//        current = new Category();
//        return "category.xhtml?faces-redirect=true";
//    } catch (IOException e) {
//        e.printStackTrace();
//        System.out.println("Error uploading photo!");
//        return "failure";
//    } catch (Exception e) {
//        e.printStackTrace();
//        return "failure";
//    }
//}

    public void setPhotofile(Part photofile) {
        this.photofile = photofile;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public adminClient getAdclient() {
        return adclient;
    }

    public void setAdclient(adminClient adclient) {
        this.adclient = adclient;
    }

    public Role getRoleCId() {
        return roleCId;
    }

    public void setRoleCId(Role roleCId) {
        this.roleCId = roleCId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public Category getCurrent() {
        return current;
    }

    public void setCurrent(Category current) {
        this.current = current;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Collection<Category> getDataSCollection() {
        rs = adclient.getAllCategoryes(Response.class);
        dataSCollection = rs.readEntity(genricCollection);
        return dataSCollection;
    }

    public void setDataSCollection(Collection<Category> dataSCollection) {
        this.dataSCollection = dataSCollection;
    }

    public GenericType<Collection<Category>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<Category>> genricCollection) {
        this.genricCollection = genricCollection;
    }

//    public String redirectToEdit() {
//        return "categoryEdit.xhtml?faces-redirect=true";
//    }
}
