/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author palad
 */
@Stateless
public class UserService {

    @PersistenceContext(unitName = "health")
    private EntityManager em;

    public String getUserStatus(String username) {
        try {
            TypedQuery<String> query = em.createQuery(
                "SELECT u.status FROM User u WHERE u.email = :username", String.class);
            query.setParameter("username", username);

            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving user status", e);
        }
    }
}
