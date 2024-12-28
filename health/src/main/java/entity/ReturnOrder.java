/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
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
@Table(name = "return_order")
@NamedQueries({
    @NamedQuery(name = "ReturnOrder.findAll", query = "SELECT r FROM ReturnOrder r"),
    @NamedQuery(name = "ReturnOrder.findById", query = "SELECT r FROM ReturnOrder r WHERE r.id = :id"),
    @NamedQuery(name = "ReturnOrder.findByImg", query = "SELECT r FROM ReturnOrder r WHERE r.img = :img"),
    @NamedQuery(name = "ReturnOrder.findByStatus", query = "SELECT r FROM ReturnOrder r WHERE r.status = :status"),
    @NamedQuery(name = "ReturnOrder.findByCreatedAt", query = "SELECT r FROM ReturnOrder r WHERE r.createdAt = :createdAt"),
    @NamedQuery(name = "ReturnOrder.findByUpdatedAt", query = "SELECT r FROM ReturnOrder r WHERE r.updatedAt = :updatedAt")})
public class ReturnOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "order_problem")
    private String orderProblem;
    @Size(max = 400)
    @Column(name = "img")
    private String img;
    @Size(max = 200)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
    @ManyToOne
    private OrderDetail orderDetailId;

    public ReturnOrder() {
    }

    public ReturnOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderProblem() {
        return orderProblem;
    }

    public void setOrderProblem(String orderProblem) {
        this.orderProblem = orderProblem;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public OrderDetail getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(OrderDetail orderDetailId) {
        this.orderDetailId = orderDetailId;
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
        if (!(object instanceof ReturnOrder)) {
            return false;
        }
        ReturnOrder other = (ReturnOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReturnOrder[ id=" + id + " ]";
    }
    
}
