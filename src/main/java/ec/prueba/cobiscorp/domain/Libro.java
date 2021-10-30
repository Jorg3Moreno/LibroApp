package ec.prueba.cobiscorp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Size(max = 150)
    @Column(name = "nombre", length = 150, unique = true)
    private String nombre;

    @Size(max = 300)
    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Size(max = 150)
    @Column(name = "autor", length = 150)
    private String autor;

    @Column(name = "fecha_publicacion")
    private Instant fechaPublicacion;

    @Column(name = "numero_ejemplares")
    private Integer numeroEjemplares;

    @Column(name = "costo", precision = 21, scale = 4)
    private BigDecimal costo;

    public Long getId() {
        return this.id;
    }

    public Libro id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Libro nombre(String nombre) {
        this.setNombre(nombre);
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Libro descripcion(String descripcion) {
        this.setDescripcion(descripcion);
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return this.autor;
    }

    public Libro autor(String autor) {
        this.setAutor(autor);
        return this;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Instant getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    public Libro fechaPublicacion(Instant fechaPublicacion) {
        this.setFechaPublicacion(fechaPublicacion);
        return this;
    }

    public void setFechaPublicacion(Instant fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getNumeroEjemplares() {
        return this.numeroEjemplares;
    }

    public Libro numeroEjemplares(Integer numeroEjemplares) {
        this.setNumeroEjemplares(numeroEjemplares);
        return this;
    }

    public void setNumeroEjemplares(Integer numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public BigDecimal getCosto() {
        return this.costo;
    }

    public Libro costo(BigDecimal costo) {
        this.setCosto(costo);
        return this;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Libro)) {
            return false;
        }
        return id != null && id.equals(((Libro) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return (
            "Libro{" +
            "id=" +
            getId() +
            ", nombre='" +
            getNombre() +
            "'" +
            ", descripcion='" +
            getDescripcion() +
            "'" +
            ", autor='" +
            getAutor() +
            "'" +
            ", fechaPublicacion='" +
            getFechaPublicacion() +
            "'" +
            ", numeroEjemplares=" +
            getNumeroEjemplares() +
            ", costo=" +
            getCosto() +
            "}"
        );
    }
}
