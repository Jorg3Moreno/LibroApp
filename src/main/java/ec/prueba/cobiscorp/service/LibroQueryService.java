package ec.prueba.cobiscorp.service;

import ec.prueba.cobiscorp.domain.*; // for static metamodels
import ec.prueba.cobiscorp.domain.Libro;
import ec.prueba.cobiscorp.repository.LibroRepository;
import ec.prueba.cobiscorp.service.criteria.LibroCriteria;
import ec.prueba.cobiscorp.service.dto.LibroDTO;
import ec.prueba.cobiscorp.service.mapper.LibroMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Libro} entities in the database.
 * The main input is a {@link LibroCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link LibroDTO} or a {@link Page} of {@link LibroDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class LibroQueryService extends QueryService<Libro> {

    private final Logger log = LoggerFactory.getLogger(LibroQueryService.class);

    private final LibroRepository libroRepository;

    private final LibroMapper libroMapper;

    public LibroQueryService(LibroRepository libroRepository, LibroMapper libroMapper) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
    }

    /**
     * Return a {@link List} of {@link LibroDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<LibroDTO> findByCriteria(LibroCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Libro> specification = createSpecification(criteria);
        return libroMapper.toDto(libroRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link LibroDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<LibroDTO> findByCriteria(LibroCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Libro> specification = createSpecification(criteria);
        return libroRepository.findAll(specification, page).map(libroMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(LibroCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Libro> specification = createSpecification(criteria);
        return libroRepository.count(specification);
    }

    /**
     * Function to convert {@link LibroCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Libro> createSpecification(LibroCriteria criteria) {
        Specification<Libro> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Libro_.id));
            }
            if (criteria.getNombre() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNombre(), Libro_.nombre));
            }
            if (criteria.getDescripcion() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescripcion(), Libro_.descripcion));
            }
            if (criteria.getAutor() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAutor(), Libro_.autor));
            }
            if (criteria.getFechaPublicacion() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFechaPublicacion(), Libro_.fechaPublicacion));
            }
            if (criteria.getNumeroEjemplares() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNumeroEjemplares(), Libro_.numeroEjemplares));
            }
            if (criteria.getCosto() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCosto(), Libro_.costo));
            }
        }
        return specification;
    }
}
