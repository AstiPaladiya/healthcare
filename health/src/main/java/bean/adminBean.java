/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.adminClient;
import entity.Category;
import entity.Role;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author palad
 */
@Named(value = "adminBean")
@SessionScoped
public class adminBean implements Serializable {

    int id;
    String name;
    String status;
    adminClient adclient;
    Response rs;
    Role current;
    String statusMessage;
    String statusColor;
    int roleId;
    int tid;
    private String imageBasePath = "../projectimage";
//    adclient current;
    private Collection<Role> dataCollection;
    private GenericType<Collection<Role>> genricCollection;
  private List<Role> roles;
    private Role selectedRole;
    public adminBean() {
        adclient = new adminClient();
        dataCollection = new ArrayList<>();
        genricCollection = new GenericType<Collection<Role>>() {
        };
        current = new Role();
        status = "Active";
//        getAllRoles();  
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

    public String getImageBasePath() {
        return imageBasePath;
    }

    public void setImageBasePath(String imageBasePath) {
        this.imageBasePath = imageBasePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public adminClient getAdclient() {
        return adclient;
    }

    public void setAdclient(adminClient adclient) {
        this.adclient = adclient;
    }

    public String addRole() {
        try {
            adclient.addRole(name, status);
            return "role.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
//     public Collection<Role> getAllRoles()
//     {
//             rs=adclient.getAllRoles(Response.class);
//             dataCollection=rs.readEntity(genricCollection);
//             System.out.print(rs);
//           return dataCollection;
//     }
 
    // Toggle role status
    public void toggleRoleStatus() {
        if (selectedRole != null) {
            try {
                // Call the API to toggle the status
                Response response = adclient.toggleRoleStatus(String.valueOf(selectedRole.getId()));

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


 // Getters and Setters for roles and selectedRole
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Role selectedRole) {
        this.selectedRole = selectedRole;
    }

    public String deleteRole() {
        adclient.deleteRole(String.valueOf(id));
        return "role.jsf";
    }

    public String updateRole() {
        name = current.getName();
        status = current.getStatus();
        roleId = current.getId();
        adclient.updateRole(String.valueOf(roleId), name, status);
        current = new Role();
        return "role.xhtml?faces-redirect=true";
    }

    public Role getCurrent() {
        return current;
    }

    public void setCurrent(Role current) {
        this.current = current;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Collection<Role> getDataCollection() {
        rs = adclient.getAllRoles(Response.class);
        dataCollection = rs.readEntity(genricCollection);
//             System.out.print(rs);
        return dataCollection;
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

    public void setDataCollection(Collection<Role> dataCollection) {
        this.dataCollection = dataCollection;
    }

    public GenericType<Collection<Role>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<Role>> genricCollection) {
        this.genricCollection = genricCollection;
    }

//    public String redirectToEdit() {
////            return "edit.jsf";
////             FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("id", 20);
////            System.out.println("Static ID set in request: 20");
//        return "roleEdit.xhtml?faces-redirect=true";
//    }

}
