/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.registrationClient;
import ejb.registrationLocal;
import entity.Category;
import entity.Role;
import entity.Subscription;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author palad
 */
@Named(value = "registrationBean")
@SessionScoped
public class registrationBean implements Serializable {

    registrationClient rgclient;
    @EJB
    registrationLocal rgLocal;
    private int roleId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private BigInteger phoneNo;
    private Date birthOfDate;
    private String gender;
    private String address;
    private BigInteger emergencyNo;
    private String profile;
    private int pincode;
    private String state;
    private String city;
    private String specialization;
    private String medicalLicence;
    private String yearOfExperience;
    private String degree;
    private String certificate;
    private String affilicateHospital;
    private String currentPosition;
    private String workSchedule;
    private Date registrationDate;
    private String bio;
    private String hospitalName;
    private String website;
    private Date expiryDate;
    private String macAddress;
    private String status;
    private int subscriptionId;
    private Part photofile;
    Response rs;
    String responseMessage;
    private Collection<User> dataSCollection;
    private GenericType<Collection<User>> genricCollection;
    String plan_name;
    String plan_detail;
    String statusSub;
    int time_period;
    float price;
    String paymentmode;
    Response rssub;
    private Collection<Subscription> dataSubCollection;
    private GenericType<Collection<Subscription>> genricSubCollection;
//    private List<Role> availableRoles;

    public registrationBean() {
        rgclient = new registrationClient();
        dataSCollection = new ArrayList<>();
        genricCollection = new GenericType<Collection<User>>() {
        };
        User current = new User();
        dataSubCollection = new ArrayList<>();
        genricSubCollection = new GenericType<Collection<Subscription>>() {
        };
        status = "Active";
        paymentmode = "Online";
//             availableRoles = rgLocal.getRolesExcludingAdmin();
    }

