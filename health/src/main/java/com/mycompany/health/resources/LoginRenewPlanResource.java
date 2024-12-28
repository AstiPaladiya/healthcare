/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.health.resources;

import ejb.renewSubscriptionlanLocal;
import entity.Subscription;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author palad
 */
@Path("loginRenewPlan")
@RequestScoped
public class LoginRenewPlanResource {

    @Context
    private UriInfo context;
    @EJB
    renewSubscriptionlanLocal subplanLocal;
    /**
     * Creates a new instance of LoginRenewPlanResource
     */
    public LoginRenewPlanResource() {
    }

       @GET
    @Path("subscriptionsRenewView")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscriptions() {
        return subplanLocal.getAllSubscriptions();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LoginRenewPlanResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
