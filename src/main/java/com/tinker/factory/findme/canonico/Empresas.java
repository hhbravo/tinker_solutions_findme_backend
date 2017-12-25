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
 * @author petervs
 */
@Entity
@Table(name = "empresas")
public class Empresas implements Serializable {

    public static final String FIND_BY_NOMBRE_LIKE = "Empresas.findByNombreLike";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull(message = "El nombre de la empresa no puede ser vacio")
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull(message = "La razon social de la empresa no puede ser vacio")
    @Size(min = 1, max = 150)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull(message = "El ruc de la empresa no puede ser vacio")
    @Size(min = 1, max = 11, message = "El ruc de la empresa debe tener 11 caracteres")
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull(message = "La direccion de la empresa no puede ser vacio")
    @Size(min = 1, max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull(message = "El telefono de la empresa no puede ser vacio")
    @Column(name = "telefono")
    private int telefono;
    @Size(max = 255)
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Size(max = 255)
    @Column(name = "imagen_logo")
    private String imagenLogo;
    @Basic(optional = false)
    @NotNull(message = "El estado de la empresa no puede ser vacio")
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull(message = "El usuario de creacion de la empresa no puede ser vacio")
    @Size(min = 1, max = 25)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull(message = "La fecha de creacion de la empresa no puede ser vacio")
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 25)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;


    public Empresas() {
    }

    public Empresas(Long id) {
        this.id = id;
    }

    public Empresas(Long id, String nombre, String razonSocial, String ruc, String direccion, int telefono, int estado, String usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getImagenLogo() {
        return imagenLogo;
    }

    public void setImagenLogo(String imagenLogo) {
        this.imagenLogo = imagenLogo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tinker.findme.model.Empresas[ id=" + id + " ]";
    }

}
