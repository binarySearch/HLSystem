/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package locationComponent;

import eventComponent.Events;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armando
 */
@Entity
@Table(name = "ballrooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ballrooms.findAll", query = "SELECT b FROM Ballrooms b"),
    @NamedQuery(name = "Ballrooms.findByBallroomId", query = "SELECT b FROM Ballrooms b WHERE b.ballroomId = :ballroomId"),
    @NamedQuery(name = "Ballrooms.findByBallroomName", query = "SELECT b FROM Ballrooms b WHERE b.ballroomName = :ballroomName"),
    @NamedQuery(name = "Ballrooms.findByAddress", query = "SELECT b FROM Ballrooms b WHERE b.address = :address")})
public class Ballrooms implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ballroomId")
    private Collection<Events> eventsCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Ballroom_Id")
    private Integer ballroomId;
    @Column(name = "Ballroom_Name")
    private String ballroomName;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;

    public Ballrooms() {
    }

    public Ballrooms(Integer ballroomId) {
        this.ballroomId = ballroomId;
    }

    public Ballrooms(Integer ballroomId, String address) {
        this.ballroomId = ballroomId;
        this.address = address;
    }

    public Integer getBallroomId() {
        return ballroomId;
    }

    public void setBallroomId(Integer ballroomId) {
        Integer oldBallroomId = this.ballroomId;
        this.ballroomId = ballroomId;
        changeSupport.firePropertyChange("ballroomId", oldBallroomId, ballroomId);
    }

    public String getBallroomName() {
        return ballroomName;
    }

    public void setBallroomName(String ballroomName) {
        String oldBallroomName = this.ballroomName;
        this.ballroomName = ballroomName;
        changeSupport.firePropertyChange("ballroomName", oldBallroomName, ballroomName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ballroomId != null ? ballroomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ballrooms)) {
            return false;
        }
        Ballrooms other = (Ballrooms) object;
        if ((this.ballroomId == null && other.ballroomId != null) || (this.ballroomId != null && !this.ballroomId.equals(other.ballroomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "locationComponent.Ballrooms[ ballroomId=" + ballroomId + " ]";
    }

    @XmlTransient
    public Collection<Events> getEventsCollection() {
        return eventsCollection;
    }

    public void setEventsCollection(Collection<Events> eventsCollection) {
        this.eventsCollection = eventsCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
