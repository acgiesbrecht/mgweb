package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.List;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_grupos")
@Entity(name = "mgweb_TblGrupos")
public class TblGrupos extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 2442664486780191916L;
    @Column(name = "descripcion", nullable = false, length = 50)
    protected String descripcion;
    @JoinTable(name = "tbl_grupos_users",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    @ManyToMany
    protected List<TblUsers> tblUsers;

    public List<TblUsers> getTblUsers() {
        return tblUsers;
    }

    public void setTblUsers(List<TblUsers> tblUsers) {
        this.tblUsers = tblUsers;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}