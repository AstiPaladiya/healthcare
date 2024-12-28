/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Blog;
import entity.Category;
import entity.CheckupBooking;
import entity.HealthRecord;
import entity.Role;
import entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author palad
 */
@Stateless
public class doctor implements doctorLocal {

    @PersistenceContext(unitName = "health")
    EntityManager em;

    @Override
    public void addCheckupBooking(int bussinessId, String schedule, float price, String status) {
        try {
            User role = em.find(User.class, bussinessId);
            if (role == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + bussinessId);
            }
            CheckupBooking r = new CheckupBooking();
            r.setBussinessId(role);
            r.setSchedule(schedule);
            r.setPrice(price);
            r.setStatus(status);

            Date currentDate = new Date();
            r.setCreatedAt(currentDate);
            r.setUpdatedAt(currentDate);

            em.persist(r);
            System.out.println("Role successfully added: " + r);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error adding role: " + e.getMessage());
        }
    }

    @Override
    public void updateCheckupBooking(int checkupId, String schedule, float price, String status) {
        try {

            CheckupBooking c = em.find(CheckupBooking.class, checkupId);
            if (c != null) {
                c.setSchedule(schedule);
                c.setPrice(price);
                c.setStatus(status);
                c.setUpdatedAt(new Date());
                em.merge(c);
                System.out.println("updated successfuly");

            } else {
                System.out.println("Id not found");
            }
        } catch (Exception eq) {
            System.out.println("Failed updation");
        }
    }

    @Override
    public List<CheckupBooking> getCheckupBookingsByUsername(String username) {
        // First, fetch the user object based on the username (email or username)
        User user = getUserIdByUsername(username);  // This calls your method

        if (user == null) {
            // Handle the case when no user is found (return empty list or throw exception)
            System.out.println("No user found for the username: " + username);
            return new ArrayList<>();  // Return empty list if no user found
        }

        // Now, fetch CheckupBookings based on the retrieved userId
        return em.createQuery("SELECT c FROM CheckupBooking c WHERE c.bussinessId.id = :userId", CheckupBooking.class)
                .setParameter("userId", user.getId()) // Use the userId from the fetched User
                .getResultList();
    }

    @Override
    public void toggleCheckupBookingStatus(int id) {
        try {
            CheckupBooking role = em.find(CheckupBooking.class, id);
            if (role != null) {
                String currentStatus = role.getStatus();
                String newStatus = currentStatus.equalsIgnoreCase("Active") ? "Block" : "Active";
                role.setStatus(newStatus);
                em.merge(role);

                System.out.println("Role status for ID " + id + " changed to " + newStatus);
            } else {

                System.out.println("Role with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while toggling role status: " + e.getMessage());
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
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
    public void addBlog(int userId, String name, String image, String descritpion, String status) {
        try {
            User role = em.find(User.class, userId);
            if (role == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + userId);
            }
            Blog r = new Blog();
            r.setUserId(role);
            r.setName(name);
            r.setImage(image);

            r.setDescription(descritpion);
            r.setStatus(status);

            Date currentDate = new Date();
            r.setCreatedAt(currentDate);
            r.setUpdatedAt(currentDate);

            em.persist(r);
            System.out.println("Role successfully added: " + r);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error adding role: " + e.getMessage());
        }
    }

    @Override
    public List<Blog> getBlogsByUsername(String username) {
// First, fetch the user object based on the username (email or username)
        User user = getUserIdByUsername(username);  // This calls your method

        if (user == null) {
            // Handle the case when no user is found (return empty list or throw exception)
            System.out.println("No user found for the username: " + username);
            return new ArrayList<>();  // Return empty list if no user found
        }

        // Now, fetch CheckupBookings based on the retrieved userId
        return em.createQuery("SELECT c FROM Blog c WHERE c.userId.id = :userId", Blog.class)
                .setParameter("userId", user.getId()) // Use the userId from the fetched User
                .getResultList();
    }

    @Override
    public void toggleBlogStatus(int id) {
        try {
            Blog role = em.find(Blog.class, id);
            if (role != null) {
                String currentStatus = role.getStatus();
                String newStatus = currentStatus.equalsIgnoreCase("Active") ? "Block" : "Active";
                role.setStatus(newStatus);
                em.merge(role);

                System.out.println("Role status for ID " + id + " changed to " + newStatus);
            } else {

                System.out.println("Role with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while toggling role status: " + e.getMessage());
        }
    }

    @Override
    public void updateBlog(int blogId, String name, String image, String descritpion, String status) {
        try {

            Blog c = em.find(Blog.class, blogId);
            if (c != null) {
                c.setName(name);
                c.setImage(image);
                c.setDescription(descritpion);
                c.setStatus(status);
                c.setUpdatedAt(new Date());
                em.merge(c);
                System.out.println("updated successfuly");

            } else {
                System.out.println("Id not found");
            }
        } catch (Exception eq) {
            System.out.println("Failed updation");
        }
    }

    public List<HealthRecord> findAppointmentsByCheckupBookingId(Integer checkupBookingId) {
        List<HealthRecord> query = em.createQuery(
                "SELECT h FROM HealthRecord h where h.bookId.id = :id")
                .setParameter("id", checkupBookingId)
                .getResultList();
        return query;

    }
}
