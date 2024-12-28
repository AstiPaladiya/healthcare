/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Blog;
import entity.CheckupBooking;
import entity.HealthRecord;
import entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author palad
 */
@Local
public interface doctorLocal {
    
    void addCheckupBooking(int bussinessId,String schedule,float price, String status);
    void updateCheckupBooking(int checkupId,String schedule,float price, String status);
    public List<CheckupBooking> getCheckupBookingsByUsername(String username);
    void toggleCheckupBookingStatus(int id);
    User getUserIdByUsername(String username);
        
    void addBlog(int userId,String name,String image,String descritpion, String status);
    void updateBlog(int blogId,String name,String image,String descritpion, String status);
    public List<Blog> getBlogsByUsername(String username);
    void toggleBlogStatus(int id);
    
    List<HealthRecord> findAppointmentsByCheckupBookingId(Integer checkupBookingId);
}
