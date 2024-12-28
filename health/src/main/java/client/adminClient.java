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
 * Jersey REST client generated for REST resource:adminResources [generic]<br>
 * USAGE:
 * <pre>
 *        adminClient client = new adminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author palad
 */
public class adminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/health/resources";

    public adminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getAllRoles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("roles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateRole(String roleId, String name, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRole/{0}/{1}/{2}", new Object[]{roleId, name, status})).request().post(null);
    }

    public void deleteSubscription(String subscriptionId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteSubscription/{0}", new Object[]{subscriptionId})).request().delete();
    }

    public void updateCategory(String categoryId, String roleCId, String name, String description, String image, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCategory/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{categoryId, roleCId, name, description, image, status})).request().post(null);
    }

    public void addSubscription(String plan_name, String plan_detail, String price, String time_period, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addSubscription/{0}/{1}/{2}/{3}/{4}", new Object[]{plan_name, plan_detail, price, time_period, status})).request().post(null);
    }

    public void updateSubscription(String subscriptionId, String plan_name, String plan_detail, String price, String time_period, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateSubscription/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{subscriptionId, plan_name, plan_detail, price, time_period, status})).request().post(null);
    }

    public Response toggleBlogStatus(String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("toggleBlogStatus/{0}", new Object[]{id})).request().post(null, Response.class);
    }

    public Response toggleRoleStatus(String roleId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("toggleRoleStatus/{0}", new Object[]{roleId})).request().post(null, Response.class);
    }

    public <T> T getAllBlogs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("blogs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteRole(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteRole/{0}", new Object[]{id})).request().delete();
    }

    public void deleteCategory(String categoryId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCategory/{0}", new Object[]{categoryId})).request().delete();
    }

    public void addCategory(String roleId, String name, String description, String image, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCategory/{0}/{1}/{2}/{3}/{4}", new Object[]{roleId, name, description, image, status})).request().post(null);
    }

    public <T> T findBlogById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findBlogId/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllFeedbacks(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("feedbacks");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllProducts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("products");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllSubscriptions(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("subscriptions");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response toggleUserStatus(String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("toggleUserStatus/{0}", new Object[]{id})).request().post(null, Response.class);
    }

    public <T> T getAllCategoryes(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("categoryes");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRole(String name, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRole/{0}/{1}", new Object[]{name, status})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
