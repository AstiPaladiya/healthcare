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
@Table(name = "health_record")
@NamedQueries({
    @NamedQuery(name = "HealthRecord.findAll", query = "SELECT h FROM HealthRecord h"),
    @NamedQuery(name = "HealthRecord.findById", query = "SELECT h FROM HealthRecord h WHERE h.id = :id"),
    @NamedQuery(name = "HealthRecord.findByAppointmentDate", query = "SELECT h FROM HealthRecord h WHERE h.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "HealthRecord.findByAppointmentTime", query = "SELECT h FROM HealthRecord h WHERE h.appointmentTime = :appointmentTime"),
    @NamedQuery(name = "HealthRecord.findByPaitentName", query = "SELECT h FROM HealthRecord h WHERE h.paitentName = :paitentName"),
    @NamedQuery(name = "HealthRecord.findByPaitentPhoneno", query = "SELECT h FROM HealthRecord h WHERE h.paitentPhoneno = :paitentPhoneno"),
    @NamedQuery(name = "HealthRecord.findByPaitentEmail", query = "SELECT h FROM HealthRecord h WHERE h.paitentEmail = :paitentEmail"),
    @NamedQuery(name = "HealthRecord.findByStatus", query = "SELECT h FROM HealthRecord h WHERE h.status = :status"),
    @NamedQuery(name = "HealthRecord.findByCreatedAt", query = "SELECT h FROM HealthRecord h WHERE h.createdAt = :createdAt"),
    @NamedQuery(name = "HealthRecord.findByUpdatedAt", query = "SELECT h FROM HealthRecord h WHERE h.updatedAt = :updatedAt")})
public class HealthRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "appointment_date")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;
    @Column(name = "appointment_time")
    @Temporal(TemporalType.TIME)
    private Date appointmentTime;
    @Size(max = 300)
    @Column(name = "paitent_name")
    private String paitentName;
    @Column(name = "paitent_phoneno")
    private BigInteger paitentPhoneno;
    @Size(max = 400)
    @Column(name = "paitent_email")
    private String paitentEmail;
    @Lob
    @Size(max = 65535)
    @Column(name = "information")
    private String information;
    @Size(max = 200)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne
    private CheckupBooking bookId;
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne
    private User patientId;

    public HealthRecord() {
    }

    public HealthRecord(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getPaitentName() {
        return paitentName;
    }

    public void setPaitentName(String paitentName) {
        this.paitentName = paitentName;
    }

    public BigInteger getPaitentPhoneno() {
        return paitentPhoneno;
    }

    public void setPaitentPhoneno(BigInteger paitentPhoneno) {
        this.paitentPhoneno = paitentPhoneno;
    }

    public String getPaitentEmail() {
        return paitentEmail;
    }

    public void setPaitentEmail(String paitentEmail) {
        this.paitentEmail = paitentEmail;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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

    public CheckupBooking getBookId() {
        return bookId;
    }

    public void setBookId(CheckupBooking bookId) {
        this.bookId = bookId;
    }

    public User getPatientId() {
        return patientId;
    }

    public void setPatientId(User patientId) {
        this.patientId = patientId;
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
        if (!(object instanceof HealthRecord)) {
            return false;
        }
        HealthRecord other = (HealthRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HealthRecord[ id=" + id + " ]";
    }
    
}