    public String addUser() {
//    try {
//            // Debugging: Print input values
//        System.out.println("Role ID: " + roleId);
//        System.out.println("Email: " + email);
//        System.out.println("First Name: " + firstName);
//        System.out.println("Last Name: " + lastName);
//        System.out.println("Birth Date: " + birthOfDate);
//        System.out.println("Registration Date: " + registrationDate);
//        System.out.println("Expiry Date: " + expiryDate);
//        // Convert and pass parameters to the client service
////        rgclient.addUser(
////            String.valueOf(roleId), // Convert Role ID to String
////            email,
////            firstName,
////            lastName,
////            password,
////            String.valueOf(phoneNo), // Convert BigInteger to String
////            birthOfDate.toString(),  // Convert Date to String
////            gender,
////            address,
////            String.valueOf(emergencyNo), // Convert BigInteger to String
////            profile,
////            String.valueOf(pincode), // Convert int to String
////            state,
////            city,
////            specialization,
////            medicalLicence,
////            yearOfExperience,
////            degree,
////            certificate,
////            affilicateHospital,
////            currentPosition,
////            workSchedule,
////            registrationDate.toString(), // Convert Date to String
////            bio,
////            hospitalName,
////            website,
////            expiryDate.toString(), // Convert Date to String
////            macAddress,
////            status
////        );
//rgLocal.addUser(roleId, email, firstName, lastName, password, phoneNo, birthOfDate, gender, address, emergencyNo, profile, pincode, state, city, specialization, medicalLicence, yearOfExperience, degree, certificate, affilicateHospital, currentPosition, workSchedule, registrationDate, bio, hospitalName, website, expiryDate, macAddress, status);
////       responseMessage = "user added successfully with photo!";
//        return "login.xhtml"; // Navigate to the success page
//    } catch (Exception e) {
////        e.printStackTrace();
//        return "failure.xhtml"; // Navigate to the failure page
//    }
        try {
            // Debugging: Print input values
            System.out.println("Role ID: " + roleId);
            System.out.println("Email: " + email);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Birth Date: " + birthOfDate);
            System.out.println("Registration Date: " + registrationDate);
            System.out.println("Expiry Date: " + expiryDate);
            // Check for required fields (Example: email, first name, last name, password)
            if (email == null || email.isEmpty()) {
                responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "<strong>Error!</strong> Email is required."
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span></button></div>";
                return "registration.xhtml"; // Stay on the registration page
            }

            if (firstName == null || firstName.isEmpty()) {
                responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "<strong>Error!</strong> First Name is required."
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span></button></div>";
                return "registration.xhtml"; // Stay on the registration page
            }

            if (lastName == null || lastName.isEmpty()) {
                responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "<strong>Error!</strong> Last Name is required."
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span></button></div>";
                return "registration.xhtml"; // Stay on the registration page
            }

            if (password == null || password.isEmpty()) {
                responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "<strong>Error!</strong> Password is required."
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span></button></div>";
                return "registration.xhtml"; // Stay on the registration page
            }

            if (!rgLocal.isEmailUnique(email)) {
                System.out.println("Error: Email is not unique!");
                responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "<strong>Error!</strong> Email already exists! Please use a different email."
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span></button></div>";
                return "registration.xhtml";
            }
            // Fetch subscription duration in days (e.g., from subscriptionId)
            int subscriptionPeriodDays = rgLocal.getSubscriptionPeriodById(subscriptionId); // You need to implement this method
            System.out.println("Subscription period (in days): " + subscriptionPeriodDays);

            // Get the current date
            Date currentDate = new Date();

            // Add subscription period in days to the current date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_YEAR, subscriptionPeriodDays); // Add subscription period in days

            // Calculate the expiry date
            expiryDate = calendar.getTime();
            System.out.println("Calculated expiry date: " + expiryDate);

            // Hash the password using PBKDF2
            Pbkdf2PasswordHashImpl pbkdf2PasswordHash = new Pbkdf2PasswordHashImpl();
            String hashedPassword = pbkdf2PasswordHash.generate(password.toCharArray());

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
                profile = "IMG_" + System.currentTimeMillis() + photofile.getSubmittedFileName().replaceAll(" ", "_").replaceAll("[<>:\"/\\\\|?*]", "_");
                Files.copy(input, new File(path, profile).toPath());
            } else {
                profile = ""; // Default to an empty string if no file is uploaded
            }

            // Convert and pass parameters to the client service
            int userId = rgLocal.addUser(roleId, subscriptionId, email, firstName, lastName, hashedPassword, phoneNo, birthOfDate, gender, address, emergencyNo, profile, pincode, state, city, specialization, medicalLicence, yearOfExperience, degree, certificate, affilicateHospital, currentPosition, workSchedule, registrationDate, bio, hospitalName, website, expiryDate, macAddress, status);
// If userId is valid, proceed with the subscription
            if (userId > 0) {
                rgLocal.addSubscriptionUser(userId, subscriptionId, expiryDate, paymentmode);
                return "login.xhtml"; // Navigate to success page
            } else {
                // Handle the error
                responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "<strong>Error!</strong> An unexpected error occurred. Please try again later."
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span></button></div>";
                return "registration.xhtml"; // Stay on the registration page
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error uploading photo!");
            responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                    + "<strong>Error!</strong> There was an error uploading the photo. Please try again."
                    + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                    + "<span aria-hidden='true'>&times;</span></button></div>";
            return "registration.xhtml"; // Navigate to the failure page
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                    + "<strong>Error!</strong> An unexpected error occurred. Please try again later."
                    + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                    + "<span aria-hidden='true'>&times;</span></button></div>";
            return "registration.xhtml"; // Stay on registration page

        }
    }

//    public List<Role> getAvailableRoles() {
//        return availableRoles;
//    }
//
//    public void setAvailableRoles(List<Role> availableRoles) {
//        this.availableRoles = availableRoles;
//    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Part getPhotofile() {
        return photofile;
    }

    public void setPhotofile(Part photofile) {
        this.photofile = photofile;
    }

    public registrationLocal getRgLocal() {
        return rgLocal;
    }

    public void setRgLocal(registrationLocal rgLocal) {
        this.rgLocal = rgLocal;
    }

    public registrationClient getRgclient() {
        return rgclient;
    }

    public void setRgclient(registrationClient rgclient) {
        this.rgclient = rgclient;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getEmergencyNo() {
        return emergencyNo;
    }

    public void setEmergencyNo(BigInteger emergencyNo) {
        this.emergencyNo = emergencyNo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMedicalLicence() {
        return medicalLicence;
    }

    public void setMedicalLicence(String medicalLicence) {
        this.medicalLicence = medicalLicence;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getAffilicateHospital() {
        return affilicateHospital;
    }

    public void setAffilicateHospital(String affilicateHospital) {
        this.affilicateHospital = affilicateHospital;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Collection<User> getDataSCollection() {
        return dataSCollection;
    }

    public void setDataSCollection(Collection<User> dataSCollection) {
        this.dataSCollection = dataSCollection;
    }

    public GenericType<Collection<User>> getGenricCollection() {
        return genricCollection;
    }

    public void setGenricCollection(GenericType<Collection<User>> genricCollection) {
        this.genricCollection = genricCollection;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPlan_detail() {
        return plan_detail;
    }

    public void setPlan_detail(String plan_detail) {
        this.plan_detail = plan_detail;
    }

    public String getStatusSub() {
        return statusSub;
    }

    public void setStatusSub(String statusSub) {
        this.statusSub = statusSub;
    }

    public int getTime_period() {
        return time_period;
    }

    public void setTime_period(int time_period) {
        this.time_period = time_period;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Response getRssub() {
        return rssub;
    }

    public void setRssub(Response rssub) {
        this.rssub = rssub;
    }

    public Collection<Subscription> getDataSubCollection() {
        rs = rgclient.getAllSubscriptions(Response.class);
        dataSubCollection = rs.readEntity(genricSubCollection);
        return dataSubCollection;
    }

    public void setDataSubCollection(Collection<Subscription> dataSubCollection) {
        this.dataSubCollection = dataSubCollection;
    }

    public GenericType<Collection<Subscription>> getGenricSubCollection() {
        return genricSubCollection;
    }

    public void setGenricSubCollection(GenericType<Collection<Subscription>> genricSubCollection) {
        this.genricSubCollection = genricSubCollection;
    }

    public String redirectToEdit() {
//            return "edit.jsf";
//             FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("id", 20);
//            System.out.println("Static ID set in request: 20");
        return "subscriptionPurchase.xhtml";
    }
}
