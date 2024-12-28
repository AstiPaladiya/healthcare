/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Blog;
import entity.Category;
import entity.CheckupBooking;
import entity.HealthRecord;
import entity.User;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author palad
 */
@Local
public interface userViewLocal {

    List<Category> getAllCategoriesForDoctor();

    List<User> getAllActiveDoctor();

    User getDoctorById(int doctorId);

    List<Blog> getAllActiveBlog();

    void addFeedBack(String name, String email, String message);

    List<CheckupBooking> fetchDoctorSchedule();

    void addHealthrecord(int bookId, int paitentId, Date appointmentDate, String paitentName, BigInteger phoneNo, String email, String message, String status);

    User getUserIdByUsername(String username);

    List<HealthRecord> getUserByRecord(int userId);

    Long countActiveDoctors();

    Long countActiveUsers();

    Long countTotalUsers();
    Long totalSubscription();
}
