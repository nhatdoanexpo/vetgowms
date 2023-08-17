package vn.vetgo.wms.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vetgo.wms.domain.ProductAttribute} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductAttributeDTO implements Serializable {

    private Long id;

    private Long productId;

    private String attributeName;

    private String attributeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductAttributeDTO)) {
            return false;
        }

        ProductAttributeDTO productAttributeDTO = (ProductAttributeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productAttributeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductAttributeDTO{" +
            "id=" + getId() +
            ", productId=" + getProductId() +
            ", attributeName='" + getAttributeName() + "'" +
            ", attributeValue='" + getAttributeValue() + "'" +
            "}";
    }
}
