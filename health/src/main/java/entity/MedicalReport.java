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
@Table(name = "medical_report")
@NamedQueries({
    @NamedQuery(name = "MedicalReport.findAll", query = "SELECT m FROM MedicalReport m"),
    @NamedQuery(name = "MedicalReport.findById", query = "SELECT m FROM MedicalReport m WHERE m.id = :id"),
    @NamedQuery(name = "MedicalReport.findByReportName", query = "SELECT m FROM MedicalReport m WHERE m.reportName = :reportName"),
    @NamedQuery(name = "MedicalReport.findByReportType", query = "SELECT m FROM MedicalReport m WHERE m.reportType = :reportType"),
    @NamedQuery(name = "MedicalReport.findByReportDate", query = "SELECT m FROM MedicalReport m WHERE m.reportDate = :reportDate"),
    @NamedQuery(name = "MedicalReport.findByReportStatus", query = "SELECT m FROM MedicalReport m WHERE m.reportStatus = :reportStatus"),
    @NamedQuery(name = "MedicalReport.findByStatus", query = "SELECT m FROM MedicalReport m WHERE m.status = :status"),
    @NamedQuery(name = "MedicalReport.findByCreatedAt", query = "SELECT m FROM MedicalReport m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MedicalReport.findByUpdatedAt", query = "SELECT m FROM MedicalReport m WHERE m.updatedAt = :updatedAt")})
public class MedicalReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 400)
    @Column(name = "report_name")
    private String reportName;
    @Size(max = 300)
    @Column(name = "report_type")
    private String reportType;
    @Column(name = "report_date")
    @Temporal(TemporalType.DATE)
    private Date reportDate;
    @Size(max = 200)
    @Column(name = "report_status")
    private String reportStatus;
    @Lob
    @Size(max = 65535)
    @Column(name = "summery")
    private String summery;
    @Size(max = 200)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "health_record_id", referencedColumnName = "id")
    @ManyToOne
    private HealthRecord healthRecordId;

    public MedicalReport() {
    }

    public MedicalReport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
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

    public HealthRecord getHealthRecordId() {
        return healthRecordId;
    }

    public void setHealthRecordId(HealthRecord healthRecordId) {
        this.healthRecordId = healthRecordId;
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
        if (!(object instanceof MedicalReport)) {
            return false;
        }
        MedicalReport other = (MedicalReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MedicalReport[ id=" + id + " ]";
    }
    
}
