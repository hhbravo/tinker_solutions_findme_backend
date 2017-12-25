package com.tinker.factory.findme.canonico;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserRol")
@NamedQuery(name = "UserRol.findAll", query = "SELECT u FROM UserRol u")
public class UserRol implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8253391951594175096L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rol_id")
    private Integer useRolId;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Integer getUseRolId() {
        return useRolId;
    }

    public void setUseRolId(Integer useRolId) {
        this.useRolId = useRolId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
