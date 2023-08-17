package vn.vetgo.wms.service.mapper;

import org.mapstruct.*;
import vn.vetgo.wms.domain.Product;
import vn.vetgo.wms.service.dto.ProductDTO;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {}
