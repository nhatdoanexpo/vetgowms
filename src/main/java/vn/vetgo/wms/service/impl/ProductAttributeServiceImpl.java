package vn.vetgo.wms.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vetgo.wms.domain.ProductAttribute;
import vn.vetgo.wms.repository.ProductAttributeRepository;
import vn.vetgo.wms.service.ProductAttributeService;
import vn.vetgo.wms.service.dto.ProductAttributeDTO;
import vn.vetgo.wms.service.mapper.ProductAttributeMapper;

/**
 * Service Implementation for managing {@link ProductAttribute}.
 */
@Service
@Transactional
public class ProductAttributeServiceImpl implements ProductAttributeService {

    private final Logger log = LoggerFactory.getLogger(ProductAttributeServiceImpl.class);

    private final ProductAttributeRepository productAttributeRepository;

    private final ProductAttributeMapper productAttributeMapper;

    public ProductAttributeServiceImpl(
        ProductAttributeRepository productAttributeRepository,
        ProductAttributeMapper productAttributeMapper
    ) {
        this.productAttributeRepository = productAttributeRepository;
        this.productAttributeMapper = productAttributeMapper;
    }

    @Override
    public ProductAttributeDTO save(ProductAttributeDTO productAttributeDTO) {
        log.debug("Request to save ProductAttribute : {}", productAttributeDTO);
        ProductAttribute productAttribute = productAttributeMapper.toEntity(productAttributeDTO);
        productAttribute = productAttributeRepository.save(productAttribute);
        return productAttributeMapper.toDto(productAttribute);
    }

    @Override
    public ProductAttributeDTO update(ProductAttributeDTO productAttributeDTO) {
        log.debug("Request to update ProductAttribute : {}", productAttributeDTO);
        ProductAttribute productAttribute = productAttributeMapper.toEntity(productAttributeDTO);
        productAttribute = productAttributeRepository.save(productAttribute);
        return productAttributeMapper.toDto(productAttribute);
    }

    @Override
    public Optional<ProductAttributeDTO> partialUpdate(ProductAttributeDTO productAttributeDTO) {
        log.debug("Request to partially update ProductAttribute : {}", productAttributeDTO);

        return productAttributeRepository
            .findById(productAttributeDTO.getId())
            .map(existingProductAttribute -> {
                productAttributeMapper.partialUpdate(existingProductAttribute, productAttributeDTO);

                return existingProductAttribute;
            })
            .map(productAttributeRepository::save)
            .map(productAttributeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductAttributeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProductAttributes");
        return productAttributeRepository.findAll(pageable).map(productAttributeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductAttributeDTO> findOne(Long id) {
        log.debug("Request to get ProductAttribute : {}", id);
        return productAttributeRepository.findById(id).map(productAttributeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductAttribute : {}", id);
        productAttributeRepository.deleteById(id);
    }
}
