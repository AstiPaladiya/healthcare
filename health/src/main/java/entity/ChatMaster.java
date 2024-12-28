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
@Table(name = "chat_master")
@NamedQueries({
    @NamedQuery(name = "ChatMaster.findAll", query = "SELECT c FROM ChatMaster c"),
    @NamedQuery(name = "ChatMaster.findById", query = "SELECT c FROM ChatMaster c WHERE c.id = :id"),
    @NamedQuery(name = "ChatMaster.findByRecieverByReciever", query = "SELECT c FROM ChatMaster c WHERE c.recieverByReciever = :recieverByReciever"),
    @NamedQuery(name = "ChatMaster.findByCreatedAt", query = "SELECT c FROM ChatMaster c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "ChatMaster.findByUpdatedAt", query = "SELECT c FROM ChatMaster c WHERE c.updatedAt = :updatedAt")})
public class ChatMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "message")
    private String message;
    @Column(name = "reciever_by_reciever")
    private Integer recieverByReciever;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "reciever_id", referencedColumnName = "id")
    @ManyToOne
    private User recieverId;
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    @ManyToOne
    private User senderId;

    public ChatMaster() {
    }

    public ChatMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRecieverByReciever() {
        return recieverByReciever;
    }

    public void setRecieverByReciever(Integer recieverByReciever) {
        this.recieverByReciever = recieverByReciever;
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

    public User getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(User recieverId) {
        this.recieverId = recieverId;
    }

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
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
        if (!(object instanceof ChatMaster)) {
            return false;
        }
        ChatMaster other = (ChatMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ChatMaster[ id=" + id + " ]";
    }
    
}
