package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.List;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_roles")
@Entity(name = "mgweb_TblRoles")
public class TblRoles extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -8607605492074575335L;
    @Column(name = "descripcion", nullable = false, length = 50)
    protected String descripcion;
    @JoinTable(name = "tbl_roles_users",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblUsers> tblUsers;

    public List<org.mg.mgweb.entity.TblUsers> getTblUsers() {
        return tblUsers;
    }

    public void setTblUsers(List<org.mg.mgweb.entity.TblUsers> tblUsers) {
        this.tblUsers = tblUsers;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}