package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_database_updates")
@Entity(name = "mgweb_TblDatabaseUpdates")
public class TblDatabaseUpdates extends BaseStringIdEntity {
    private static final long serialVersionUID = 6151988846803165579L;
    @Id
    @Column(name = "id", nullable = false, length = 50)
    protected String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}