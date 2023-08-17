package vn.vetgo.wms.service.mapper;

import org.mapstruct.*;
import vn.vetgo.wms.domain.ProductAttribute;
import vn.vetgo.wms.service.dto.ProductAttributeDTO;

/**
 * Mapper for the entity {@link ProductAttribute} and its DTO {@link ProductAttributeDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductAttributeMapper extends EntityMapper<ProductAttributeDTO, ProductAttribute> {}
