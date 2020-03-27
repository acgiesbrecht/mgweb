package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.List;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_users")
@Entity(name = "mgweb_TblUsers")
public class TblUsers extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 4984513980976089263L;
    @Column(name = "nombre", nullable = false, length = 50)
    protected String nombre;
    @Column(name = "nombrecompleto", nullable = false, length = 100)
    protected String nombrecompleto;
    @Column(name = "password", nullable = false, length = 100)
    protected String password;
    @JoinTable(name = "tbl_grupos_users",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_grupo"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblGrupos> tblGrupos;
    @JoinTable(name = "tbl_roles_users",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    @ManyToMany
    protected List<TblRoles> tblRoles;

    public List<TblRoles> getTblRoles() {
        return tblRoles;
    }

    public void setTblRoles(List<TblRoles> tblRoles) {
        this.tblRoles = tblRoles;
    }

    public List<org.mg.mgweb.entity.TblGrupos> getTblGrupos() {
        return tblGrupos;
    }

    public void setTblGrupos(List<org.mg.mgweb.entity.TblGrupos> tblGrupos) {
        this.tblGrupos = tblGrupos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}