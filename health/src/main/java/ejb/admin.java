/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Blog;
import entity.Category;
import entity.Feedback;
import entity.Product;
import entity.Role;
import entity.Subscription;
import entity.SubscriptionUser;
import entity.User;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
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
public class admin implements adminLocal {

    @PersistenceContext(unitName = "health")
    EntityManager em;
//    role
//    @Override
//    public String changeRoleStatus(int id) {
//        Role s = em.find(Role.class, id);
//        if (s != null) {
//            String newStatus = s.getStatus().equals("active") ? "blocked" : "active";
//            s.setStatus(newStatus);
//            em.merge(s);
//            return newStatus;
//        }
//        throw new IllegalArgumentException("User with ID " + id + " not found.");
//    }

    @Override
    public void addRole(String name, String status) {
        try {
            Role r = new Role();
            r.setName(name);
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
    public List<Role> getAllRoles() {
        // Use the named query with Role.class to return a list of Role entities
//        return em.createNamedQuery("Role.findAll", Role.class).getResultList();      
        List<Role> data = em.createQuery("select p from Role p where p.id!=7").getResultList();
        System.out.println(data.toString());
        try {
            System.out.println("Successfully retrieved  roles.");
        } catch (Exception e) {
            System.err.println("An error occurred while retrieving roles");
        }
        return data;
    }

    @Override
    public void deleteRole(int id) {
        try {
            Role role = em.find(Role.class, id);
            if (role != null) {
                em.remove(role);
                System.out.println("Role with ID  was successfully deleted.");
            } else {
                System.out.println("Role with ID  not found.");
            }

        } catch (Exception eq) {
            System.out.println("delete some error occured");
        }
    }

    @Override
    public void updateRole(int roleId, String name, String status) {
        try {
            Role role = em.find(Role.class, roleId);
            if (role != null) {
                role.setName(name);
                role.setStatus(status);
                role.setId(roleId); // Update the timestamp
                em.merge(role);
                System.out.println("Role with ID " + roleId + " was successfully updated.");
            } else {
                System.out.println("Role with ID " + roleId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

//    status update
    // Toggle the status of the role between Active and Blocked
    @Override
    public void toggleRoleStatus(int id) {
        try {
            Role role = em.find(Role.class, id);
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
//subscription

    @Override
    public List<Subscription> getAllSubscriptions() {
        // Use the named query with Role.class to return a list of Role entities
        return em.createNamedQuery("Subscription.findAll", Subscription.class).getResultList();
    }

    @Override
    public void addSubscription(String plan_name, String plan_detail, float price, int time_period, String status) {
        try {
            Subscription s = new Subscription();
            s.setPlanName(plan_name);
            s.setPlanDetail(plan_detail);
            s.setPrice(price);
            s.setTimePeriod(time_period);
            Date d = new Date();
            s.setCreatedAt(d);
            s.setUpdatedAt(d);
            s.setStatus(status);
            em.persist(s);
            System.out.println("Insertin Succsesfuly");
        } catch (Exception eq) {
            System.out.println("Insertin failed");
        }
    }

    @Override
    public void deleteSubscription(int subscriptionId) {
        try {
            Subscription s = em.find(Subscription.class, subscriptionId);
            if (s != null) {
                em.remove(s);
                System.out.println("Deletion failed");
            } else {
                System.out.println("Id not found ");

            }
        } catch (Exception eq) {
            System.out.println("deletion failed");
        }
    }

    @Override
    public void updateSubscription(int subscriptionId, String plan_name, String plan_detail, float price, int time_period, String status) {
        try {
            Subscription s = em.find(Subscription.class, subscriptionId);
            if (s != null) {
                s.setPlanName(plan_name);
                s.setPlanDetail(plan_detail);
                s.setPrice(price);
                s.setTimePeriod(time_period);
                s.setUpdatedAt(new Date());
                s.setStatus(status);
                em.merge(s);
                System.out.println("Updation Succsesfuly");
            } else {
                System.out.println("Id not found ");

            }
        } catch (Exception eq) {
            System.out.println("updation failed");
        }

    }

//    category
    @Override
    public void addCategory(int roleId, String name, String description, String image, String status) {
        try {
            Role role = em.find(Role.class, roleId);
            if (role == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + roleId);
            }
            Category c = new Category();
            c.setRoleId(role);
            c.setName(name);
            c.setDescription(description);
            c.setImage(image);
            c.setStatus(status);
            Date currentDate = new Date();
            c.setCreatedAt(currentDate);
            c.setUpdatedAt(currentDate);
            em.persist(c);
            System.out.println("Added successfuly");
        } catch (Exception eq) {
            eq.printStackTrace();
            System.out.println("Failrd insertion");
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        try {
            Category c = em.find(Category.class, categoryId);
            if (c != null) {
                em.remove(c);
                System.out.println("Deleted successfully");
            } else {
                System.out.println("Id not found");
            }
        } catch (Exception eq) {
            System.out.println("Failed Deletion");
        }
    }

    @Override
    public void updateCategory(int categoryId, int roleCId, String name, String description, String image, String status) {
        try {
            Role role = em.find(Role.class, roleCId);
            if (role == null) {
                throw new IllegalArgumentException("Role ID does not exist: " + roleCId);
            }
            Category c = em.find(Category.class, categoryId);
            if (c != null) {
                c.setRoleId(role);
                c.setName(name);
                c.setDescription(description);
                c.setImage(image);
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
    public List<Category> getAllCategoryes() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
//         return em.createQuery("SELECT new yourpackage.CategoryWithRoleNameDTO(c.name, c.description, c.image, c.status, r.name) " +
//                          "FROM Category c JOIN c.role r", CategoryWithRoleNameDTO.class)
//             .getResultList();
    }

//     product
    @Override
    public List<Product> getAllProducts() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();

    }

    @Override
    public List<Blog> getAllBlogs() {

        List<Blog> blogs = em.createQuery("select s from Blog s").getResultList();
//         System.out.println(blogs.toString());
        return blogs;
//         return em.createQuery("SELECT new yourpackage.CategoryWithRoleNameDTO(c.name, c.description, c.image, c.status, r.name) " +
//                          "FROM Category c JOIN c.role r", CategoryWithRoleNameDTO.class)
//             .getResultList();
    }
    // Toggle the status of the role between Active and Blocked

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

    public Blog findBlogById(int id) {
        return em.find(Blog.class, id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> blogs = em.createQuery("select s from Feedback s").getResultList();
//         System.out.println(blogs.toString());
        return blogs;
    }

    @Override
//    public SubscriptionUser findSubscriptionUserById(int subscriptionId) {
//        String jpql = "SELECT new com.example.dto.SubscriptionUser(su.Id, su.subscriptionId, su.expiryDate, su.userId, su.paymentMode, u.firstName, u.email, u.phoneNo) " +
//                      "FROM SubscriptionUser su " +
//                      "JOIN User u ON su.userId = u.id " +
//                      "WHERE su.subscriptionId = :subscriptionId";
//
//        TypedQuery<SubscriptionUser> query = em.createQuery(jpql, SubscriptionUser.class);
//        query.setParameter("subscriptionId", subscriptionId);
//        return query.getSingleResult();
//    }
    public SubscriptionUser findSubscriptionUserById(int subscriptionId) {
        try {
            String jpql = "SELECT su FROM SubscriptionUser su WHERE su.subscriptionId = :subscriptionId";
            TypedQuery<SubscriptionUser> query = em.createQuery(jpql, SubscriptionUser.class);
            query.setParameter("subscriptionId", subscriptionId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Handle cases where no result is found
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching SubscriptionUser", e);
        }
    }
 
    @Override
    public List<User> getAllUsers()
    {
                return em.createNamedQuery("User.findAll", User.class).getResultList();

    }
       @Override
    public void toggleUserStatus(int id) {
        try {
            User role = em.find(User.class, id);
            if (role != null) {
                String currentStatus = role.getStatus();
                String newStatus = currentStatus.equalsIgnoreCase("Active") ? "Block" : "Active";
                role.setStatus(newStatus);
                em.merge(role);

                System.out.println("User status for ID " + id + " changed to " + newStatus);
            } else {
                System.out.println("User with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while toggling role status: " + e.getMessage());
        }
    }
     @Override
    public User findUserById(int userId) {
        return em.find(User.class, userId); // Directly fetch the user from the database
    }
}
