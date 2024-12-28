/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
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
@Table(name = "career")
@NamedQueries({
    @NamedQuery(name = "Career.findAll", query = "SELECT c FROM Career c"),
    @NamedQuery(name = "Career.findById", query = "SELECT c FROM Career c WHERE c.id = :id"),
    @NamedQuery(name = "Career.findByCarrerName", query = "SELECT c FROM Career c WHERE c.carrerName = :carrerName"),
    @NamedQuery(name = "Career.findByTime", query = "SELECT c FROM Career c WHERE c.time = :time"),
    @NamedQuery(name = "Career.findByExperience", query = "SELECT c FROM Career c WHERE c.experience = :experience"),
    @NamedQuery(name = "Career.findByDegree", query = "SELECT c FROM Career c WHERE c.degree = :degree"),
    @NamedQuery(name = "Career.findByStatus", query = "SELECT c FROM Career c WHERE c.status = :status"),
    @NamedQuery(name = "Career.findByCreatedAt", query = "SELECT c FROM Career c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Career.findByUpdatedAt", query = "SELECT c FROM Career c WHERE c.updatedAt = :updatedAt")})
public class Career implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 400)
    @Column(name = "carrer_name")
    private String carrerName;
    @Size(max = 400)
    @Column(name = "time")
    private String time;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 300)
    @Column(name = "experience")
    private String experience;
    @Size(max = 500)
    @Column(name = "degree")
    private String degree;
    @Size(max = 200)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @OneToMany(mappedBy = "careerId")
    private Collection<Job> jobCollection;

    public Career() {
    }

    public Career(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrerName() {
        return carrerName;
    }

    public void setCarrerName(String carrerName) {
        this.carrerName = carrerName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
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
        if (!(object instanceof Career)) {
            return false;
        }
        Career other = (Career) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Career[ id=" + id + " ]";
    }
    
}
