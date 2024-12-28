/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:doctorResource [doctor]<br>
 * USAGE:
 * <pre>
 *        doctorClient client = new doctorClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author palad
 */
public class doctorClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/health/resources";

    public doctorClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("doctor");
    }

    public Response toggleCheckupBookingStatus(String roleId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("toggleCheckupBookingStatus/{0}", new Object[]{roleId})).request().post(null, Response.class);
    }

    public void addBlog(String userId, String name, String image, String description, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addBlog/{0}/{1}/{2}/{3}/{4}", new Object[]{userId, name, image, description, status})).request().post(null);
    }

    public <T> T getCheckupBookingsByUsername(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("checkupbookings/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response toggleBlogStatus(String roleId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("toggleBlogStatus/{0}", new Object[]{roleId})).request().post(null, Response.class);
    }

    public String getXml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public <T> T getBlogsByUsername(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getBlogsByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCheckupBooking(String bussinessId, String schedule, String price, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCheckupBooking/{0}/{1}/{2}/{3}", new Object[]{bussinessId, schedule, price, status})).request().post(null);
    }

    public void updateCheckupBooking(String checkupId, String schedule, String price, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCheckupBooking/{0}/{1}/{2}/{3}", new Object[]{checkupId, schedule, price, status})).request().post(null);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateBlog(String blogId, String name, String image, String description, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateBlog/{0}/{1}/{2}/{3}/{4}", new Object[]{blogId, name, image, description, status})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
