/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Subscription;
import entity.SubscriptionUser;
import javax.ejb.Stateless;
import entity.User;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author palad
 */
@Stateless
public class renewSubscriptionlan implements renewSubscriptionlanLocal {

    @PersistenceContext(unitName = "health")
    EntityManager em;

    @Override
    public Date getUserExpirationDate(String username) {
        try {
            TypedQuery<Date> query = em.createQuery(
                    "SELECT u.expiaryDate FROM User u WHERE u.email = :username", Date.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (Exception e) {
            // Handle exception (e.g., NoResultException if the user is not found)
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        // Use the named query with Role.class to return a list of Role entities
        return em.createNamedQuery("Subscription.findAll", Subscription.class).getResultList();
    }

    @Override
    public int getSubscriptionPeriodById(int subscriptionId) {
        // Fetch the subscription entity by ID
        Subscription subscription = em.find(Subscription.class, subscriptionId);

        if (subscription != null) {
            // Return the time period in days (assuming it's stored in months)
            return subscription.getTimePeriod(); // Convert months to days if needed
        } else {
            throw new IllegalArgumentException("Subscription ID not found: " + subscriptionId);
        }
    }

    @Override
    public int renewUser(int userId, int subscriptionId, Date expiaryDate) {
        try {
            // Fetch the Subscription entity
            Subscription subscription = em.find(Subscription.class, subscriptionId);
            if (subscription == null) {
                throw new IllegalArgumentException("Subscription ID does not exist: " + subscriptionId);
            }

            // Fetch the User entity
            User user = em.find(User.class, userId);
            if (user == null) {
                System.out.println("User ID not found");
                throw new IllegalArgumentException("User ID does not exist: " + userId);
            }

            // Update user details
            user.setSubscriptionId(subscription);
            user.setExpiaryDate(expiaryDate);

            // Merge the updated user entity
            em.merge(user);
            System.out.println("Update successful");
            return user.getId(); // Return the user ID after successful update

        } catch (IllegalArgumentException e) {
            // Log the specific error and rethrow
            System.out.println("Validation error: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            // Log or print the exception for debugging
            System.out.println("Update failed: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("An error occurred while updating the user.", e);
        }
    }

    @Override
    public User getUserIdByUsername(String username) {
        List<User> users = em.createNamedQuery("User.findByEmail")
                .setParameter("email", username)
                .getResultList();

        if (users.isEmpty()) {
            // Handle the case when no users are found
            System.out.println("No user found for the email: " + username);
            return null; // Or throw an exception if necessary
        }

        return users.get(0); // Since you expect only one result, return the first item
    }

    @Override
    public void addSubscriptionUser(int userId, int subscriptionId, Date expiryDate, String paymentMode) {
        try {
            User uid = em.find(User.class, userId);
            if (uid == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + userId);
            }
            Subscription sub = em.find(Subscription.class, subscriptionId);
            if (sub == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + subscriptionId);
            }
            // Create a new SubscriptionUser object
            SubscriptionUser subscriptionUser = new SubscriptionUser();
            subscriptionUser.setUserId(uid);
            subscriptionUser.setSubscriptionId(sub);
            subscriptionUser.setExpiaryDate(expiryDate);
            subscriptionUser.setPaymentMode(paymentMode);
            Date currentDate = new Date();
            subscriptionUser.setCreatedAt(currentDate);
            subscriptionUser.setUpdatedAt(currentDate);
            em.persist(subscriptionUser);

            System.out.println("Subscription user added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding subscription user: " + e.getMessage());
        }
    }
}
