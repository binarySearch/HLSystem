/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventComponent;

import inventoryComponent.Products;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armando
 */
@Entity
@Table(name = "event_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventMaterial.findAll", query = "SELECT e FROM EventMaterial e"),
    @NamedQuery(name = "EventMaterial.findById", query = "SELECT e FROM EventMaterial e WHERE e.id = :id"),
    @NamedQuery(name = "EventMaterial.findByQuantity", query = "SELECT e FROM EventMaterial e WHERE e.quantity = :quantity")})
public class EventMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "Event_Id", referencedColumnName = "Event_Id")
    @ManyToOne(optional = false)
    private Events eventId;
    @JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
    @ManyToOne(optional = false)
    private Products productId;

    public EventMaterial() {
    }

    public EventMaterial(Integer id) {
        this.id = id;
    }

    public EventMaterial(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Events getEventId() {
        return eventId;
    }

    public void setEventId(Events eventId) {
        this.eventId = eventId;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
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
        if (!(object instanceof EventMaterial)) {
            return false;
        }
        EventMaterial other = (EventMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eventComponent.EventMaterial[ id=" + id + " ]";
    }
    
}
