package org.mg.mgweb.service;

import com.haulmont.cuba.core.sys.AppContext;

public interface DatabaseService {
    String NAME = "mgweb_DatabaseService";

    void backup();

    void restore();

}