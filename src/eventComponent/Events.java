/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventComponent;

import clientComponent.Customers;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import locationComponent.Ballrooms;
import userComponent.Users;

/**
 *
 * @author Armando
 */
@Entity
@Table(name = "events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e"),
    @NamedQuery(name = "Events.findByEventId", query = "SELECT e FROM Events e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Events.findByCreationDate", query = "SELECT e FROM Events e WHERE e.creationDate = :creationDate"),
    @NamedQuery(name = "Events.findByEventDate", query = "SELECT e FROM Events e WHERE e.eventDate = :eventDate"),
    @NamedQuery(name = "Events.findByDescription", query = "SELECT e FROM Events e WHERE e.description = :description"),
    @NamedQuery(name = "Events.findByTotalDue", query = "SELECT e FROM Events e WHERE e.totalDue = :totalDue"),
    @NamedQuery(name = "Events.findByAddress", query = "SELECT e FROM Events e WHERE e.address = :address"),
    @NamedQuery(name = "Events.findByEventTime", query = "SELECT e FROM Events e WHERE e.eventTime = :eventTime")})
public class Events implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Event_Id")
    private Integer eventId;
    @Basic(optional = false)
    @Column(name = "Creation_Date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "Event_Date")
    @Temporal(TemporalType.DATE)
    private Date eventDate;
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Total_Due")
    private BigDecimal totalDue;
    @Column(name = "Address")
    private String address;
    @Column(name = "EventTime")
    private String eventTime;
    @JoinColumn(name = "Ballroom_Id", referencedColumnName = "Ballroom_Id")
    @ManyToOne(optional = false)
    private Ballrooms ballroomId;
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "Customer_Id", referencedColumnName = "Customer_Id")
    @ManyToOne(optional = false)
    private Customers customerId;

    public Events() {
    }

    public Events(Integer eventId) {
        this.eventId = eventId;
    }

    public Events(Integer eventId, Date creationDate, Date eventDate) {
        this.eventId = eventId;
        this.creationDate = creationDate;
        this.eventDate = eventDate;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Ballrooms getBallroomId() {
        return ballroomId;
    }

    public void setBallroomId(Ballrooms ballroomId) {
        this.ballroomId = ballroomId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eventComponent.Events[ eventId=" + eventId + " ]";
    }
    
}
