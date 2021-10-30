package ec.prueba.cobiscorp.service.mapper;

import ec.prueba.cobiscorp.domain.Libro;
import ec.prueba.cobiscorp.service.dto.LibroDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Libro} and its DTO {@link LibroDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LibroMapper extends EntityMapper<LibroDTO, Libro> {}
