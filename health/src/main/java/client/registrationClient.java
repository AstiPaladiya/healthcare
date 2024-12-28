/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RegistrationResource
 * [registration]<br>
 * USAGE:
 * <pre>
 *        registrationClient client = new registrationClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author palad
 */
public class registrationClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/health/resources";

    public registrationClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("registration");
    }

    public <T> T addUser(Class<T> responseType, String roleId, String subscriptionId, String email, String firstName, String lastName, String password, String phoneNo, String birthOfDate, String gender, String address, String emergency_no, String profile, String pincode, String state, String city, String specialization, String medicalLicence, String yearOfExperience, String degree, String certificate, String affilicateHospital, String currentPosition, String workShecdule, String registrationDate, String bio, String hospitalName, String website, String expiaryDate, String macAddress, String status) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}/{17}/{18}/{19}/{20}/{21}/{22}/{23}/{24}/{25}/{26}/{27}/{28}/{29}", new Object[]{roleId, subscriptionId, email, firstName, lastName, password, phoneNo, birthOfDate, gender, address, emergency_no, profile, pincode, state, city, specialization, medicalLicence, yearOfExperience, degree, certificate, affilicateHospital, currentPosition, workShecdule, registrationDate, bio, hospitalName, website, expiaryDate, macAddress, status})).request().post(null, responseType);
    }

    public <T> T getAllSubscriptions(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("subscriptionsPurchase");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String getXml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void close() {
        client.close();
    }
    
}
