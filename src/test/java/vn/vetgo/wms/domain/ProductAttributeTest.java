package vn.vetgo.wms.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import vn.vetgo.wms.web.rest.TestUtil;

class ProductAttributeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductAttribute.class);
        ProductAttribute productAttribute1 = new ProductAttribute();
        productAttribute1.setId(1L);
        ProductAttribute productAttribute2 = new ProductAttribute();
        productAttribute2.setId(productAttribute1.getId());
        assertThat(productAttribute1).isEqualTo(productAttribute2);
        productAttribute2.setId(2L);
        assertThat(productAttribute1).isNotEqualTo(productAttribute2);
        productAttribute1.setId(null);
        assertThat(productAttribute1).isNotEqualTo(productAttribute2);
    }
}
