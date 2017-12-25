/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tinker.factory.findme.canonico;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author petervs
 */
@Entity
@Table(name = "puntos_servicio_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntosServicioProducto.findAll", query = "SELECT p FROM PuntosServicioProducto p")
    , @NamedQuery(name = "PuntosServicioProducto.findById", query = "SELECT p FROM PuntosServicioProducto p WHERE p.id = :id")
    , @NamedQuery(name = "PuntosServicioProducto.findByEstado", query = "SELECT p FROM PuntosServicioProducto p WHERE p.estado = :estado")
    , @NamedQuery(name = "PuntosServicioProducto.findByUsuarioCreacion", query = "SELECT p FROM PuntosServicioProducto p WHERE p.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "PuntosServicioProducto.findByFechaCreacion", query = "SELECT p FROM PuntosServicioProducto p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "PuntosServicioProducto.findByUsuarioModificacion", query = "SELECT p FROM PuntosServicioProducto p WHERE p.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "PuntosServicioProducto.findByFechaModificacion", query = "SELECT p FROM PuntosServicioProducto p WHERE p.fechaModificacion = :fechaModificacion")})
public class PuntosServicioProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 25)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 25)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Productos idProducto;
    @JoinColumn(name = "id_punto_servicio", referencedColumnName = "id")
    @ManyToOne
    private PuntosServicio idPuntoServicio;

    public PuntosServicioProducto() {
    }

    public PuntosServicioProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public PuntosServicio getIdPuntoServicio() {
        return idPuntoServicio;
    }

    public void setIdPuntoServicio(PuntosServicio idPuntoServicio) {
        this.idPuntoServicio = idPuntoServicio;
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
        if (!(object instanceof PuntosServicioProducto)) {
            return false;
        }
        PuntosServicioProducto other = (PuntosServicioProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tinker.findme.model.PuntosServicioProducto[ id=" + id + " ]";
    }
    
}
