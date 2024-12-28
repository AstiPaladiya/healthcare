/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author palad
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhoneNo", query = "SELECT u FROM User u WHERE u.phoneNo = :phoneNo"),
    @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender"),
    @NamedQuery(name = "User.findByEmergencyNo", query = "SELECT u FROM User u WHERE u.emergencyNo = :emergencyNo"),
    @NamedQuery(name = "User.findByPincode", query = "SELECT u FROM User u WHERE u.pincode = :pincode"),
    @NamedQuery(name = "User.findByState", query = "SELECT u FROM User u WHERE u.state = :state"),
    @NamedQuery(name = "User.findByCity", query = "SELECT u FROM User u WHERE u.city = :city"),
    @NamedQuery(name = "User.findByMedicalLicense", query = "SELECT u FROM User u WHERE u.medicalLicense = :medicalLicense"),
    @NamedQuery(name = "User.findByYearOfExpirence", query = "SELECT u FROM User u WHERE u.yearOfExpirence = :yearOfExpirence"),
    @NamedQuery(name = "User.findByDegree", query = "SELECT u FROM User u WHERE u.degree = :degree"),
    @NamedQuery(name = "User.findByCurrentPosition", query = "SELECT u FROM User u WHERE u.currentPosition = :currentPosition"),
    @NamedQuery(name = "User.findByWorkSchedule", query = "SELECT u FROM User u WHERE u.workSchedule = :workSchedule"),
    @NamedQuery(name = "User.findByRegistrationDate", query = "SELECT u FROM User u WHERE u.registrationDate = :registrationDate"),
    @NamedQuery(name = "User.findByWebsite", query = "SELECT u FROM User u WHERE u.website = :website"),
    @NamedQuery(name = "User.findByExpiaryDate", query = "SELECT u FROM User u WHERE u.expiaryDate = :expiaryDate"),
    @NamedQuery(name = "User.findByMacAddress", query = "SELECT u FROM User u WHERE u.macAddress = :macAddress"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByCreatedAt", query = "SELECT u FROM User u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "User.findByUpdatedAt", query = "SELECT u FROM User u WHERE u.updatedAt = :updatedAt")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 65535)
    @Column(name = "first_name")
    private String firstName;
    @Lob
    @Size(max = 65535)
    @Column(name = "last_name")
    private String lastName;
    @Lob
    @Size(max = 65535)
    @Column(name = "password")
    private String password;
    @Column(name = "phone_no")
    private BigInteger phoneNo;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 300)
    @Column(name = "gender")
    private String gender;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    @Column(name = "emergency_no")
    private BigInteger emergencyNo;
    @Lob
    @Size(max = 65535)
    @Column(name = "profile")
    private String profile;
    @Column(name = "pincode")
    private Integer pincode;
    @Size(max = 400)
    @Column(name = "state")
    private String state;
    @Size(max = 400)
    @Column(name = "city")
    private String city;
    @Lob
    @Size(max = 65535)
    @Column(name = "specialization")
    private String specialization;
    @Size(max = 400)
    @Column(name = "medical_license")
    private String medicalLicense;
    @Size(max = 300)
    @Column(name = "year_of_expirence")
    private String yearOfExpirence;
    @Size(max = 250)
    @Column(name = "degree")
    private String degree;
    @Lob
    @Size(max = 65535)
    @Column(name = "certification")
    private String certification;
    @Lob
    @Size(max = 65535)
    @Column(name = "affiliate_hospital")
    private String affiliateHospital;
    @Size(max = 400)
    @Column(name = "current_position")
    private String currentPosition;
    @Size(max = 500)
    @Column(name = "work_schedule")
    private String workSchedule;
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "bio")
    private String bio;
    @Lob
    @Size(max = 65535)
    @Column(name = "hospital_name")
    private String hospitalName;
    @Size(max = 400)
    @Column(name = "website")
    private String website;
    @Column(name = "expiary_date")
    @Temporal(TemporalType.DATE)
    private Date expiaryDate;
    @Size(max = 400)
    @Column(name = "mac_address")
    private String macAddress;
    @Size(max = 200)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private Role roleId;
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    @ManyToOne
    private Subscription subscriptionId;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getEmergencyNo() {
        return emergencyNo;
    }

    public void setEmergencyNo(BigInteger emergencyNo) {
        this.emergencyNo = emergencyNo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMedicalLicense() {
        return medicalLicense;
    }

    public void setMedicalLicense(String medicalLicense) {
        this.medicalLicense = medicalLicense;
    }

    public String getYearOfExpirence() {
        return yearOfExpirence;
    }

    public void setYearOfExpirence(String yearOfExpirence) {
        this.yearOfExpirence = yearOfExpirence;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getAffiliateHospital() {
        return affiliateHospital;
    }

    public void setAffiliateHospital(String affiliateHospital) {
        this.affiliateHospital = affiliateHospital;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getExpiaryDate() {
        return expiaryDate;
    }

    public void setExpiaryDate(Date expiaryDate) {
        this.expiaryDate = expiaryDate;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Subscription subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ id=" + id + " ]";
    }
    
}
