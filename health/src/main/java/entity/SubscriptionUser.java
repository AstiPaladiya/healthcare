/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author palad
 */
@Entity
@Table(name = "subscription_user")
@NamedQueries({
    @NamedQuery(name = "SubscriptionUser.findAll", query = "SELECT s FROM SubscriptionUser s"),
    @NamedQuery(name = "SubscriptionUser.findById", query = "SELECT s FROM SubscriptionUser s WHERE s.id = :id"),
    @NamedQuery(name = "SubscriptionUser.findByExpiaryDate", query = "SELECT s FROM SubscriptionUser s WHERE s.expiaryDate = :expiaryDate"),
    @NamedQuery(name = "SubscriptionUser.findByPaymentMode", query = "SELECT s FROM SubscriptionUser s WHERE s.paymentMode = :paymentMode"),
    @NamedQuery(name = "SubscriptionUser.findByStatus", query = "SELECT s FROM SubscriptionUser s WHERE s.status = :status"),
    @NamedQuery(name = "SubscriptionUser.findByCreatedAt", query = "SELECT s FROM SubscriptionUser s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SubscriptionUser.findByUpdatedAt", query = "SELECT s FROM SubscriptionUser s WHERE s.updatedAt = :updatedAt")})
public class SubscriptionUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "expiary_date")
    @Temporal(TemporalType.DATE)
    private Date expiaryDate;
    @Size(max = 200)
    @Column(name = "payment_mode")
    private String paymentMode;
    @Size(max = 200)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    @ManyToOne
    private Subscription subscriptionId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public SubscriptionUser() {
    }

    public SubscriptionUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpiaryDate() {
        return expiaryDate;
    }

    public void setExpiaryDate(Date expiaryDate) {
        this.expiaryDate = expiaryDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Subscription subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof SubscriptionUser)) {
            return false;
        }
        SubscriptionUser other = (SubscriptionUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SubscriptionUser[ id=" + id + " ]";
    }
    
}
