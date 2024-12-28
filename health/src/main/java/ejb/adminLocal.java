/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Blog;
import entity.Category;
import entity.Feedback;
import entity.Product;
import javax.ejb.Local;
import entity.Role;
import entity.Subscription;
import entity.SubscriptionUser;
import entity.User;
import java.util.List;

/**
 *
 * @author palad
 */
@Local
public interface adminLocal {
//    String changeRoleStatus(int id);

    void addRole(String name, String status);

    void deleteRole(int id);

    void updateRole(int roleId, String name, String status);

    public List<Role> getAllRoles();

    void toggleRoleStatus(int id);
//   public List<Category> getAllCategoryes();

    void addSubscription(String plan_name, String plan_detail, float price, int time_period, String status);

    void deleteSubscription(int subscriptionId);

    void updateSubscription(int subscriptionId, String plan_name, String plan_detail, float price, int time_period, String status);

    public List<Subscription> getAllSubscriptions();

    void addCategory(int roleId, String name, String description, String image, String status);

    void deleteCategory(int categoryId);

    void updateCategory(int categoryId, int roleCId, String name, String description, String image, String status);

    List<Category> getAllCategoryes();

    List<Product> getAllProducts();

    List<Blog> getAllBlogs();

    void toggleBlogStatus(int id);

    Blog findBlogById(int id);

    List<Feedback> getAllFeedbacks();

    SubscriptionUser findSubscriptionUserById(int id);

    List<User> getAllUsers();

    void toggleUserStatus(int id);

    User findUserById(int userId);
}
