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
import javax.persistence.Lob;
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
@Table(name = "subscription")
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s"),
    @NamedQuery(name = "Subscription.findById", query = "SELECT s FROM Subscription s WHERE s.id = :id"),
    @NamedQuery(name = "Subscription.findByPlanName", query = "SELECT s FROM Subscription s WHERE s.planName = :planName"),
    @NamedQuery(name = "Subscription.findByPrice", query = "SELECT s FROM Subscription s WHERE s.price = :price"),
    @NamedQuery(name = "Subscription.findByTimePeriod", query = "SELECT s FROM Subscription s WHERE s.timePeriod = :timePeriod"),
    @NamedQuery(name = "Subscription.findByStatus", query = "SELECT s FROM Subscription s WHERE s.status = :status"),
    @NamedQuery(name = "Subscription.findByCreatedAt", query = "SELECT s FROM Subscription s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "Subscription.findByUpdatedAt", query = "SELECT s FROM Subscription s WHERE s.updatedAt = :updatedAt")})
public class Subscription implements Serializable {

    @Size(max = 300)
    @Column(name = "plan_name")
    private String planName;
    @Lob
    @Size(max = 65535)
    @Column(name = "plan_detail")
    private String planDetail;
    @Size(max = 200)
    @Column(name = "status")
    private String status;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "time_period")
    private Integer timePeriod;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "subscriptionId")
    private Collection<SubscriptionUser> subscriptionUserCollection;
    @OneToMany(mappedBy = "subscriptionId")
    private Collection<User> userCollection;

    public Subscription() {
    }

    public Subscription(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDetail() {
        return planDetail;
    }

    public void setPlanDetail(String planDetail) {
        this.planDetail = planDetail;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
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
@JsonbTransient

    public Collection<SubscriptionUser> getSubscriptionUserCollection() {
        return subscriptionUserCollection;
    }

    public void setSubscriptionUserCollection(Collection<SubscriptionUser> subscriptionUserCollection) {
        this.subscriptionUserCollection = subscriptionUserCollection;
    }
@JsonbTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Subscription[ id=" + id + " ]";
    }





    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
