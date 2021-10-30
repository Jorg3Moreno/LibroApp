package ec.prueba.cobiscorp.repository;

import ec.prueba.cobiscorp.domain.Libro;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Libro entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>, JpaSpecificationExecutor<Libro> {}
