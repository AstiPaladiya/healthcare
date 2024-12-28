/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Blog;
import entity.Category;
import entity.CheckupBooking;
import entity.Feedback;
import entity.HealthRecord;
import entity.User;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author palad
 */
@Stateless
public class userView implements userViewLocal {
    
    @PersistenceContext(unitName = "health")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Category> getAllCategoriesForDoctor() {
        return em.createQuery(
                "SELECT c FROM Category c JOIN c.roleId r WHERE r.name = :roleName",
                Category.class
        )
                .setParameter("roleName", "Doctor")
                .getResultList();
    }
    
    @Override
    public List<User> getAllActiveDoctor() {
        return em.createQuery(
                "SELECT u FROM User u JOIN u.roleId r WHERE r.name = :roleName AND u.status = :status",
                User.class
        )
                .setParameter("roleName", "Doctor")
                .setParameter("status", "Active")
                .getResultList();
    }
    
    @Override
    public User getDoctorById(int doctorId) {
        return em.createQuery("SELECT u FROM User u WHERE u.id = :doctorId", User.class)
                .setParameter("doctorId", doctorId)
                .getSingleResult();
    }
    
    @Override
    public List<Blog> getAllActiveBlog() {
        String jpql = "SELECT b FROM Blog b WHERE b.status = 'Active'";
        return em.createQuery(jpql, Blog.class).getResultList();
    }
    
    @Override
    public void addFeedBack(String name, String email, String message) {
        try {
            Feedback r = new Feedback();
            r.setName(name);
            r.setEmail(email);
            r.setFeedback(message);
            
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
    public List<CheckupBooking> fetchDoctorSchedule() {
        
        List<CheckupBooking> bookings = em.createQuery("Select b from CheckupBooking b where  b.status = 'Active'")
                .getResultList();
        System.out.println(bookings.toString());
        return bookings;
    }
    
    @Override
    public void addHealthrecord(int bookId, int paitentId,Date appointmentDate, String paitentName, BigInteger phoneNo, String email, String message,String status) {
        try {
              User u = em.find(User.class, paitentId);
            if (u == null) {
                throw new IllegalArgumentException("user ID does not exist: " + paitentId);
            }
              CheckupBooking chk = em.find(CheckupBooking.class, bookId);
            if (chk == null) {
                throw new IllegalArgumentException("checkup ID does not exist: " + chk);
            }
            HealthRecord r = new HealthRecord();
            r.setBookId(chk);
            r.setPatientId(u);
            r.setAppointmentDate(appointmentDate);
            r.setInformation(message);
            r.setPaitentEmail(email);
            r.setPaitentName(paitentName);
            r.setPaitentPhoneno(phoneNo);
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
public List<HealthRecord> getUserByRecord(int userId) {
    // Use a parameterized query to safely include userId
    List<HealthRecord> record = em.createQuery(
            "SELECT b FROM HealthRecord b WHERE b.paitentId = :userId", HealthRecord.class)
            .setParameter("userId", userId)
            .getResultList();
    
    // Debugging: Print the fetched records
    System.out.println(record.toString());
    
    return record;
}

@Override
public Long countActiveDoctors() {
  
   
   List<User> users = em.createQuery("select u from User u where u.roleId.name = :rId AND u.status = :st")
           .setParameter("rId", "Doctor")
           .setParameter("st", "Active")
           .getResultList();
return Long.valueOf(users.isEmpty() ? 0 : users.size());

}

@Override
public Long countActiveUsers() {
  
   
   List<User> users = em.createQuery("select u from User u where u.roleId.name = :rId AND u.status = :st")
           .setParameter("rId", "User")
           .setParameter("st", "Active")
           .getResultList();
return Long.valueOf(users.isEmpty() ? 0 : users.size());

}
@Override
public Long countTotalUsers() {
  
   
   List<User> users = em.createQuery("select u from User u where u.status = :st")
           .setParameter("st", "Active")
           .getResultList();
return Long.valueOf(users.isEmpty() ? 0 : users.size());

}
@Override
public Long totalSubscription() {
  
   
   List<User> users = em.createQuery("select u from Subscription u where u.status = :st")
           .setParameter("st", "Active")
           .getResultList();
return Long.valueOf(users.isEmpty() ? 0 : users.size());

}
}
