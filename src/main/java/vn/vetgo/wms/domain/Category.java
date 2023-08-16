package vn.vetgo.wms.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.*;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "retailer_id")
    private Long retailerId;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @Column(name = "parent_id")
    private Long parentId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Category id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public Category categoryId(Long categoryId) {
        this.setCategoryId(categoryId);
        return this;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Category categoryName(String categoryName) {
        this.setCategoryName(categoryName);
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getRetailerId() {
        return this.retailerId;
    }

    public Category retailerId(Long retailerId) {
        this.setRetailerId(retailerId);
        return this;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }

    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    public Category createdDate(ZonedDateTime createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public Category parentId(Long parentId) {
        this.setParentId(parentId);
        return this;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", categoryId=" + getCategoryId() +
            ", categoryName='" + getCategoryName() + "'" +
            ", retailerId=" + getRetailerId() +
            ", createdDate='" + getCreatedDate() + "'" +
            ", parentId=" + getParentId() +
            "}";
    }
}
