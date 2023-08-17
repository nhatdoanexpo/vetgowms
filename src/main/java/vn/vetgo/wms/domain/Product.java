package vn.vetgo.wms.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "retailer_id")
    private Long retailerId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "allows_sale")
    private Boolean allowsSale;

    @Column(name = "description")
    private String description;

    @Column(name = "has_variants")
    private Boolean hasVariants;

    @Column(name = "is_active")
    private Boolean isActive;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Product id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public Product code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public Product name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRetailerId() {
        return this.retailerId;
    }

    public Product retailerId(Long retailerId) {
        this.setRetailerId(retailerId);
        return this;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Product categoryName(String categoryName) {
        this.setCategoryName(categoryName);
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getAllowsSale() {
        return this.allowsSale;
    }

    public Product allowsSale(Boolean allowsSale) {
        this.setAllowsSale(allowsSale);
        return this;
    }

    public void setAllowsSale(Boolean allowsSale) {
        this.allowsSale = allowsSale;
    }

    public String getDescription() {
        return this.description;
    }

    public Product description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasVariants() {
        return this.hasVariants;
    }

    public Product hasVariants(Boolean hasVariants) {
        this.setHasVariants(hasVariants);
        return this;
    }

    public void setHasVariants(Boolean hasVariants) {
        this.hasVariants = hasVariants;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Product isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", retailerId=" + getRetailerId() +
            ", categoryName='" + getCategoryName() + "'" +
            ", allowsSale='" + getAllowsSale() + "'" +
            ", description='" + getDescription() + "'" +
            ", hasVariants='" + getHasVariants() + "'" +
            ", isActive='" + getIsActive() + "'" +
            "}";
    }
}
