package ec.prueba.cobiscorp.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BigDecimalFilter;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.InstantFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link ec.prueba.cobiscorp.domain.Libro} entity. This class is used
 * in {@link ec.prueba.cobiscorp.web.rest.LibroResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /libros?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class LibroCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nombre;

    private StringFilter descripcion;

    private StringFilter autor;

    private InstantFilter fechaPublicacion;

    private IntegerFilter numeroEjemplares;

    private BigDecimalFilter costo;

    private Boolean distinct;

    public LibroCriteria() {}

    public LibroCriteria(LibroCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nombre = other.nombre == null ? null : other.nombre.copy();
        this.descripcion = other.descripcion == null ? null : other.descripcion.copy();
        this.autor = other.autor == null ? null : other.autor.copy();
        this.fechaPublicacion = other.fechaPublicacion == null ? null : other.fechaPublicacion.copy();
        this.numeroEjemplares = other.numeroEjemplares == null ? null : other.numeroEjemplares.copy();
        this.costo = other.costo == null ? null : other.costo.copy();
        this.distinct = other.distinct;
    }

    @Override
    public LibroCriteria copy() {
        return new LibroCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNombre() {
        return nombre;
    }

    public StringFilter nombre() {
        if (nombre == null) {
            nombre = new StringFilter();
        }
        return nombre;
    }

    public void setNombre(StringFilter nombre) {
        this.nombre = nombre;
    }

    public StringFilter getDescripcion() {
        return descripcion;
    }

    public StringFilter descripcion() {
        if (descripcion == null) {
            descripcion = new StringFilter();
        }
        return descripcion;
    }

    public void setDescripcion(StringFilter descripcion) {
        this.descripcion = descripcion;
    }

    public StringFilter getAutor() {
        return autor;
    }

    public StringFilter autor() {
        if (autor == null) {
            autor = new StringFilter();
        }
        return autor;
    }

    public void setAutor(StringFilter autor) {
        this.autor = autor;
    }

    public InstantFilter getFechaPublicacion() {
        return fechaPublicacion;
    }

    public InstantFilter fechaPublicacion() {
        if (fechaPublicacion == null) {
            fechaPublicacion = new InstantFilter();
        }
        return fechaPublicacion;
    }

    public void setFechaPublicacion(InstantFilter fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public IntegerFilter getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public IntegerFilter numeroEjemplares() {
        if (numeroEjemplares == null) {
            numeroEjemplares = new IntegerFilter();
        }
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(IntegerFilter numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public BigDecimalFilter getCosto() {
        return costo;
    }

    public BigDecimalFilter costo() {
        if (costo == null) {
            costo = new BigDecimalFilter();
        }
        return costo;
    }

    public void setCosto(BigDecimalFilter costo) {
        this.costo = costo;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LibroCriteria that = (LibroCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nombre, that.nombre) &&
            Objects.equals(descripcion, that.descripcion) &&
            Objects.equals(autor, that.autor) &&
            Objects.equals(fechaPublicacion, that.fechaPublicacion) &&
            Objects.equals(numeroEjemplares, that.numeroEjemplares) &&
            Objects.equals(costo, that.costo) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, autor, fechaPublicacion, numeroEjemplares, costo, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LibroCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nombre != null ? "nombre=" + nombre + ", " : "") +
            (descripcion != null ? "descripcion=" + descripcion + ", " : "") +
            (autor != null ? "autor=" + autor + ", " : "") +
            (fechaPublicacion != null ? "fechaPublicacion=" + fechaPublicacion + ", " : "") +
            (numeroEjemplares != null ? "numeroEjemplares=" + numeroEjemplares + ", " : "") +
            (costo != null ? "costo=" + costo + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
