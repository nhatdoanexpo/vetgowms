package vn.vetgo.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vetgo.wms.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
