/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tinker.factory.findme.canonico;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author petervs
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Productos.FIND_ALL_PRODUCTOS, query = "SELECT p FROM Productos p")
    , @NamedQuery(name = Productos.FIND_BY_NOMBRE, query = "SELECT p FROM Productos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = Productos.FIND_BY_ESTADO, query = "SELECT p FROM Productos p WHERE p.estado = :estado")
    , @NamedQuery(name = Productos.FIND_BY_NOMBRE_LIKE, query = "SELECT p FROM Productos p WHERE p.nombre LIKE :nombre AND p.estado = :estado")})
public class Productos implements Serializable {

    public static final String FIND_ALL_PRODUCTOS = "Productos.findAll";
    public static final String FIND_BY_NOMBRE = "Productos.findByNombre";
    public static final String FIND_BY_ESTADO = "Productos.findByEstado";
    public static final String FIND_BY_NOMBRE_LIKE = "Productos.findByNombreLike";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "El nombre del producto no puede ser vacio")
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "estado")
    private Integer estado;
    @Basic(optional = false)
    @NotNull(message = "El usuario de creacion del producto no puede ser vacio")
    @Size(min = 1, max = 25)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull(message = "La fecha de creacion del producto no puede ser vacio")
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 25)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "idProducto")
    private List<PuntosServicioProducto> puntosServicioProductoList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorias idCategoria;

    public Productos() {
    }

    public Productos(Integer id) {
        this.id = id;
    }

    public Productos(Integer id, String nombre, String usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<PuntosServicioProducto> getPuntosServicioProductoList() {
        return puntosServicioProductoList;
    }

    public void setPuntosServicioProductoList(List<PuntosServicioProducto> puntosServicioProductoList) {
        this.puntosServicioProductoList = puntosServicioProductoList;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tinker.findme.model.Productos[ id=" + id + " ]";
    }

}
