/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.loginClient;
import ejb.UserService;
import ejb.renewSubscriptionlanLocal;
import entity.Subscription;
import entity.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import record.KeepRecord;

/**
 *
 * @author palad
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @Inject
    loginClient lgclient;

    @EJB
    renewSubscriptionlanLocal rspl;
    @Inject
    private SecurityContext ctx;

    @Inject
    private UserService userService;
    private String username;
    private String password;
    private Set<String> roles;
    private String errorstatus;
    private AuthenticationStatus status;
    @Column(nullable = false)
    private String sstatus; // Stores "active" or "block"
    boolean isActive;
    int subscriptionId;
    Date expiryDate;
    String plan_name;
    String plan_detail;
    String statusSub;
    int time_period;
    float price;
    String paymentmode;
    String responseMessage;
    String substatus;
    Response rssub;
    private Collection<Subscription> dataSubCollection;
    private GenericType<Collection<Subscription>> genricSubCollection;

    public SecurityContext getCtx() {
        return ctx;
    }

    public void setCtx(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public String getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(String errorstatus) {
        this.errorstatus = errorstatus;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getErrorStatus() {
        return errorstatus;
    }

    public void setErrorStatus(String status) {
        this.errorstatus = status;
    }

    public String login() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            Credential credential = new UsernamePasswordCredential(username, new Password(password));
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance()
                    .getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            AuthenticationStatus mystatus = ctx.authenticate(request, response, withParams().credential(credential));
            //
            System.out.println(new Pbkdf2PasswordHashImpl().generate(password.toCharArray()));
            //register thay ne tyare groups na table ma pan entry parvani username ne groupname sathe 
            if (mystatus.equals(mystatus.SUCCESS)) {
                String userStatus = userService.getUserStatus(username);

                if (!"Active".equalsIgnoreCase(userStatus)) {
                    errorstatus = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                            + "<strong>Account Blocked!</strong> Your account has been blocked. Please contact the administrator."
                            + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                            + "<span aria-hidden='true'>&times;</span></button></div>";
                    return "/login.xhtml"; // Stay on the login page
                }

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);

                KeepRecord.setUsername(username);
                KeepRecord.setPassword(password);

                if (ctx.isCallerInRole("Admin")) {
                    return "/admin/adminMaster.xhtml?faces-redirect=true";
                } else if (ctx.isCallerInRole("Doctor")) {
                    // Fetch user expiration date from the database
                    Date expirationDate = rspl.getUserExpirationDate(username);
                    Date currentDate = new Date(); // Get the current date
                    if (expirationDate != null && !currentDate.before(expirationDate)) {
                        errorstatus = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                                + "<strong>Plan Expired!</strong> Your subscription plan has expired. Please renew your plan."
                                + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                                + "<span aria-hidden='true'>&times;</span></button></div>";
                        // If the current date is on or after the expiration date
                        return "/renewPlan.xhtml?faces-redirect=true";
                    } else {
                        return "/doctor/doctorMaster.xhtml?faces-redirect=true";
                    }
                } else if (ctx.isCallerInRole("User")) {
                    // Fetch user expiration date from the database
                    Date expirationDate = rspl.getUserExpirationDate(username);
                    Date currentDate = new Date(); // Get the current date
                    if (expirationDate != null && !currentDate.before(expirationDate)) {
                        errorstatus = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                                + "<strong>Plan Expired!</strong> Your subscription plan has expired. Please renew your plan."
                                + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                                + "<span aria-hidden='true'>&times;</span></button></div>";
                        // If the current date is on or after the expiration date
                        return "/renewPlan.xhtml?faces-redirect=true";
                    } else {
                        return "/user/userMaster.xhtml?faces-redirect=true";
                    }
                } else if (ctx.isCallerInRole("Pharmacist")) {
                    // Fetch user expiration date from the database
                    Date expirationDate = rspl.getUserExpirationDate(username);
                    Date currentDate = new Date(); // Get the current date
                    if (expirationDate != null && !currentDate.before(expirationDate)) {
                        errorstatus = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                                + "<strong>Plan Expired!</strong> Your subscription plan has expired. Please renew your plan."
                                + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                                + "<span aria-hidden='true'>&times;</span></button></div>";
                        // If the current date is on or after the expiration date
                        return "/renewPlan.xhtml?faces-redirect=true";
                    } else {
                        return "/pharmacist/pharmacistMaster.xhtml?faces-redirect=true";
                    }
                }

            } else {
                errorstatus = "<div style='color: red; background-color: #ffe6e6; border: 1px solid #ff4d4d; "
                        + "padding: 10px; border-radius: 5px; font-size: 14px; text-align: center;'>"
                        + "<strong>Error!</strong> Username or Password may be incorrect."
                        + "</div>";
                return "/login.xhtml";
            }

        } catch (Exception e) {
            errorstatus = "<div class='alert alert-danger'>"
                    + "<strong>Error!</strong> An unexpected error occurred. Please try again later."
                    + "</div>";
            e.printStackTrace();
        }
        return "/login.xhtml";
    }

    /**
     * Creates a new instance of LoginBean
     */
    public String logout() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            request.logout();
            session.invalidate();
            KeepRecord.reset();
        } catch (Exception e) {

        }
        return "/login";
    }

    public String renewUser() {
        // Fetch subscription duration in days (e.g., from subscriptionId)
        int subscriptionPeriodDays = rspl.getSubscriptionPeriodById(subscriptionId); // You need to implement this method
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

        username = KeepRecord.getUsername();
        System.out.println("Username retrieved from KeepRecord: " + username);  // Debugging line

        // Fetch the User object based on username
        User user = rspl.getUserIdByUsername(username);
        // Renew the user's subscription
        int userId = rspl.renewUser(user.getId(), subscriptionId, expiryDate);
        if (userId > 0) {
            rspl.addSubscriptionUser(userId, subscriptionId, expiryDate, paymentmode);
            return "login.xhtml"; // Navigate to success page
        } else {
            // Handle the error
            responseMessage = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                    + "<strong>Error!</strong> An unexpected error occurred. Please try again later."
                    + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                    + "<span aria-hidden='true'>&times;</span></button></div>";
            return "registration.xhtml"; // Stay on the registration page
        }
    }

    public LoginBean() {
        dataSubCollection = new ArrayList<>();
        genricSubCollection = new GenericType<Collection<Subscription>>() {
        };
        substatus = "Active";
        paymentmode = "Online";
    }

    public loginClient getLgclient() {
        return lgclient;
    }

    public void setLgclient(loginClient lgclient) {
        this.lgclient = lgclient;
    }

    public renewSubscriptionlanLocal getRspl() {
        return rspl;
    }

    public void setRspl(renewSubscriptionlanLocal rspl) {
        this.rspl = rspl;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public String getSubstatus() {
        return substatus;
    }

    public void setSubstatus(String substatus) {
        this.substatus = substatus;
    }

    public Response getRssub() {
        return rssub;
    }

    public void setRssub(Response rssub) {
        this.rssub = rssub;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Collection<Subscription> getDataSubCollection() {
        rssub = lgclient.getAllSubscriptions(Response.class);
        dataSubCollection = rssub.readEntity(genricSubCollection);
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

}
