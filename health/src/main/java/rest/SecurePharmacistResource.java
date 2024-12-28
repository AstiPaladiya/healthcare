/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.SecurePharmacistBean;
import javax.annotation.security.RolesAllowed;
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
@Path("securePharmacis")
@RequestScoped
public class SecurePharmacistResource {
@EJB SecurePharmacistBean sb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SecurePharmacistResource
     */
    public SecurePharmacistResource() {
    }

     @RolesAllowed({"Pharmacist"})
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       return sb.saySecureHello()+ " from Rest Client";
    }
}
