package vn.vetgo.wms.service.mapper;

import org.mapstruct.*;
import vn.vetgo.wms.domain.Category;
import vn.vetgo.wms.service.dto.CategoryDTO;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {}
