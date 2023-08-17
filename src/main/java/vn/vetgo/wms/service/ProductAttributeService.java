package vn.vetgo.wms.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.vetgo.wms.service.dto.ProductAttributeDTO;

/**
 * Service Interface for managing {@link vn.vetgo.wms.domain.ProductAttribute}.
 */
public interface ProductAttributeService {
    /**
     * Save a productAttribute.
     *
     * @param productAttributeDTO the entity to save.
     * @return the persisted entity.
     */
    ProductAttributeDTO save(ProductAttributeDTO productAttributeDTO);

    /**
     * Updates a productAttribute.
     *
     * @param productAttributeDTO the entity to update.
     * @return the persisted entity.
     */
    ProductAttributeDTO update(ProductAttributeDTO productAttributeDTO);

    /**
     * Partially updates a productAttribute.
     *
     * @param productAttributeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ProductAttributeDTO> partialUpdate(ProductAttributeDTO productAttributeDTO);

    /**
     * Get all the productAttributes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ProductAttributeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" productAttribute.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductAttributeDTO> findOne(Long id);

    /**
     * Delete the "id" productAttribute.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
