package ec.prueba.cobiscorp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link ec.prueba.cobiscorp.domain.Libro} entity.
 */
public class LibroDTO implements Serializable {

    private Long id;

    @Size(max = 150)
    private String nombre;

    @Size(max = 300)
    private String descripcion;

    @Size(max = 150)
    private String autor;

    private Instant fechaPublicacion;

    private Integer numeroEjemplares;

    private BigDecimal costo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Instant getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Instant fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(Integer numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LibroDTO)) {
            return false;
        }

        LibroDTO libroDTO = (LibroDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, libroDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LibroDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", autor='" + getAutor() + "'" +
            ", fechaPublicacion='" + getFechaPublicacion() + "'" +
            ", numeroEjemplares=" + getNumeroEjemplares() +
            ", costo=" + getCosto() +
            "}";
    }
}
