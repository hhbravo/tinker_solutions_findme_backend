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
import java.util.Date;
import java.util.List;

/**
 *
 * @author petervs
 */
@Entity
@Table(name = "puntos_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntosServicio.findAll", query = "SELECT p FROM PuntosServicio p")
    , @NamedQuery(name = "PuntosServicio.findById", query = "SELECT p FROM PuntosServicio p WHERE p.id = :id")
    , @NamedQuery(name = "PuntosServicio.findByNombre", query = "SELECT p FROM PuntosServicio p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PuntosServicio.findByComentario", query = "SELECT p FROM PuntosServicio p WHERE p.comentario = :comentario")
    , @NamedQuery(name = "PuntosServicio.findByLatitud", query = "SELECT p FROM PuntosServicio p WHERE p.latitud = :latitud")
    , @NamedQuery(name = "PuntosServicio.findByLongitud", query = "SELECT p FROM PuntosServicio p WHERE p.longitud = :longitud")
    , @NamedQuery(name = "PuntosServicio.findByDireccion", query = "SELECT p FROM PuntosServicio p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "PuntosServicio.findByEstado", query = "SELECT p FROM PuntosServicio p WHERE p.estado = :estado")
    , @NamedQuery(name = "PuntosServicio.findByUsuarioCreacion", query = "SELECT p FROM PuntosServicio p WHERE p.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "PuntosServicio.findByFechaCreacion", query = "SELECT p FROM PuntosServicio p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "PuntosServicio.findByUsuarioModificacion", query = "SELECT p FROM PuntosServicio p WHERE p.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "PuntosServicio.findByFechaModificacion", query = "SELECT p FROM PuntosServicio p WHERE p.fechaModificacion = :fechaModificacion")})
public class PuntosServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "longitud")
    private String longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 25)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "idPuntoServicio")
    private List<PuntosServicioProducto> puntosServicioProductoList;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne
    private Empresas empresaId;

    public PuntosServicio() {
    }

    public PuntosServicio(Integer id) {
        this.id = id;
    }

    public PuntosServicio(Integer id, String nombre, String latitud, String longitud, String direccion, int estado, String usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.estado = estado;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
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

    public Empresas getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresas empresaId) {
        this.empresaId = empresaId;
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
        if (!(object instanceof PuntosServicio)) {
            return false;
        }
        PuntosServicio other = (PuntosServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tinker.findme.model.PuntosServicio[ id=" + id + " ]";
    }
    
}
