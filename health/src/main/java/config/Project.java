/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author palad
 */
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/Login.jsf"
        )
)
//        callerQuery = "select password from users where email = ?",
//        groupsQuery = "select name from role where id = (select role_id from users where email = ? )",
// Identity Store
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/test",
//        callerQuery = "select password from user where username = ?",
//        groupsQuery = "select groupname from groups where username = ?",
//        callerQuery = "select password from user where username = ?",
//        groupsQuery = "select groupname from groups where roleid = (select roleid from user where username = ? and status='Active' )",  
                callerQuery = "select password from user where email = ?",
        groupsQuery = "select name from role where id = (select role_id from user where email = ? )",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)
@ApplicationScoped
public class Project {

    /**
     * Creates a new instance of Project
     */
    public Project() {
    }
    
}
