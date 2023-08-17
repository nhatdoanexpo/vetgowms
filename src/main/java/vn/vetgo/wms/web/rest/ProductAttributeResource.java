package vn.vetgo.wms.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;
import vn.vetgo.wms.repository.ProductAttributeRepository;
import vn.vetgo.wms.service.ProductAttributeService;
import vn.vetgo.wms.service.dto.ProductAttributeDTO;
import vn.vetgo.wms.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link vn.vetgo.wms.domain.ProductAttribute}.
 */
@RestController
@RequestMapping("/api")
public class ProductAttributeResource {

    private final Logger log = LoggerFactory.getLogger(ProductAttributeResource.class);

    private static final String ENTITY_NAME = "productAttribute";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProductAttributeService productAttributeService;

    private final ProductAttributeRepository productAttributeRepository;

    public ProductAttributeResource(
        ProductAttributeService productAttributeService,
        ProductAttributeRepository productAttributeRepository
    ) {
        this.productAttributeService = productAttributeService;
        this.productAttributeRepository = productAttributeRepository;
    }

    /**
     * {@code POST  /product-attributes} : Create a new productAttribute.
     *
     * @param productAttributeDTO the productAttributeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productAttributeDTO, or with status {@code 400 (Bad Request)} if the productAttribute has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/product-attributes")
    public ResponseEntity<ProductAttributeDTO> createProductAttribute(@RequestBody ProductAttributeDTO productAttributeDTO)
        throws URISyntaxException {
        log.debug("REST request to save ProductAttribute : {}", productAttributeDTO);
        if (productAttributeDTO.getId() != null) {
            throw new BadRequestAlertException("A new productAttribute cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProductAttributeDTO result = productAttributeService.save(productAttributeDTO);
        return ResponseEntity
            .created(new URI("/api/product-attributes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /product-attributes/:id} : Updates an existing productAttribute.
     *
     * @param id the id of the productAttributeDTO to save.
     * @param productAttributeDTO the productAttributeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productAttributeDTO,
     * or with status {@code 400 (Bad Request)} if the productAttributeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productAttributeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/product-attributes/{id}")
    public ResponseEntity<ProductAttributeDTO> updateProductAttribute(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProductAttributeDTO productAttributeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ProductAttribute : {}, {}", id, productAttributeDTO);
        if (productAttributeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, productAttributeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!productAttributeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ProductAttributeDTO result = productAttributeService.update(productAttributeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, productAttributeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /product-attributes/:id} : Partial updates given fields of an existing productAttribute, field will ignore if it is null
     *
     * @param id the id of the productAttributeDTO to save.
     * @param productAttributeDTO the productAttributeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productAttributeDTO,
     * or with status {@code 400 (Bad Request)} if the productAttributeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the productAttributeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the productAttributeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/product-attributes/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ProductAttributeDTO> partialUpdateProductAttribute(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProductAttributeDTO productAttributeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProductAttribute partially : {}, {}", id, productAttributeDTO);
        if (productAttributeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, productAttributeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!productAttributeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ProductAttributeDTO> result = productAttributeService.partialUpdate(productAttributeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, productAttributeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /product-attributes} : get all the productAttributes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productAttributes in body.
     */
    @GetMapping("/product-attributes")
    public ResponseEntity<List<ProductAttributeDTO>> getAllProductAttributes(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ProductAttributes");
        Page<ProductAttributeDTO> page = productAttributeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /product-attributes/:id} : get the "id" productAttribute.
     *
     * @param id the id of the productAttributeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productAttributeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/product-attributes/{id}")
    public ResponseEntity<ProductAttributeDTO> getProductAttribute(@PathVariable Long id) {
        log.debug("REST request to get ProductAttribute : {}", id);
        Optional<ProductAttributeDTO> productAttributeDTO = productAttributeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productAttributeDTO);
    }

    /**
     * {@code DELETE  /product-attributes/:id} : delete the "id" productAttribute.
     *
     * @param id the id of the productAttributeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/product-attributes/{id}")
    public ResponseEntity<Void> deleteProductAttribute(@PathVariable Long id) {
        log.debug("REST request to delete ProductAttribute : {}", id);
        productAttributeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
