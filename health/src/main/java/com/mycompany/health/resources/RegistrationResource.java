/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.health.resources;

import ejb.adminLocal;
import ejb.registrationLocal;
import entity.Subscription;
import entity.User;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author palad
 */
@Path("registration")
@RequestScoped
public class RegistrationResource {

    @Context
    private UriInfo context;
    @EJB
    registrationLocal userLocal;
    /**
     * Creates a new instance of RegistrationResource
     */
    public RegistrationResource() {
    }

@POST
     @Path("addUser/{roleId}/{subscriptionId}/{email}/{firstName}/{lastName}/{password}/{phoneNo}/{birthOfDate}/{gender}/{address}/{emergency_no}/{profile}/{pincode}/{state}/{city}/{specialization}/{medicalLicence}/{yearOfExperience}/{degree}/{certificate}/{affilicateHospital}/{currentPosition}/{workShecdule}/{registrationDate}/{bio}/{hospitalName}/{website}/{expiaryDate}/{macAddress}/{status}")
    public int addUser(@PathParam("roleId")  int roleId,@PathParam("subscriptionId")  int subscriptionId,@PathParam("email") String email,@PathParam("firstName") String firstName,@PathParam("lastName") String lastName,@PathParam("password") String password,@PathParam("phoneNo") BigInteger phoneNo,@PathParam("birthOfDate") Date birthOfDate,@PathParam("gender") String gender,@PathParam("address") String address,@PathParam("emergency_no") BigInteger emergency_no,@PathParam("profile") String profile,@PathParam("pincode") int pincode,@PathParam("state") String state,@PathParam("city") String city,@PathParam("specialization") String specialization,@PathParam("medicalLicence")  String medicalLicence,@PathParam("yearOfExperience")  String yearOfExperience,@PathParam("degree")  String degree,@PathParam("certificate")  String certificate, @PathParam("affilicateHospital") String affilicateHospital,@PathParam("currentPosition")  String currentPosition,@PathParam("workShecdule")  String workShecdule,@PathParam("registrationDate")  Date registrationDate,@PathParam("bio")  String bio,@PathParam("hospitalName")  String hospitalName,@PathParam("website")  String website,@PathParam("expiaryDate")  Date expiaryDate,@PathParam("macAddress")  String macAddress,@PathParam("status")  String status) 
 {
        return userLocal.addUser(roleId,subscriptionId,email,firstName,lastName,password,phoneNo,birthOfDate,gender,address,emergency_no,profile,pincode,state,city,specialization,medicalLicence,yearOfExperience,degree, certificate, affilicateHospital, currentPosition, workShecdule,  registrationDate,  bio,  hospitalName,  website,  expiaryDate,  macAddress,  status);
        
    }

       @GET
    @Path("subscriptionsPurchase")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscriptions() {
        return userLocal.getAllSubscriptions();
    }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RegistrationResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
