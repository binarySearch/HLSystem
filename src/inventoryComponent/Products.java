/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventoryComponent;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Products p WHERE p.productId = :productId"),
    @NamedQuery(name = "Products.findByBrandModel", query = "SELECT p FROM Products p WHERE p.brandModel = :brandModel"),
    @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description"),
    @NamedQuery(name = "Products.findByRentingPrice", query = "SELECT p FROM Products p WHERE p.rentingPrice = :rentingPrice"),
    @NamedQuery(name = "Products.findByQuantity", query = "SELECT p FROM Products p WHERE p.quantity = :quantity")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Product_Id")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "Brand_Model")
    private String brandModel;
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Renting_Price")
    private BigDecimal rentingPrice;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "Brand_Id", referencedColumnName = "Brand_Id")
    @ManyToOne(optional = false)
    private Brands brandId;
    @JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id")
    @ManyToOne(optional = false)
    private Categories categoryId;

    public Products() {
    }

    public Products(Integer productId) {
        this.productId = productId;
    }

    public Products(Integer productId, String brandModel, int quantity) {
        this.productId = productId;
        this.brandModel = brandModel;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRentingPrice() {
        return rentingPrice;
    }

    public void setRentingPrice(BigDecimal rentingPrice) {
        this.rentingPrice = rentingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brands getBrandId() {
        return brandId;
    }

    public void setBrandId(Brands brandId) {
        this.brandId = brandId;
    }

    public Categories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categories categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventoryComponent.Products[ productId=" + productId + " ]";
    }
    
}
