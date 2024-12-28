/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.health.resources;

import ejb.doctorLocal;
import entity.Blog;
import entity.CheckupBooking;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author palad
 */
@Path("doctor")
@RequestScoped
public class doctorResource {

    @Context
    private UriInfo context;

      @EJB
    doctorLocal doctor;
    public doctorResource() {
    }

    @POST
    @Path("addCheckupBooking/{bussinessId}/{schedule}/{price}/{status}")
    public void addCheckupBooking(@PathParam("bussinessId") int bussinessId,@PathParam("schedule") String schedule,@PathParam("price") float price, @PathParam("status") String status) {
        doctor.addCheckupBooking(bussinessId,schedule,price,status);
    }
  @GET
@Path("checkupbookings/{username}")
@Produces("application/json")
public Collection<CheckupBooking> getCheckupBookingsByUsername(@PathParam("username") String username) {
    // Fetch checkup bookings for the provided username
    return doctor.getCheckupBookingsByUsername(username);
}

    
      @POST
    @Path("toggleCheckupBookingStatus/{roleId}")
    @Produces("application/json")
    public Response toggleCheckupBookingStatus(@PathParam("roleId") int roleId) {
        try {
            // Call the EJB method to toggle the role status
            doctor.toggleCheckupBookingStatus(roleId);
            return Response.ok("Role status for ID " + roleId + " toggled successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage()).build();
        }
    }
     @POST
    @Path("updateCheckupBooking/{checkupId}/{schedule}/{price}/{status}")
    public void updateCheckupBooking(@PathParam("checkupId") int checkupId, @PathParam("schedule") String schedule,@PathParam("price") float price, @PathParam("status") String status) {
        doctor.updateCheckupBooking(checkupId,schedule, price,status);
    }
    
      @POST
    @Path("addBlog/{userId}/{name}/{image}/{description}/{status}")
    public void addBlog(@PathParam("userId") int userId,@PathParam("name") String name,@PathParam("description") String description,@PathParam("image") String image, @PathParam("status") String status) {
        doctor.addBlog(userId,name,image,description,status);
    }
    
      @GET
@Path("getBlogsByUsername/{username}")
@Produces("application/json")
public Collection<Blog> getBlogsByUsername(@PathParam("username") String username) {
    // Fetch checkup bookings for the provided username
    return doctor.getBlogsByUsername(username);
}
   @POST
    @Path("toggleBlogStatus/{roleId}")
    @Produces("application/json")
    public Response toggleBlogStatus(@PathParam("roleId") int roleId) {
        try {
            // Call the EJB method to toggle the role status
            doctor.toggleBlogStatus(roleId);
            return Response.ok("Role status for ID " + roleId + " toggled successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage()).build();
        }
    }
    
      @POST
    @Path("updateBlog/{blogId}/{name}/{image}/{description}/{status}")
    public void updateBlog(@PathParam("blogId") int blogId, @PathParam("name") String name,@PathParam("image") String image, @PathParam("description") String description, @PathParam("status") String status) {
        doctor.updateBlog(blogId,name, image,description,status);
    }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of doctorResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
