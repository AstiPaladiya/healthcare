/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Subscription;
import entity.User;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author palad
 */
@Local
public interface renewSubscriptionlanLocal {
    Date getUserExpirationDate(String username);
        public List<Subscription> getAllSubscriptions();
           int getSubscriptionPeriodById(int subscriptionId);
User getUserIdByUsername(String username);
        int renewUser(int userId,int subscriptionId,Date expiary_date);
           void addSubscriptionUser(int userId, int subscriptionId, Date expiryDate, String paymentMode);

}
