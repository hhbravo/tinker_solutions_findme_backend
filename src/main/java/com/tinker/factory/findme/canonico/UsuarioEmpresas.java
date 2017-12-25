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
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author petervs
 */
@Entity
@Table(name = "usuario_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioEmpresas.findAll", query = "SELECT u FROM UsuarioEmpresas u")
    , @NamedQuery(name = "UsuarioEmpresas.findById", query = "SELECT u FROM UsuarioEmpresas u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioEmpresas.findByEstado", query = "SELECT u FROM UsuarioEmpresas u WHERE u.estado = :estado")
    , @NamedQuery(name = "UsuarioEmpresas.findByUsuarioCreacion", query = "SELECT u FROM UsuarioEmpresas u WHERE u.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "UsuarioEmpresas.findByFechaCreacion", query = "SELECT u FROM UsuarioEmpresas u WHERE u.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "UsuarioEmpresas.findByUsuarioModificacion", query = "SELECT u FROM UsuarioEmpresas u WHERE u.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "UsuarioEmpresas.findByFechaModificacion", query = "SELECT u FROM UsuarioEmpresas u WHERE u.fechaModificacion = :fechaModificacion")})
public class UsuarioEmpresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresas idEmpresa;

    public UsuarioEmpresas() {
    }

    public UsuarioEmpresas(Integer id) {
        this.id = id;
    }

    public UsuarioEmpresas(Integer id, int estado, String usuarioCreacion, Date fechaCreacion) {
        this.id = id;
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

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
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
        if (!(object instanceof UsuarioEmpresas)) {
            return false;
        }
        UsuarioEmpresas other = (UsuarioEmpresas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tinker.findme.model.UsuarioEmpresas[ id=" + id + " ]";
    }
    
}
