/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventoryComponent;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armando
 */
@Entity
@Table(name = "brands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brands.findAll", query = "SELECT b FROM Brands b"),
    @NamedQuery(name = "Brands.findByBrandId", query = "SELECT b FROM Brands b WHERE b.brandId = :brandId"),
    @NamedQuery(name = "Brands.findByBrandName", query = "SELECT b FROM Brands b WHERE b.brandName = :brandName")})
public class Brands implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Brand_Id")
    private Integer brandId;
    @Basic(optional = false)
    @Column(name = "Brand_Name")
    private String brandName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandId")
    private Collection<Products> productsCollection;

    public Brands() {
    }

    public Brands(Integer brandId) {
        this.brandId = brandId;
    }

    public Brands(Integer brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandId != null ? brandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brands)) {
            return false;
        }
        Brands other = (Brands) object;
        if ((this.brandId == null && other.brandId != null) || (this.brandId != null && !this.brandId.equals(other.brandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventoryComponent.Brands[ brandId=" + brandId + " ]";
    }
    
}
