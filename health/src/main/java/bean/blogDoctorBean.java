/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.doctorClient;
import ejb.doctorLocal;
import entity.Blog;
import entity.CheckupBooking;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import record.KeepRecord;

/**
 *
 * @author palad
 */
@Named(value = "blogDoctorBean")
@SessionScoped
public class blogDoctorBean implements Serializable {

    @EJB
    doctorLocal dtLocal;
    doctorClient dtclient;
    int id;
    int userId;
//    int bussinessId;
    String username;
    User userCId;
    String name;
    String image;
    String status;
    String description;
    Blog current;
    Response rs;
    String responseMessage;
    private Blog selectedRole;
    private Part photofile;
    private Collection<Blog> dataSCollection;
    private GenericType<Collection<Blog>> genricCollection;

    public blogDoctorBean() {
        dtclient = new doctorClient();
        dataSCollection = new ArrayList<>();
        genricCollection = new GenericType<Collection<Blog>>() {
        };
        current = new Blog();
        userCId = new User();
        status = "Active";
    }

//    public String addBlog() {
//        
//        // Set a static username directly
//        KeepRecord.setUsername("asti@gmail.com");
//        // Fetch the userId based on username or email
//        username = KeepRecord.getUsername();
//        System.out.println("Username retrieved from KeepRecord: " + username);  // Debugging line
//
//        // Fetch the User object based on username
//        User user = dtLocal.getUserIdByUsername(username);
//        
//        if (user != null) {
//            try {
//                // Use the userId (assuming user has a method getId()) and pass it to addCheckupBooking
////                dtclient.addBlog(String.valueOf(user.getId()), name, image,description status);
//                dtclient.addBlog(String.valueOf(user.getId()), name, image, description, status);
//                return "blogDoctor.xhtml"; // Navigate to the checkup booking page
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "failure"; // Return failure if there's an error
//            }
//        } else {
//            // Handle the case when no user is found
//            System.out.println("User not found for username: " + username);
//            return "failure"; // You can redirect to a different page or handle the error
//        }
//    }
    public String addBlog() {
        // Set a static username directly
//        KeepRecord.setUsername("asti@gmail.com");

        // Fetch the username from KeepRecord
        username = KeepRecord.getUsername();
        System.out.println("Username retrieved from KeepRecord: " + username);  // Debugging line

        // Fetch the User object based on username
        User user = dtLocal.getUserIdByUsername(username);

        if (user != null) {
            try {
                // Image upload logic
                if (photofile != null) {
                    InputStream input = photofile.getInputStream();
                    String path = "D:\\Fymca\\practical\\health\\src\\main\\webapp\\userimages";
                    Random random = new Random();
                    StringBuilder sb = new StringBuilder();

                    // Generate random file name
//                    sb.append(random.nextInt(9) + 1);
//                    for (int i = 0; i < 11; i++) {
//                        sb.append(random.nextInt(10));
//                    }
//                    String temp = sb.toString();

                    // Final image name
                    image = "IMG_" + System.currentTimeMillis() + photofile.getSubmittedFileName().replaceAll(" ", "_").replaceAll("[<>:\"/\\\\|?*]", "_");
                    Files.copy(input, new File(path, image).toPath());
                } else {
                    image = ""; // Default to an empty string if no file is uploaded
                }

                // Use the userId (assuming user has a method getId()) and pass it to addBlog
                dtclient.addBlog(String.valueOf(user.getId()), name, image, description, status);
                return "blogDoctor.xhtml?faces-redirect=true"; // Navigate to the checkup booking page
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error uploading photo!");
                return "failure";
            } catch (Exception e) {
                e.printStackTrace();
                return "failure"; // Return failure if there's an error
            }
        } else {
            // Handle the case when no user is found
            System.out.println("User not found for username: " + username);
            return "failure"; // You can redirect to a different page or handle the error
        }
    }
    // Method to fetch checkup bookings based on static username

    public List<Blog> getBlogsByUsername() {
//        KeepRecord.setUsername("asti@gmail.com");

        // Retrieve username from KeepRecord (already set statically)
        username = KeepRecord.getUsername();
        System.out.println("Username retrieved from KeepRecord: " + username);

        // Fetch the User object based on username
        User user = dtLocal.getUserIdByUsername(username);

        if (user != null) {
            try {
                // Fetch CheckupBookings for the user
                return dtLocal.getBlogsByUsername(username); // Use the EJB to fetch bookings for the user
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<>();  // Return an empty list in case of an error
            }
        } else {
            System.out.println("No user found for username: " + username);
            return new ArrayList<>();  // Return empty list if no user is found
        }
    }

    public void toggleBlogStatus() {
        if (selectedRole != null) {
            try {
                // Call the API to toggle the status
                Response response = dtclient.toggleBlogStatus(String.valueOf(selectedRole.getId()));

                if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                    // Toggle the role's status locally
                    if ("Active".equals(selectedRole.getStatus())) {
                        selectedRole.setStatus("Block");
                    } else {
                        selectedRole.setStatus("Active");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Log the error for debugging purposes
            }
        }
    }

    public String updateBlog() {
        name = current.getName();
        image = current.getImage();
        description = current.getDescription();
        status = current.getStatus();
        userId = current.getId();

        try {
            // Image upload logic
            if (photofile != null) {
                InputStream input = photofile.getInputStream();
                String path = "D:\\Fymca\\practical\\health\\src\\main\\webapp\\userimages";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                // Generate random file name
//                sb.append(random.nextInt(9) + 1);
//                for (int i = 0; i < 11; i++) {
//                    sb.append(random.nextInt(10));
//                }
//                String temp = sb.toString();

                // Final image name
                image = "IMG_" + System.currentTimeMillis() + photofile.getSubmittedFileName().replaceAll(" ", "_").replaceAll("[<>:\"/\\\\|?*]", "_");
                Files.copy(input, new File(path, image).toPath());
            } else {
                // Retain the existing image if no new file is uploaded
                image = current.getImage();
            }

            // Update blog details
            dtclient.updateBlog(String.valueOf(userId), name, image, description, status);
            current = new Blog();
            return "blogDoctor.xhtml?faces-redirect=true";
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error uploading photo!");
            return "failure";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
// public String updateBlog() {
//        name = current.getName();
//        image = current.getImage();
//        description = current.getDescription();
//
//        status = current.getStatus();
//        userId = current.getId();
//        System.out.println(description);
//        dtclient.updateBlog(String.valueOf(userId),name,image,description, status);
//        current = new Blog();
//        return "blogDoctor.xhtml";
//    }

    public Part getPhotofile() {
        return photofile;
    }

    public void setPhotofile(Part photofile) {
        this.photofile = photofile;
    }

    public doctorLocal getDtLocal() {
        return dtLocal;
    }

    public void setDtLocal(doctorLocal dtLocal) {
        this.dtLocal = dtLocal;
    }

    public doctorClient getDtclient() {
        return dtclient;
    }

    public void setDtclient(doctorClient dtclient) {
        this.dtclient = dtclient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUserCId() {
        return userCId;
    }

    public void setUserCId(User userCId) {
        this.userCId = userCId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blog getCurrent() {
        return current;
    }

    public void setCurrent(Blog current) {
        this.current = current;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Blog getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Blog selectedRole) {
        this.selectedRole = selectedRole;
    }

    public Collection<Blog> getDataSCollection() {
        dataSCollection = getBlogsByUsername();
        return dataSCollection;
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

    public String redirectToEdit() {
//            return "edit.jsf";
//             FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("id", 20);
//            System.out.println("Static ID set in request: 20");
        return "blogEdit.xhtml?faces-redirect=true";
    }

}
