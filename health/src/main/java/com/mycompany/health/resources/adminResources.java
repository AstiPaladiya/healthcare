/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.health.resources;

import ejb.adminLocal;
import entity.Blog;
import entity.Category;
import entity.Feedback;
import entity.Product;
import entity.Role;
import entity.Subscription;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author palad
 */
@Path("generic")
@RequestScoped
public class adminResources {

    @Context
    private UriInfo context;
    @EJB
    adminLocal admin;

    /**
     * Creates a new instance of adminResources
     */
    public adminResources() {
    }

    @POST
    @Path("addRole/{name}/{status}")
    public void addRole(@PathParam("name") String name, @PathParam("status") String status) {
        admin.addRole(name, status);
    }

    @DELETE
    @Path("deleteRole/{id}")
    public void deleteRole(@PathParam("id") int id) {
        admin.deleteRole(id);
    }

    @POST
    @Path("updateRole/{roleId}/{name}/{status}")
    public void updateRole(@PathParam("roleId") int roleId, @PathParam("name") String name, @PathParam("status") String status) {
        admin.updateRole(roleId, name, status);
    }

    @GET
    @Path("roles")
    @Produces("application/json")
    public Collection<Role> getAllRoles() {
        return admin.getAllRoles();
    }
//     update status

    @POST
    @Path("toggleRoleStatus/{roleId}")
    @Produces("application/json")
    public Response toggleRoleStatus(@PathParam("roleId") int roleId) {
        try {
            // Call the EJB method to toggle the role status
            admin.toggleRoleStatus(roleId);
            return Response.ok("Role status for ID " + roleId + " toggled successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage()).build();
        }
    }
//     subscription

    @POST
    @Path("addSubscription/{plan_name}/{plan_detail}/{price}/{time_period}/{status}")
    public void addSubscription(@PathParam("plan_name") String plan_name, @PathParam("plan_detail") String plan_detail, @PathParam("price") float price, @PathParam("time_period") int time_period, @PathParam("status") String status) {
        admin.addSubscription(plan_name, plan_detail, price, time_period, status);
    }

    @DELETE
    @Path("deleteSubscription/{subscriptionId}")
    public void deleteSubscription(@PathParam("subscriptionId") int subscriptionId) {
        admin.deleteSubscription(subscriptionId);
    }

    @POST
    @Path("updateSubscription/{subscriptionId}/{plan_name}/{plan_detail}/{price}/{time_period}/{status}")
    public void updateSubscription(@PathParam("subscriptionId") int subscriptionId, @PathParam("plan_name") String plan_name, @PathParam("plan_detail") String plan_detail, @PathParam("price") float price, @PathParam("time_period") int time_period, @PathParam("status") String status) {
        admin.updateSubscription(subscriptionId, plan_name, plan_detail, price, time_period, status);
    }

    @GET
    @Path("subscriptions")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscriptions() {
        return admin.getAllSubscriptions();
    }

    @POST
    @Path("addCategory/{roleId}/{name}/{description}/{image}/{status}")
    public void addCategory(@PathParam("roleId") int roleId, @PathParam("name") String name, @PathParam("description") String description, @PathParam("image") String image, @PathParam("status") String status) {
        admin.addCategory(roleId, name, description, image, status);
    }

    @DELETE
    @Path("deleteCategory/{categoryId}")
    public void deleteCategory(@PathParam("categoryId") int categoryId) {
        admin.deleteCategory(categoryId);
    }

    @POST
    @Path("updateCategory/{categoryId}/{roleCId}/{name}/{description}/{image}/{status}")
    public void updateCategory(@PathParam("categoryId") int categoryId, @PathParam("roleCId") int roleCId, @PathParam("name") String name, @PathParam("description") String description, @PathParam("image") String image, @PathParam("status") String status) {
        admin.updateCategory(categoryId, roleCId, name, description, image, status);
    }

    @GET
    @Path("categoryes")
    @Produces("application/json")
    public Collection<Category> getAllCategoryes() {
        return admin.getAllCategoryes();
    }

    @GET
    @Path("products")
    @Produces("application/json")
    public Collection<Product> getAllProducts() {
        return admin.getAllProducts();
    }

    @GET
    @Path("blogs")
    @Produces("application/json")
    public Collection<Blog> getAllBlogs() {
        return admin.getAllBlogs();
    }
      @POST
    @Path("toggleBlogStatus/{id}")
    @Produces("application/json")
    public Response toggleBlogStatus(@PathParam("id") int id) {
        try {
            // Call the EJB method to toggle the role status
            admin.toggleBlogStatus(id);
            return Response.ok("Role status for ID " + id + " toggled successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage()).build();
        }
    }
       // Method to find a blog by its ID
    @GET
    @Path("findBlogId/{id}")
    @Produces("application/json")
    public Blog findBlogById(@PathParam("id") int id) {
        Blog blog = admin.findBlogById(id);
        if (blog == null) {
            throw new WebApplicationException("Blog not found", 404);
        }
        return blog;
    }
 @GET
    @Path("feedbacks")
    @Produces("application/json")
    public Collection<Feedback> getAllFeedbacks() {
        return admin.getAllFeedbacks();
    }
      @POST
    @Path("toggleUserStatus/{id}")
    @Produces("application/json")
    public Response toggleUserStatus(@PathParam("id") int id) {
        try {
            // Call the EJB method to toggle the role status
            admin.toggleUserStatus(id);
            return Response.ok("Role status for ID " + id + " toggled successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage()).build();
        }
    }
}
