/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author palad
 */
@Entity
@Table(name = "checkup_booking")
@NamedQueries({
    @NamedQuery(name = "CheckupBooking.findAll", query = "SELECT c FROM CheckupBooking c"),
    @NamedQuery(name = "CheckupBooking.findById", query = "SELECT c FROM CheckupBooking c WHERE c.id = :id"),
    @NamedQuery(name = "CheckupBooking.findBySchedule", query = "SELECT c FROM CheckupBooking c WHERE c.schedule = :schedule"),
    @NamedQuery(name = "CheckupBooking.findByPrice", query = "SELECT c FROM CheckupBooking c WHERE c.price = :price"),
    @NamedQuery(name = "CheckupBooking.findByStatus", query = "SELECT c FROM CheckupBooking c WHERE c.status = :status"),
    @NamedQuery(name = "CheckupBooking.findByCreatedAt", query = "SELECT c FROM CheckupBooking c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CheckupBooking.findByUpdatedAt", query = "SELECT c FROM CheckupBooking c WHERE c.updatedAt = :updatedAt")})
public class CheckupBooking implements Serializable {

    @Size(max = 500)
    @Column(name = "schedule")
    private String schedule;
    @Size(max = 200)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "bookId")
    private Collection<HealthRecord> healthRecordCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "bussiness_id", referencedColumnName = "id")
    @ManyToOne
    private User bussinessId;

    public CheckupBooking() {
    }

    public CheckupBooking(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public User getBussinessId() {
        return bussinessId;
    }

    public void setBussinessId(User bussinessId) {
        this.bussinessId = bussinessId;
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
        if (!(object instanceof CheckupBooking)) {
            return false;
        }
        CheckupBooking other = (CheckupBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CheckupBooking[ id=" + id + " ]";
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
@JsonbTransient
    public Collection<HealthRecord> getHealthRecordCollection() {
        return healthRecordCollection;
    }
@JsonbTransient
    public void setHealthRecordCollection(Collection<HealthRecord> healthRecordCollection) {
        this.healthRecordCollection = healthRecordCollection;
    }
    
}
