/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
@Table(name = "order_master")
@NamedQueries({
    @NamedQuery(name = "OrderMaster.findAll", query = "SELECT o FROM OrderMaster o"),
    @NamedQuery(name = "OrderMaster.findById", query = "SELECT o FROM OrderMaster o WHERE o.id = :id"),
    @NamedQuery(name = "OrderMaster.findByBillNo", query = "SELECT o FROM OrderMaster o WHERE o.billNo = :billNo"),
    @NamedQuery(name = "OrderMaster.findByRecieverName", query = "SELECT o FROM OrderMaster o WHERE o.recieverName = :recieverName"),
    @NamedQuery(name = "OrderMaster.findByPhoneNo", query = "SELECT o FROM OrderMaster o WHERE o.phoneNo = :phoneNo"),
    @NamedQuery(name = "OrderMaster.findByEmail", query = "SELECT o FROM OrderMaster o WHERE o.email = :email"),
    @NamedQuery(name = "OrderMaster.findByTotalAmount", query = "SELECT o FROM OrderMaster o WHERE o.totalAmount = :totalAmount"),
    @NamedQuery(name = "OrderMaster.findBySellingDate", query = "SELECT o FROM OrderMaster o WHERE o.sellingDate = :sellingDate"),
    @NamedQuery(name = "OrderMaster.findByPaymentMode", query = "SELECT o FROM OrderMaster o WHERE o.paymentMode = :paymentMode"),
    @NamedQuery(name = "OrderMaster.findByStatus", query = "SELECT o FROM OrderMaster o WHERE o.status = :status"),
    @NamedQuery(name = "OrderMaster.findByCreatedAt", query = "SELECT o FROM OrderMaster o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "OrderMaster.findByUpdatedAt", query = "SELECT o FROM OrderMaster o WHERE o.updatedAt = :updatedAt")})
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bill_no")
    private Integer billNo;
    @Size(max = 300)
    @Column(name = "reciever_name")
    private String recieverName;
    @Column(name = "phone_no")
    private BigInteger phoneNo;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 300)
    @Column(name = "email")
    private String email;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amount")
    private Float totalAmount;
    @Column(name = "selling_date")
    @Temporal(TemporalType.DATE)
    private Date sellingDate;
    @Size(max = 300)
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
    @JoinColumn(name = "buyer_user_id", referencedColumnName = "id")
    @ManyToOne
    private User buyerUserId;
    @OneToMany(mappedBy = "orderMasterId")
    private Collection<OrderDetail> orderDetailCollection;

    public OrderMaster() {
    }

    public OrderMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillNo() {
        return billNo;
    }

    public void setBillNo(Integer billNo) {
        this.billNo = billNo;
    }

    public String getRecieverName() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
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

    public User getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(User buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
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
        if (!(object instanceof OrderMaster)) {
            return false;
        }
        OrderMaster other = (OrderMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderMaster[ id=" + id + " ]";
    }
    
}
