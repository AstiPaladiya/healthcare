/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author palad
 */
@DeclareRoles({"Admin","Doctor","Pharmacist","User"})

@Stateless
public class SecureDoctorBean {
 @RolesAllowed("Doctor")  

public String saySecureHello()
{
    return "Secure Hello Doctor from Secure Bean";
}
}
